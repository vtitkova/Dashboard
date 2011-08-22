package com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter;

import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;

public interface EditClientPresenterDisplay extends IPresenterDisplay{
	public void setData(ClientDTO data);
	public HasClickHandlers getSaveButton();
	public ClientDTO getData();
	public void errorInPhoneField();
	public void setActiveSaveButton(boolean enabled);
	
}
