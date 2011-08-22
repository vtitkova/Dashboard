package com.dmma.dashboard.gwt.core.client.types.search;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;

public enum UserRoleSearchType {
	isAll(       1,  DashboardMessages.MSG.all()),
	isBrokerOnly(2,  DashboardMessages.MSG.brokersOnly()),
	isBankerOnly(3,  DashboardMessages.MSG.bankersOnly()),
	isAdminOnly( 4,  DashboardMessages.MSG.adminsOnly());

	private Integer id;
	private String  title;
	
	
	private UserRoleSearchType(Integer id , String title){
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
