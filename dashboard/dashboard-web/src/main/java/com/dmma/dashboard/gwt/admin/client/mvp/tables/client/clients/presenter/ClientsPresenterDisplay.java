package com.dmma.dashboard.gwt.admin.client.mvp.tables.client.clients.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface ClientsPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<ClientDTO> data);
	public void setDataRequested();
	public HasClickHandlers getAddNewButton();
	public HasClickHandlers getFindButton();
	public String getPhoneStarts();
	public void   setPhoneStarts(String phoneStarts);
}
