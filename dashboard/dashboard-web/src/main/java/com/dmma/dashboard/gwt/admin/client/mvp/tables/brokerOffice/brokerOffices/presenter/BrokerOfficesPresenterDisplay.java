package com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.brokerOffices.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface BrokerOfficesPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<BrokerOfficeDTO> data);
	public void setDataRequested();
	public HasClickHandlers getAddNewButton();
}
