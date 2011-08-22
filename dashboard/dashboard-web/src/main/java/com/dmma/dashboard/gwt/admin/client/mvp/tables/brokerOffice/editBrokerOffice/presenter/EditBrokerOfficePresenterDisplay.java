package com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter;

import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface EditBrokerOfficePresenterDisplay {
	public Widget asWidget();
	public void setData(BrokerOfficeDTO data);
	public HasClickHandlers getSaveButton();
	public BrokerOfficeDTO getData();
	public void errorInMidasIdField();
	
}
