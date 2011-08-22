package com.dmma.dashboard.app.controllers;

import java.util.List;

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

import com.dmma.dashboard.app.models.GetChangedModel;
import com.dmma.dashboard.core.entities.dto.OfficeBrokerEstate;
import com.dmma.dashboard.midas.MidasClient;
import com.dmma.dashboard.midas.errors.NoSuchBrokerFound;
import com.dmma.dashboard.midas.errors.NoSuchBrokerInOffice;
import com.dmma.dashboard.midas.errors.NoSuchOfficeFound;



@Controller
@RequestMapping("/getChanged")
public class MidasGetChangedController{
	private static final Logger log = LoggerFactory.getLogger(MidasGetChangedController.class); 
	
	@Autowired
	private MidasClient midasClient;
	
	private GetChangedModel getChangedModel;
	
	@RequestMapping()
	public String setupForm(ModelMap model) {
		log.info("setupForm method");
		getChangedModel = new GetChangedModel();
		getChangedModel.setMinutes(200);
		model.addAttribute("getChangedModel", getChangedModel);
		return "getChanged";
	}


	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(ModelMap model, @ModelAttribute("getChangedModel") GetChangedModel getChangedModel, BindingResult result, HttpServletRequest request) {
		log.info("submitForm method");
		List<OfficeBrokerEstate> listOfInfo = null;
		try {
			listOfInfo = midasClient.getLastOfficeBrokerEstates(getChangedModel.getMinutes());
		} catch (NoSuchBrokerFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchOfficeFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchBrokerInOffice e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("listOfInfo", listOfInfo);
		return "getChanged";
	}
}
