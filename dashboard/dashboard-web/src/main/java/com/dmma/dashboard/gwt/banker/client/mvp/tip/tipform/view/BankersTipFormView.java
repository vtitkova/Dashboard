package com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.view;

import com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.presenter.BankersTipFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.view.AbstractTipFormView;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;

public class BankersTipFormView extends AbstractTipFormView implements  BankersTipFormPresenterDisplay{
	
	public BankersTipFormView() {
		super(AbstractTipFormView.BANKER_MODE);
	}
	
	// Lookup functionality for Broker
	@Override
	public void setPickedUpBroker(BrokerDTO object) {
		tipDTO.setBroker(object);
		super.renderBroker();
		super.renderLookupAndRemovePartner();
	}
	
	@Override
	public void setDefaultBanker(BankerDTO object) {
		tipDTO.setBanker(object);
		super.renderBanker();
	}
}