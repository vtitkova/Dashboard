package com.dmma.dashboard.gwt.banker.client.mvp.tip.myTips.presenter;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;

public interface BankersTipsPresenterDisplay extends IPresenterDisplay{
	public HasClickHandlers getFindButton();
	public TipSearchWrapper getTipSearchWrapper();
	
	// MAin Data - Tips
	public void setData(ArrayList<TipDTO> data);
	public void setDataRequested();

	// Direction Type - Broker to megler or megler to broker
	public void setTipDirectionSearchTypeId(Integer paramAsInteger);
	
	public void setBrokerOfficeData(ArrayList<ListBoxDTO> data);
	public void setBrokerOfficeDataNA();
	public void setSelectedBrokerOfficeId(Integer brokerOfficeId);
	public Integer getSelectedBrokerOfficeId();
	public HasChangeHandlers getBrokerOfficeChange();
	
	public void setBrokerData(ArrayList<ListBoxDTO> data);
	public void setBrokerDataNA();
	public void setSelectedBrokerId(Integer brokerId);
	public Integer getSelectedBrokerId();
	
	// 
	public void setTipTypeSearchTypeId(Integer paramAsInteger);
	public void setTipStatusSearchTypeId(Integer paramAsInteger);
	public void setDateFrom(Date paramAsDate);
	public void setDateTo(Date paramAsDate);
	
	
}
