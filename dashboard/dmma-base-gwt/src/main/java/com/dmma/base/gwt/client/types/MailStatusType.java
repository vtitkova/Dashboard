package com.dmma.base.gwt.client.types;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbstractImagePrototype;



public enum MailStatusType {
	isNew(   1, BaseMessages.MSG.mailStatusIsNew()),
	isSent(  2, BaseMessages.MSG.mailStatusIsSent()),
	isFailed(3, BaseMessages.MSG.mailStatusIsFailed());
	
	private static final String imageIsNewHtml;
	private static final String imageIsSentHtml;
	private static final String imageIsFailedHtml;
	
	private static final ImageResource imageIsNew = BaseImages.IMG.indifferentSmall();
	private static final ImageResource imageIsSent = BaseImages.IMG.goodSmall();
	private static final ImageResource imageIsFailed = BaseImages.IMG.badSmall();
	
	static {
		imageIsNewHtml  = AbstractImagePrototype.create(BaseImages.IMG.indifferentSmall()).getHTML();
		imageIsSentHtml = AbstractImagePrototype.create(BaseImages.IMG.goodSmall()).getHTML();
		imageIsFailedHtml = AbstractImagePrototype.create(BaseImages.IMG.badSmall()).getHTML();
	}
	
	
	
	private Integer id;
	private String  title;
	
	public static MailStatusType getById(Integer id){
		for(MailStatusType type: MailStatusType.values()){
			if(type.getId()==id)
				return type;
		}
		return null;
	}
	
	private MailStatusType(Integer id, String title){
		this.setId(id);
		this.setTitle(title);
	}	

	
	public static String createIconHTML(Integer status) {
		if(isNew.getId().equals(status)){
			return imageIsNewHtml;
		} 
		if(isSent.getId().equals(status)){
			return imageIsSentHtml;
		}
		if(isFailed.getId().equals(status)){
			return imageIsFailedHtml;
		}
		return null;
	}
	
	public static ImageResource createIcon(Integer status) {
		if(isNew.getId().equals(status)){
			return imageIsNew;
		} 
		if(isSent.getId().equals(status)){
			return imageIsSent;
		}
		if(isFailed.getId().equals(status)){
			return imageIsFailed;
		}
		return null;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
		
}
