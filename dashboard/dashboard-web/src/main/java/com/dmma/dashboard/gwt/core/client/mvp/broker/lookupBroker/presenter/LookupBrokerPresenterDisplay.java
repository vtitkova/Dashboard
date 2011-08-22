package com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.presenter;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface LookupBrokerPresenterDisplay {
	public Widget asWidget();

	public void setData(ArrayList<BrokerDTO> data);
	public void setRecentData(ArrayList<BrokerDTO> data);
	public void setBrokerOfficeData(ArrayList<ListBoxDTO> data);
	
	public void setDataRequested();
	public HasChangeHandlers getBrokerOfficeChangeHandler();
	
	
	public HasClickHandlers getCloseButton();
	public HasClickHandlers getPicUpButton();
	
	
	public BrokerDTO getPickedUpObject();
	public void setDefaultPickedUpObject(BrokerDTO defaultBroker);

	public Integer getSelectedBrokerOfficeId();

}
