package com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface EditBrokerPresenterDisplay {
	public Widget asWidget();
	public void setData(BrokerDTO data, ArrayList<BrokerOfficeDTO> offices);
	public HasClickHandlers getSaveButton();
	public HasClickHandlers getLinkToNewBrokerOfficeButton();
	public HasClickHandlers getLinkToUserButton();
	public BrokerDTO getData();
	public String getPassword();
	public void errorInMidasIdField();
	public void errorInUserField();
	public void errorInEmailField();
}
