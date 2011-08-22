package com.dmma.dashboard.gwt.core.client.types;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;


public enum TipType {
	isLoan(     1, DashboardMessages.MSG.tipLoan()),
	isSell(     2, DashboardMessages.MSG.tipSell()),
	isInventory(3, DashboardMessages.MSG.tipInventory());

	private Integer id;
	private String  title;
	

	public static TipType getById(Integer id){
		for(TipType type: TipType.values()){
			if(type.getId()==id)
				return type;
		}
		return null;
	}
	
	public static String getTitleById(Integer id){
		TipType type = getById(id);
		if(type!=null) return type.getTitle();
		return "null";
	}
	
	
	private TipType(Integer id , String title){
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
