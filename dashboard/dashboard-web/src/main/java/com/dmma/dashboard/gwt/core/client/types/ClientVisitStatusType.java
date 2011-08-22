package com.dmma.dashboard.gwt.core.client.types;


import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.google.gwt.user.client.ui.AbstractImagePrototype;


public enum ClientVisitStatusType {
	isPlaningToGo(    1, DashboardMessages.MSG.isPlaningToGo()),
	isWasOnViewing(   2, DashboardMessages.MSG.isWasOnViewing()),
	isWasNotOnViewing(3, DashboardMessages.MSG.isWasNotOnViewing());
	
	private static final String imagePlaningToGoHtml;
	private static final String imageWasOnViewingHtml;
	private static final String imageWasNotOnViewingHtml;
	
	static {
		imagePlaningToGoHtml = AbstractImagePrototype.create(DashboardImages.IMG.notKnown16()).getHTML();
		imageWasOnViewingHtml = AbstractImagePrototype.create(DashboardImages.IMG.true16()).getHTML();
		imageWasNotOnViewingHtml = AbstractImagePrototype.create(DashboardImages.IMG.userDisabled16()).getHTML();
	}
	
	private Integer id;
	private String  title;
	
	public static ClientVisitStatusType getById(Integer id){
		for(ClientVisitStatusType type: ClientVisitStatusType.values()){
			if(type.getId()==id)
				return type;
		}
		return null;
	}
	
	public static String getTitleById(Integer id){
		ClientVisitStatusType type = getById(id);
		if(type!=null) return type.getTitle();
		return "null";
	}
	
	private ClientVisitStatusType(Integer id , String title){
		this.setId(id);
		this.setTitle(title);
	}

	
	public static String createIconHTML(Integer status) {
		if(isPlaningToGo.getId().equals(status)){
			return imagePlaningToGoHtml;
		} 
		if(isWasOnViewing.getId().equals(status)){
			return imageWasOnViewingHtml;
		}
		if(isWasNotOnViewing.getId().equals(status)){
			return imageWasNotOnViewingHtml;
		}
		return null;
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
	
	public static ArrayList<ListBoxDTO> getValuesAsListBoxDTOs(){
		ArrayList<ListBoxDTO> data = new ArrayList<ListBoxDTO>();
		for(ClientVisitStatusType t : values()){
			data.add(new ListBoxDTO(t.getId(), t.getTitle()));
		}
		return data;
		
	}
	
}
