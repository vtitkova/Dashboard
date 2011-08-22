package com.dmma.dashboard.core.security.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class MySecurityUserDetails implements UserDetails{
	//mandatory fields 
	private Collection<GrantedAuthority> authorities;
	private String  password;
	private String  username;
	private Boolean enabled;

	//My fields for broker
	private Integer brokerId;
	private Long    brokerMidasId;
	private Integer brokerOfficeId;
	private Long    brokerOfficeMidasId;
	private String  brokerOfficeTitle;

	//My fields for banker
	private Integer bankerId;
	private Long    bankerExternalId;
	private Integer bankOfficeId;
	private Long    bankOfficeExternalId;
	private String  bankOfficeTitle;
	

	public MySecurityUserDetails(String username, String password, Boolean enabled, ArrayList<GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}


	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username; 
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Integer getBrokerId() {
		return brokerId;
	}


	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}


	public Long getBrokerMidasId() {
		return brokerMidasId;
	}


	public void setBrokerMidasId(Long brokerMidasId) {
		this.brokerMidasId = brokerMidasId;
	}


	public Integer getBrokerOfficeId() {
		return brokerOfficeId;
	}


	public void setBrokerOfficeId(Integer brokerOfficeId) {
		this.brokerOfficeId = brokerOfficeId;
	}


	public Long getBrokerOfficeMidasId() {
		return brokerOfficeMidasId;
	}


	public void setBrokerOfficeMidasId(Long brokerOfficeMidasId) {
		this.brokerOfficeMidasId = brokerOfficeMidasId;
	}


	public String getBrokerOfficeTitle() {
		return brokerOfficeTitle;
	}


	public void setBrokerOfficeTitle(String brokerOfficeTitle) {
		this.brokerOfficeTitle = brokerOfficeTitle;
	}


	public Integer getBankerId() {
		return bankerId;
	}


	public void setBankerId(Integer bankerId) {
		this.bankerId = bankerId;
	}


	public Long getBankerExternalId() {
		return bankerExternalId;
	}


	public void setBankerExternalId(Long bankerExternalId) {
		this.bankerExternalId = bankerExternalId;
	}


	public Integer getBankOfficeId() {
		return bankOfficeId;
	}


	public void setBankOfficeId(Integer bankOfficeId) {
		this.bankOfficeId = bankOfficeId;
	}


	public Long getBankOfficeExternalId() {
		return bankOfficeExternalId;
	}


	public void setBankOfficeExternalId(Long bankOfficeExternalId) {
		this.bankOfficeExternalId = bankOfficeExternalId;
	}


	public String getBankOfficeTitle() {
		return bankOfficeTitle;
	}


	public void setBankOfficeTitle(String bankOfficeTitle) {
		this.bankOfficeTitle = bankOfficeTitle;
	}


	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	

}
