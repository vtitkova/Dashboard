package com.dmma.dashboard.gwt.banker.client;

import com.dmma.base.gwt.client.app.entrypoint.BaseEntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class BankerEP extends BaseEntryPoint{
	@Override
	public void onModuleAndContextLoaded(RootPanel rootPanel) {
		new BankerMainController(rootPanel);		
	}
	
}
