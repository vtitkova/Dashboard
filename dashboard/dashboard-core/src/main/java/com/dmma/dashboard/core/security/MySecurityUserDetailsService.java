package com.dmma.dashboard.core.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dmma.dashboard.core.entities.Banker;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.core.entities.User;
import com.dmma.dashboard.core.entities.UserRole;
import com.dmma.dashboard.core.security.entities.MySecurityUserDetails;
import com.dmma.dashboard.core.services.BankerService;
import com.dmma.dashboard.core.services.BrokerService;
import com.dmma.dashboard.core.services.UserRoleService;
import com.dmma.dashboard.core.services.UserService;

public class MySecurityUserDetailsService implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(MySecurityUserDetailsService.class);
	private UserService     userService;
	private UserRoleService userRoleService;
	private BrokerService   brokerService;
	private BankerService   bankerService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	public void setBrokerService(BrokerService brokerService) {
		this.brokerService = brokerService;
	}
	public void setBankerService(BankerService bankerService) {
		this.bankerService = bankerService;
	}

	
	public MySecurityUserDetailsService() {
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		log.debug("loadUserByUsername: " + username);
		User  user  = userService.findByEmailOrBrokerMidasId(username);
		if(user == null)
			throw new UsernameNotFoundException("org.test.spring.UsernameNotFound");
		ArrayList<GrantedAuthority> authorities = getAuthorities(user.getId());
		
		
		MySecurityUserDetails myUserDetails = new MySecurityUserDetails(user.getTitle(), user.getPassword(), user.getEnabled(), authorities);
		
		Broker userAsBroker = brokerService.findByUserId(user.getId());
		if(userAsBroker!=null){
			myUserDetails.setBrokerId(     userAsBroker.getId());
			myUserDetails.setBrokerMidasId(userAsBroker.getMidasId());
			if(userAsBroker.getBrokerOffice()!=null){
				myUserDetails.setBrokerOfficeId(     userAsBroker.getBrokerOffice().getId());
				myUserDetails.setBrokerOfficeMidasId(userAsBroker.getBrokerOffice().getMidasId());
				myUserDetails.setBrokerOfficeTitle(  userAsBroker.getBrokerOffice().getName());
			}
		}
		Banker userAsBanker = bankerService.findByUserId(user.getId());
		if(userAsBanker!=null){
			myUserDetails.setBankerId(        userAsBanker.getId());
			myUserDetails.setBankerExternalId(userAsBanker.getExternalId());
			if(userAsBanker.getBankOffice()!=null){
				myUserDetails.setBankOfficeId(        userAsBanker.getBankOffice().getId());
				myUserDetails.setBankOfficeExternalId(userAsBanker.getBankOffice().getExternalId());
				myUserDetails.setBankOfficeTitle(     userAsBanker.getBankOffice().getName());
			}
		}
		return myUserDetails;
	}

	
	
	private ArrayList<GrantedAuthority> getAuthorities(Integer userId) {
		List<UserRole> roles = userRoleService.findByUserId(userId);
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
		if(roles!=null&&!roles.isEmpty()){
			for(UserRole role:roles){
				authorities.add(new GrantedAuthorityImpl(role.getRole()));
			}
		}
		return authorities;
	}

	
}
