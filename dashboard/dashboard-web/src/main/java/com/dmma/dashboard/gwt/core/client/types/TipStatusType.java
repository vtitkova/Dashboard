package com.dmma.dashboard.gwt.core.client.types;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;


public enum TipStatusType {
	isNew(       1, DashboardMessages.MSG.tipStatusNew()),
	isInProcess( 2, DashboardMessages.MSG.tipStatusInProcess()),
	isSucceed(   3, DashboardMessages.MSG.tipStatusSucceed()),
	isRejected(  4, DashboardMessages.MSG.tipStatusRejected());

	private Integer id;
	private String  title;
	
	public static TipStatusType getById(Integer id){
		for(TipStatusType type: TipStatusType.values()){
			if(type.getId()==id)
				return type;
		}
		return null;
	}
	
	public static String getTitleById(Integer id){
		TipStatusType type = getById(id);
		if(type!=null) return type.getTitle();
		return "null";
	}
	
	
	private TipStatusType(Integer id , String title){
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
