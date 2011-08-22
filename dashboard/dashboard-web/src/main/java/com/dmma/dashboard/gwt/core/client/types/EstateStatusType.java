package com.dmma.dashboard.gwt.core.client.types;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;


public enum EstateStatusType {
	isReady(        20, DashboardMessages.MSG.isReady()),
	isFodSale(      30, DashboardMessages.MSG.isForSale()),
	isOfferReceived(40, DashboardMessages.MSG.isOfferReceived()), 
	isSold(         50, DashboardMessages.MSG.isSold()), 
	isForRent(      60, DashboardMessages.MSG.isForRent()),
	isRented(       70, DashboardMessages.MSG.isRented()),
	isWithdrawn(    90, DashboardMessages.MSG.isWithdrawn()),
	isBroken(      666, DashboardMessages.MSG.isBroken());
	
	private Integer id;
	private String  title;
	
	public static EstateStatusType getById(Integer id){
		for(EstateStatusType type: EstateStatusType.values()){
			if(type.getId()==id)
				return type;
		}
		return isBroken;
	}
	
	public static String getTitleById(Integer id){
		return getById(id).getTitle();
	}
	
	private EstateStatusType(Integer id , String title){
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
