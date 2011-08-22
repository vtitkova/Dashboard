package com.dmma.dashboard.gwt.admin.client.mvp.tables.estate.estates.presenter;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface EstatesPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<EstateDTO> data);
	public void setDataRequested();

	public HasClickHandlers getFindButton();
	public EstateSearchWrapper getEstateSearchWrapper();
	public void setEstateSearchWrapper(EstateSearchWrapper wrapper);
	public HasChangeHandlers getStatusChange();
	
	public void setOfficesData(ArrayList<ListBoxDTO> data);
	public void setOfficesNA();
	public HasChangeHandlers getOfficesChange();
	
	public void setBrokersNA();
	public void setBrokersData(ArrayList<ListBoxDTO> data);
	public HasChangeHandlers getBrokerChange();
}
