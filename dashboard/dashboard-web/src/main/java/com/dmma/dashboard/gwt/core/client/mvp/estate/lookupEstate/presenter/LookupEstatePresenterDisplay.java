package com.dmma.dashboard.gwt.core.client.mvp.estate.lookupEstate.presenter;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface LookupEstatePresenterDisplay {
	public Widget asWidget();

	public void setEstateData(ArrayList<EstateDTO> data);
	public void setBrokerData(ArrayList<ListBoxDTO> data);
	public void setBrokerOfficeData(ArrayList<ListBoxDTO> data);
	
	public void setEstateDataRequested();
	public void setBrokerDataRequested();
	
	public HasChangeHandlers getBrokerChangeHandler();
	public HasChangeHandlers getBrokerOfficeChangeHandler();
	public HasValueChangeHandlers<Boolean> getIsShowOnlyActiveHandler();
	
	public HasClickHandlers getCloseButton();
	public HasClickHandlers getPicUpButton();
	
	
	public EstateDTO getPickedUpObject();
	public void setDefaultPickedUpObject(EstateDTO defaultEstate);

	public Integer getSelectedBrokerOfficeId();
	public Integer getSelectedBrokerId();
	public Boolean getIsShowOnlyActive();

	public void setDefaultBroker(BrokerDTO b);
	
}
