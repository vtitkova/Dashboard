package com.dmma.dashboard.gwt.broker.client.mvp.estates.details.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ViewingAndVisitsDTOW;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface EstateDetailsPresenterDisplay {
	public Widget asWidget();
	public void setData(EstateDTO data);
	public void setDataRequested();
	public HasClickHandlers getSynhronizeButton();
	public void setDataSynhronizationRequested();
	public void setDataAfterSynhronization(EstateDTO data);
	
	public void setFutureViewingAndVisitsDataRequested();
	public void setFutureViewingAndVisits(ArrayList<ViewingAndVisitsDTOW> futureViewingAndVisits);
	public void setPastViewingAndVisitsDataRequested();
	public void setPastViewingAndVisits(ArrayList<ViewingAndVisitsDTOW> pastViewingAndVisits);
}
