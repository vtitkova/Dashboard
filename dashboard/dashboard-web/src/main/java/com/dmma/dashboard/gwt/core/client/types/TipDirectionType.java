package com.dmma.dashboard.gwt.core.client.types;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;


public enum TipDirectionType {
	isMtoB(     1, DashboardMessages.MSG.tipDirectionBrokerToBanker()),
	isBtoM(     2, DashboardMessages.MSG.tipDirectionBankerToBroker());

	private Integer id;
	private String  title;
	
	public static TipDirectionType getById(Integer id){
		for(TipDirectionType type: TipDirectionType.values()){
			if(type.getId()==id)
				return type;
		}
		return null;
	}
	
	public static String getTitleById(Integer id){
		TipDirectionType type = getById(id);
		if(type!=null) return type.getTitle();
		return "null";
	}
	
	
	private TipDirectionType(Integer id , String title){
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
