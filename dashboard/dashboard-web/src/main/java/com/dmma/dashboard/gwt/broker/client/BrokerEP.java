package com.dmma.dashboard.gwt.broker.client;

import com.dmma.base.gwt.client.app.entrypoint.BaseEntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class BrokerEP extends BaseEntryPoint{
	@Override
	public void onModuleAndContextLoaded(RootPanel rootPanel) {
		new BrokerMainController(rootPanel);
	}
	
}
