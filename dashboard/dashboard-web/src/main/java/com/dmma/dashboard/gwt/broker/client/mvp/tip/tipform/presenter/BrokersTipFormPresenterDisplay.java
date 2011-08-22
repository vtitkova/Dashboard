package com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.presenter;

import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.presenter.AbstractTipFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;

public interface BrokersTipFormPresenterDisplay extends AbstractTipFormPresenterDisplay {
	// Banker 
	public void setPickedUpBanker(BankerDTO object);

	// Broker 
	public void setDefaultBroker(BrokerDTO object);
}
