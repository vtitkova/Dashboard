package com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tips.presenter;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface TipsPresenterDisplay {
	public Widget asWidget();
	public HasClickHandlers getFindButton();
	public TipSearchWrapper getTipSearchWrapper();
	
	// MAin Data - Tips
	public void setData(ArrayList<TipDTO> data);
	public void setDataRequested();

	// Direction Type
	public void setTipDirectionSearchTypeId(Integer paramAsInteger);

	
	public void setBankOfficeData(ArrayList<ListBoxDTO> data);
	public void setBankOfficeDataNA();
	public void setSelectedBankOfficeId(Integer bankOfficeId);
	public Integer getSelectedBankOfficeId();
	public HasChangeHandlers getBankOfficeChange();
	
	public void setBrokerOfficeData(ArrayList<ListBoxDTO> data);
	public void setBrokerOfficeDataNA();
	public void setSelectedBrokerOfficeId(Integer brokerOfficeId);
	public Integer getSelectedBrokerOfficeId();
	public HasChangeHandlers getBrokerOfficeChange();
	
	public void setBankerData(ArrayList<ListBoxDTO> data);
	public void setBankerDataNA();
	public void setSelectedBankerId(Integer bankerId);
	public Integer getSelectedBankerId();
	
	
	public void setBrokerData(ArrayList<ListBoxDTO> data);
	public void setBrokerDataNA();
	public void setSelectedBrokerId(Integer brokerId);
	public Integer getSelectedBrokerId();
	public void setTipTypeSearchTypeId(Integer paramAsInteger);
	public void setTipStatusSearchTypeId(Integer paramAsInteger);
	public void setDateFrom(Date paramAsDate);
	public void setDateTo(Date paramAsDate);
	
}
