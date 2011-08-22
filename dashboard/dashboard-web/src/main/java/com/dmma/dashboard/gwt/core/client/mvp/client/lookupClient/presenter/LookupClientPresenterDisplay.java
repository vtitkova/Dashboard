package com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface LookupClientPresenterDisplay {
	public Widget asWidget();

	public void setData(ArrayList<ClientDTO> data);
	public void setDataRequested();
	public HasKeyUpHandlers getClientPhone();
	
	public HasClickHandlers getCloseButton();
	public HasClickHandlers getPicUpButton();
	public HasClickHandlers getSaveAndPicUpButton();
	
	
	public ClientDTO getPickedUpObject();
	public void setDefaultPickedUpObject(ClientDTO defaultClient);

	public String getPhoneLookupString();

	public ClientDTO getNewClient();

	// Proxy
	public void setSavingInProcess();
	public void setSavingFailed();
	public void errorInPhoneField();
	
	
}
