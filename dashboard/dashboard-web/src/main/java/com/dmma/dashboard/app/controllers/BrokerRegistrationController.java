package com.dmma.dashboard.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmma.dashboard.app.models.RegistrationModel;
import com.dmma.dashboard.app.validators.RegistrationValidator;
import com.dmma.dashboard.core.configuration.AppProperties;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.services.BrokerService;
import com.dmma.dashboard.midas.MidasClient;
import com.dmma.dashboard.midas.errors.NoSuchBrokerFound;
import com.dmma.dashboard.midas.errors.NoSuchBrokerInOffice;
import com.dmma.dashboard.midas.errors.NoSuchOfficeFound;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;



@Controller
@RequestMapping("/brokerRegistration")
public class BrokerRegistrationController{
	private static final Logger log = LoggerFactory.getLogger(BrokerRegistrationController.class); 
	
	@Autowired
	private RegistrationValidator registrationValidator;
	
	@Autowired
	private MidasClient midasClient;
	
	@Autowired
	private BrokerService brokerService;
	
	private RegistrationModel registrationModel;
	private Broker brokerFromMidas;
	
	@RequestMapping()
	public String setupForm(ModelMap model) {
		log.info("setupForm method");
		registrationModel = new RegistrationModel();
		brokerFromMidas   = null;
		model.addAttribute("registrationModel", registrationModel);
		model.addAttribute("brokerFromMidas", brokerFromMidas);
		return "brokerRegistration";
	}


	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(ModelMap model, @ModelAttribute("registrationModel") RegistrationModel registrationModel, BindingResult result, HttpServletRequest request) {
		log.info("submitForm method");
		registrationValidator.validate(registrationModel, result);
		if (result.hasErrors())
			return "brokerRegistration";
		if(!testIsCaptchaCorrect(registrationModel, request, result))
			return "brokerRegistration";
		if(!registrationModel.getPassword1().equals(registrationModel.getPassword2())){
			result.rejectValue("password2",  "registration.error.password2NotMatch", "not match");
			return "brokerRegistration";
		}
		if(testIsUserExist(registrationModel, result))
			return "brokerRegistration";
		
		
		try {
			brokerFromMidas = midasClient.getBrokerWithOffice(registrationModel.getMidasbrokerid(), registrationModel.getMidasofficeid());
		} catch (NoSuchBrokerFound e) {
			result.rejectValue("midasbrokerid",  "registration.error.noSuchBrokerFound", "not found");
			return "brokerRegistration";
		} catch (NoSuchOfficeFound e) {
			result.rejectValue("midasofficeid",  "registration.error.noSuchOfficeFound", "not found");
			return "brokerRegistration";
		} catch (NoSuchBrokerInOffice e) {
			result.rejectValue("midasbrokerid",  "registration.error.noSuchBrokerInOffice", "no broker in office");
			return "brokerRegistration";
		}
		
		if(!brokerFromMidas.getEmail().equals(registrationModel.getEmail())){
			result.rejectValue("email",  "registration.error.emailNotMatch", "Email address is not valid");
			return "brokerRegistration";
		}
		
		this.registrationModel = registrationModel;
		model.put("brokerFromMidas", brokerFromMidas);
		return "brokerRegistration";
	
	}
	
	@RequestMapping(value = "/brokerRegistrationConfirm", method = RequestMethod.POST)
	public String confirmForm(){
		log.info("confirmForm - let's register broker");
		
		String password = registrationModel.getPassword1();
		brokerService.processNewRegistration(brokerFromMidas,password);
		
		return "redirect:/brokerRegistrationDone.do";
	}
	
	

	private boolean testIsCaptchaCorrect(RegistrationModel model,	HttpServletRequest request, BindingResult result) {
		if(AppProperties.ignoreJCaptcha) return true;
		String captcha = model.getJcaptcha();
		model.setJcaptcha("");

		//boolean captchaPassed = true;
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, captcha);
		
		if(!captchaPassed){
			result.rejectValue("jcaptcha",  "registration.error.jcaptcha", "not valid");
			return false;
		}
		return true;
	}

	private boolean testIsUserExist(RegistrationModel registrationModel, BindingResult result) {
		Broker testBroker = brokerService.findByMidasId(registrationModel.getMidasbrokerid());
		if(testBroker!=null){
			result.rejectValue("midasbrokerid",  "registration.error.loginExist", "midasid alredy registered");
			return true;
		}else
			return false;
		
	}
}
