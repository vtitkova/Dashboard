package com.dmma.dashboard.gwt.core.client.services.factory;

import com.dmma.dashboard.gwt.core.client.services.BankOfficeGWTService;
import com.dmma.dashboard.gwt.core.client.services.BankOfficeGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.BankerGWTService;
import com.dmma.dashboard.gwt.core.client.services.BankerGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.BrokerGWTService;
import com.dmma.dashboard.gwt.core.client.services.BrokerGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.BrokerOfficeGWTService;
import com.dmma.dashboard.gwt.core.client.services.BrokerOfficeGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.ClientGWTService;
import com.dmma.dashboard.gwt.core.client.services.ClientGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.ClientVisitGWTService;
import com.dmma.dashboard.gwt.core.client.services.ClientVisitGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.EstateGWTService;
import com.dmma.dashboard.gwt.core.client.services.EstateGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.HaveToSellGWTService;
import com.dmma.dashboard.gwt.core.client.services.HaveToSellGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.TipGWTService;
import com.dmma.dashboard.gwt.core.client.services.TipGWTServiceAsync;
import com.dmma.dashboard.gwt.core.client.services.UserGWTService;
import com.dmma.dashboard.gwt.core.client.services.UserGWTServiceAsync;
import com.google.gwt.core.client.GWT;

public class ServiceFactory {
	
	private static UserGWTServiceAsync   userService;
	private static ClientGWTServiceAsync clientService;
	private static BankOfficeGWTServiceAsync   bankOfficeService;
	private static BankerGWTServiceAsync bankerService;
	private static BrokerOfficeGWTServiceAsync brokerOfficeService;
	private static BrokerGWTServiceAsync brokerService;
	private static EstateGWTServiceAsync estateService;
	private static TipGWTServiceAsync tipService;
	private static HaveToSellGWTServiceAsync haveToSellService;
	private static ClientVisitGWTServiceAsync clientVisitService;
	
	
	public static UserGWTServiceAsync getUserService() {
		if(userService == null)
			userService = GWT.create(UserGWTService.class);
		return userService;
	}
	
	public static ClientGWTServiceAsync getClientService() {
		if(clientService == null)
			clientService = GWT.create(ClientGWTService.class);
		return clientService;
	}
	
	public static BankOfficeGWTServiceAsync getBankOfficeService() {
		if(bankOfficeService == null)
			bankOfficeService = GWT.create(BankOfficeGWTService.class);
		return bankOfficeService;
	}
	
	public static BankerGWTServiceAsync getBankerService() {
		if(bankerService == null)
			bankerService = GWT.create(BankerGWTService.class);
		return bankerService;
	}
	
	public static BrokerOfficeGWTServiceAsync getBrokerOfficeService() {
		if(brokerOfficeService == null)
			brokerOfficeService = GWT.create(BrokerOfficeGWTService.class);
		return brokerOfficeService;
	}
	
	
	public static BrokerGWTServiceAsync getBrokerService() {
		if(brokerService == null)
			brokerService = GWT.create(BrokerGWTService.class);
		return brokerService;
	}
	
	public static EstateGWTServiceAsync getEstateService() {
		if(estateService == null)
			estateService = GWT.create(EstateGWTService.class);
		return estateService;
	}
	
	public static TipGWTServiceAsync getTipService() {
		if(tipService == null)
			tipService = GWT.create(TipGWTService.class);
		return tipService;
	}
	
	public static HaveToSellGWTServiceAsync getHaveToSellService() {
		if(haveToSellService == null)
			haveToSellService = GWT.create(HaveToSellGWTService.class);
		return haveToSellService;
	}
	
	public static ClientVisitGWTServiceAsync getClientVisitService() {
		if(clientVisitService == null)
			clientVisitService = GWT.create(ClientVisitGWTService.class);
		return clientVisitService;
	}

}
