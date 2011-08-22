package com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.presenter;

import com.dmma.dashboard.gwt.core.shared.entities.ClientVisitDTO;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface BrokersHtsFormPresenterDisplay{
	public Widget asWidget();
	public void setData(HaveToSellDTO data);
	public void setDataRequested();
	public HasClickHandlers getSaveButton();
	public HaveToSellDTO getData();
	public void setClientVisitData(ClientVisitDTO result);
	public HaveToSellDTO getHaveToSellDTO();
	public void setSaveRequested();
}
