package com.dmma.dashboard.gwt.core.shared.entities;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;


public class UserDTO implements GwtEntityInterface{
	private Integer id;
	private Long    brokerMidasId;
	private Long    bankerExternalId;
	private String  email;
	private String  title;
	private Boolean enabled;
	private String  password;
	
	public UserDTO() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getBrokerMidasId() {
		return brokerMidasId;
	}

	public void setBrokerMidasId(Long brokerMidasId) {
		this.brokerMidasId = brokerMidasId;
	}

	public Long getBankerExternalId() {
		return bankerExternalId;
	}

	public void setBankerExternalId(Long bankerExternalId) {
		this.bankerExternalId = bankerExternalId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Object getValueAt(int index) {
		switch(index){
		case 0: return id;
		case 1: return brokerMidasId;
		case 2: return bankerExternalId;
		case 3: return email;
		case 4: return title;
		case 5: return enabled;
		case 6: return password;
		}
		return null;
	}
	
	@Override
	public void setValueAt(int index, Object value) {
		switch(index){
		case 0: return;
		case 1: brokerMidasId    = (Long) value; return;
		case 2: bankerExternalId = (Long) value; return; 
		case 3: email     = (String)  value; return;
		case 4: title     = (String)  value; return;
		case 5: enabled   = (Boolean) value; return;
		case 6: password  = (String)  value; return;
		}
	}

	@Override
	public String toString(){
		return this.title;
	}

	
	
}
