package com.dmma.dashboard.gwt.core.server.services.base;


import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.dashboard.core.entities.Banker;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.security.entities.MySecurityUserDetails;
import com.dmma.dashboard.core.security.type.MySecurityUserroleType;
import com.dmma.dashboard.core.services.BankerService;
import com.dmma.dashboard.core.services.BrokerService;
import com.dmma.dashboard.core.services.UserService;
import com.dmma.dashboard.gwt.core.server.mapper.BankerMapper;
import com.dmma.dashboard.gwt.core.server.mapper.BrokerMapper;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public abstract class BaseGWTServiceImpl extends RemoteServiceServlet{
	protected static final Logger log = LoggerFactory.getLogger(BaseGWTServiceImpl.class);
	protected UserService   userService;
	protected BrokerService brokerService;
	protected BankerService bankerService;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		userService    = context.getBean("userService",   UserService.class);
		brokerService  = context.getBean("brokerService", BrokerService.class);
		bankerService  = context.getBean("bankerService", BankerService.class);
		initMe(context);
	}
	
	protected abstract void initMe(WebApplicationContext context);
	
	
	protected BrokerDTO getLoggedInBrokerDTO(){
		MySecurityUserDetails userDetails = (MySecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails == null) return null;
		Broker broker = brokerService.findById(userDetails.getBrokerId());
		if(broker == null) return null;
		return BrokerMapper.toDTO(broker);
	}
	
	protected Integer getLoggedInBrokerId(){
		MySecurityUserDetails userDetails = (MySecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails == null) return null;
		return userDetails.getBrokerId();
	}
	
	protected Long getLoggedInBrokerMidasId(){
		MySecurityUserDetails userDetails = (MySecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails == null) return null;
		return userDetails.getBrokerMidasId();
	}
	
	protected BankerDTO getLoggedInBankerDTO(){
		MySecurityUserDetails userDetails = (MySecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails == null) return null;
		Banker banker = bankerService.findById(userDetails.getBankerId());
		if(banker == null) return null;
		return BankerMapper.toDTO(banker);
	}
	
	protected Integer getLoggedInBankerId(){
		MySecurityUserDetails userDetails = (MySecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails == null) return null;
		return userDetails.getBankerId();
	}
	
	protected Long getLoggedInBankerExternalId(){
		MySecurityUserDetails userDetails = (MySecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails == null) return null;
		return userDetails.getBankerExternalId();
	}
	
	
	protected void thisMethodIsOnlyFor(MySecurityUserroleType... roles) throws MethodPermissionGError {
		// yes, we can allow, as null or empty roles mens use for free 
		if(roles == null || roles.length==0) return; 
		
		Collection<GrantedAuthority> grantedAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if(grantedAuthorities!=null&&!grantedAuthorities.isEmpty()){
			for(GrantedAuthority authority: grantedAuthorities){
				for(int i = 0; i<roles.length; i++){
					if(authority.getAuthority().equals(roles[i].name()))
						return;
				}
			}
		} 
		//TODO napiwi normaljnij log output, naprimer have IS_BR, IS_A, but we need ... 
		log.warn(" MethodPermissionGError: " );
		throw new MethodPermissionGError();
	}

	protected void thisMethodIsOnlyForADMIN() throws MethodPermissionGError {
		thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_ADMIN);
	}
	
	protected void thisMethodIsOnlyForBROKER() throws MethodPermissionGError {
		thisMethodIsOnlyFor(MySecurityUserroleType.ROLE_BROKER);
	}
}
