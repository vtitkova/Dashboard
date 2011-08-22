package com.dmma.dashboard.gwt.core.client.mvp.hts.htsform.presenter;

import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface AbstractHtsFormPresenterDisplay{
	public Widget asWidget();
	public void setData(HaveToSellDTO data);
	public void setDataRequested();
	public HasClickHandlers getSaveButton();
	public HaveToSellDTO getData();
}
