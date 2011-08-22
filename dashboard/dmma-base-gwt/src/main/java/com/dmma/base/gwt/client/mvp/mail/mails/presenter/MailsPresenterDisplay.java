package com.dmma.base.gwt.client.mvp.mail.mails.presenter;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.base.gwt.shared.entities.MailDTO;
import com.dmma.base.gwt.shared.wrappers.MailSearchWrapper;
import com.google.gwt.event.dom.client.HasChangeHandlers;

public interface MailsPresenterDisplay extends IPresenterDisplay {
	public void setData(ArrayList<MailDTO> data);
	public void setDataRequested();
	public void addAvailableTemplateNames(String templateTitle, String templateName);
	
	public HasChangeHandlers getStatusCB();
	public void setSelectedStatusId(Integer statusId);
	
	public HasChangeHandlers getTemplateCB();
	public void setSelectedTemplateName(String templateName);

	public MailSearchWrapper getMailSearchWrapper();

	public void setDateFrom(Date paramAsDate);
	public void setDateTo(Date paramAsDate);
	
}
