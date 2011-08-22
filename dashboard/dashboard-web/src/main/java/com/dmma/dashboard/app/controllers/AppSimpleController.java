package com.dmma.dashboard.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppSimpleController {
	
	
	@RequestMapping("/about.do")
	public String handleAboutRequest(ModelMap model){
		model.addAttribute("currentUrl", "about");
		return "about";
	}
	
	@RequestMapping("/brokerRegistrationDone.do")
	public String handleRegistrationDoneRequest(ModelMap model){
		model.addAttribute("currentUrl", "brokerRegistrationDone");
		return "brokerRegistrationDone";
	}
	
	
	@RequestMapping("/broker.do")
	public String handleBrokerRequest(ModelMap model){
		model.addAttribute("currentUrl", "broker");
		return "broker";
	}
	
	@RequestMapping("/banker.do")
	public String handleBankerRequest(ModelMap model){
		model.addAttribute("currentUrl", "banker");
		return "banker";
	}
	
	@RequestMapping("/admin.do")
	public String handleDashboardNoRequest(ModelMap model){
		model.addAttribute("currentUrl", "admin");
		return "admin";
	}
	
	@RequestMapping("/login.do")
	public String handleLoginRequest(ModelMap model){
		model.addAttribute("currentUrl", "login");
		return "login";
	}
}
