package com.dmma.dashboard.gwt.admin.client.mvp.setups.mailtemplate.presenter;

import com.dmma.base.gwt.shared.entities.MailTemplateDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface MailTemplatePresenterDisplay {
	public Widget asWidget();
	public void setData(MailTemplateDTO data, String[] availableTags);
	public void setDataRequested();
	public MailTemplateDTO getData();
	public HasClickHandlers getSaveButton();
	public HasChangeHandlers getNamesListBox();
	public String getSelectedName();
	public void setSaveRequested();
	public void setSaved();
}
