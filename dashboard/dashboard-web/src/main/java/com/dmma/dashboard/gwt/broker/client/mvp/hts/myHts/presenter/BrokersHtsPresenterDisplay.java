package com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.presenter;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.HtsSearchWrapper;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface BrokersHtsPresenterDisplay {
	public Widget asWidget();
	public HasClickHandlers getFindButton();
	public HtsSearchWrapper getHtsSearchWrapper();
	
	// MAin Data - HTS
	public void setData(ArrayList<HaveToSellDTO> data);
	public void setDataRequested();

	
	public void setWantsToSellSearchTypeId(Integer paramAsInteger);

	public void setDateFrom(Date paramAsDate);
	public void setDateTo(Date paramAsDate);
	public void setHtcStatusSearchTypeId(Integer paramAsInteger);
	
	
}
