package com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.view;

import com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.presenter.BrokersTipFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.view.AbstractTipFormView;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;

public class BrokersTipFormView extends AbstractTipFormView implements  BrokersTipFormPresenterDisplay{
	
	public BrokersTipFormView() {
		super(AbstractTipFormView.MEGLER_MODE);
	}
	
	// Lookup functionality for Banker	
	@Override
	public void setPickedUpBanker(BankerDTO object) {
		tipDTO.setBanker(object);
		super.renderBanker();
		super.renderLookupAndRemovePartner();
	}
		
	@Override
	public void setDefaultBroker(BrokerDTO object) {
		tipDTO.setBroker(object);
		super.renderBroker();
	}

}