package com.dmma.dashboard.gwt.core.client.types.search;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;

public enum EstateStatusSearchType {
	isAll(     1, DashboardMessages.MSG.all()),
	isActive(  2, DashboardMessages.MSG.active()), // active 
	isInactive(3, DashboardMessages.MSG.inactive());

	private Integer id;
	private String  title;
	
	
	private EstateStatusSearchType(Integer id , String title){
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
