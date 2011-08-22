package com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.brokers.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface BrokersPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<BrokerDTO> data);
	public void setDataRequested();
	public HasClickHandlers getAddNewButton();
	public void setBrokerOffices(ArrayList<BrokerOfficeDTO> brokerOffices);
	
	public HasChangeHandlers  getBrokerOfficesLB();
	public void               setSelectedBrokerOffice(Integer id);
	public Integer            getSelectedBrokerOffice();
}
