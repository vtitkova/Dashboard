package com.dmma.dashboard.gwt.core.client.types.search;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;

public enum UserStatusSearchType {
	isAll(     1, DashboardMessages.MSG.all()),
	isEnabled( 2, DashboardMessages.MSG.enabled()),
	isDisabled(3, DashboardMessages.MSG.disabled());

	private Integer id;
	private String  title;
	
	
	private UserStatusSearchType(Integer id , String title){
		this.setId(id);
		this.setTitle(title);
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getTitle() {
		return title;
	}
	
	
	
	
	
}
