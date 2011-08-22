package com.dmma.dashboard.gwt.broker.client.mvp.estates.list.preaenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface MyEstatesPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<EstateDTO> data);
	public void setDataRequested();
	public HasClickHandlers getAddNewButton();
	public HasClickHandlers getFindButton();
	public EstateSearchWrapper getEstateSearchWrapper();
	public void setEstateSearchWrapper(EstateSearchWrapper wrapper);
}
