package com.dmma.dashboard.app.controllers;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmma.dashboard.core.configuration.AppProperties;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;

@Controller
public class AppRedirectionController {
	
	
	@RequestMapping("/dashboard.do")
	public String handleDashboardRedirectRequest(){
		String codeserv = "";
		if(AppProperties.getUseGwtCodeserv())
			codeserv = "?"+AppProperties.gwtCodeserv;
		Collection<GrantedAuthority> grantedAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if(grantedAuthorities==null||grantedAuthorities.isEmpty())
			return "redirect:login.do";
		else if(haveRole(MySecurityUserroleType.ROLE_BROKER, grantedAuthorities))
			return "redirect:broker.do"+codeserv;
		else if(haveRole(MySecurityUserroleType.ROLE_BANKER, grantedAuthorities))
			return "redirect:banker.do"+codeserv;
		else if(haveRole(MySecurityUserroleType.ROLE_ADMIN, grantedAuthorities))
			return "redirect:admin.do"+codeserv;
		return "redirect:login.do";
	}

	private boolean haveRole(MySecurityUserroleType role, Collection<GrantedAuthority> grantedAuthorities) {
		for(GrantedAuthority authority: grantedAuthorities){
			if(role.name().equals(authority.getAuthority()))
				return true;
		}
		return false;
	}
	
	
	
}
