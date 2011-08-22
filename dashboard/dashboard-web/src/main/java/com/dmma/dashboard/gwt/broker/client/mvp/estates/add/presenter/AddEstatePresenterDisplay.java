package com.dmma.dashboard.gwt.broker.client.mvp.estates.add.presenter;

import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface AddEstatePresenterDisplay {
	public Widget asWidget();
	public HasClickHandlers getRequestButton();
	public Long getMidasId();
	public void setDataRequested();
	public void setData(EstateDTO estate);
	public HasClickHandlers getConfirmButton();
	
}
