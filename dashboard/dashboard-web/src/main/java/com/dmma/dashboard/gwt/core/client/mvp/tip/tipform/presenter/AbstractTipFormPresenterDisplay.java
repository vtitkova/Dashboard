package com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.presenter;

import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;

public interface AbstractTipFormPresenterDisplay extends IPresenterDisplay{
	public void setData(TipDTO data);
	public void setDataRequested();
	public HasClickHandlers getSaveButton();
	public TipDTO getData();

	
	// Client 
	public HasClickHandlers getLookupClientButton();
	public HasClickHandlers getRemoveClientButton();
	public ClientDTO getSelectedClient();
	public void setPickedUpClient(ClientDTO object);
	
	//ESTATE
	public HasClickHandlers getLookupEstateButton();
	public HasClickHandlers getRemoveEstateButton();
	public EstateDTO getSelectedEstate();
	public void setPickedUpEstate(EstateDTO object);
	
	
	// Banker 
	public BankerDTO getSelectedBanker();

	// Broker 
	public BrokerDTO getSelectedBroker();
	
	//Partner (Banker or Broker)
	public HasClickHandlers getLookupPartnerButton();
	public HasClickHandlers getRemovePartnerButton();
	
	
}
