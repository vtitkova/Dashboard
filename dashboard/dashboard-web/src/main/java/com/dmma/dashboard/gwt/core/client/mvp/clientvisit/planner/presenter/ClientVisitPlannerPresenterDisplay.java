package com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.presenter;

import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitPlanDTOW;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface ClientVisitPlannerPresenterDisplay {
	public Widget asWidget();
	public void setData(ClientVisitPlanDTOW data);
	public void setDataRequested();
	
	public HasClickHandlers getAddButton();
	public HasClickHandlers getPdfButton();
	public void setWeAreBusy(boolean b);
	public void addOneClientVisits(ClientVisitDTOS clientVisit);
	
	
	
}
