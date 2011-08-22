package com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tipform.presenter;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface TipFormPresenterDisplay {
	public Widget asWidget();
	public void setData(TipDTO data);
	public void setDataRequested();
	public HasClickHandlers getSaveButton();
	public TipDTO getData();

	public void setEstateData(ArrayList<ListBoxDTO> data);
	public boolean getIsShowOnlyActiveCB();
	public HasValueChangeHandlers<Boolean> getShowOnlyActiveChangeHandler();
	
	// Client 
	public HasClickHandlers getLookupClientButton();
	public HasClickHandlers getRemoveClientButton();
	public ClientDTO getSelectedClient();
	public void setPickedUpClient(ClientDTO object);

	// Banker 
	public HasClickHandlers getLookupBankerButton();
	public HasClickHandlers getRemoveBankerButton();
	public BankerDTO getSelectedBanker();
	public void setPickedUpBanker(BankerDTO object);

	// Banker 
	public HasClickHandlers getLookupBrokerButton();
	public HasClickHandlers getRemoveBrokerButton();
	public BrokerDTO getSelectedBroker();
	public void setPickedUpBroker(BrokerDTO object);
	
	
}
