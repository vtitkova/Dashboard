package com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.presenter;

import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.presenter.AbstractTipFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;

public interface BankersTipFormPresenterDisplay extends AbstractTipFormPresenterDisplay {
	// Banker 
	public void setDefaultBanker(BankerDTO object);

	// Broker 
	public void setPickedUpBroker(BrokerDTO object);
}
