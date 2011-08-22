package com.dmma.dashboard.gwt.core.client.mvp.banker.lookupBanker.presenter;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface LookupBankerPresenterDisplay {
	public Widget asWidget();

	public void setData(ArrayList<BankerDTO> data);
	public void setRecentData(ArrayList<BankerDTO> data);
	public void setBankOfficeData(ArrayList<ListBoxDTO> data);
	
	public void setDataRequested();
	public HasChangeHandlers getBankOfficeChangeHandler();
	
	
	public HasClickHandlers getCloseButton();
	public HasClickHandlers getPicUpButton();
	
	
	public BankerDTO getPickedUpObject();
	public void setDefaultPickedUpObject(BankerDTO defaultBanker);

	public Integer getSelectedBankOfficeId();

}
