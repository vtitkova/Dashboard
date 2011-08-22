package com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.brokers.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.brokers.view.BrokersView;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.presenter.EditBrokerPresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class BrokersPresenter implements Presenter {  
	public static String PRESENTER_ID = "Brokers";

	private AppEvent                   defParams;
	private ArrayList<BrokerOfficeDTO> brokerOffices;
	private BrokerOfficesCallback brokerOfficesCallback = new BrokerOfficesCallback();
	private ServiceCallback       callback = new ServiceCallback();
	private final BrokersPresenterDisplay     display;

	
	public BrokersPresenter() {
		this.display = new BrokersView();
		init();
	}


	private void init() {
		this.display.getAddNewButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				AppEvent e = new AppEvent(EditBrokerPresenter.PRESENTER_ID, this.getClass().getName());
				History.newItem(URLParser.toHistoryToken(e), true );
			}
		});
		this.display.getBrokerOfficesLB().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				onBrokerOfficeChange();				
			}
		});
	}

	
	private void onBrokerOfficeChange(){
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		Integer brokerOfficeId = display.getSelectedBrokerOffice();
		if(brokerOfficeId!=null&&brokerOfficeId>0)
			e.addParam(AppParamConstants.subID, brokerOfficeId);
		History.newItem(URLParser.toHistoryToken(e), false );
		requestBrokers();
	}
	
	private void requestBrokers() {
		Integer brokerOfficeId = display.getSelectedBrokerOffice();
		display.setDataRequested();
		if(brokerOfficeId!=null&&brokerOfficeId>0)
			ServiceFactory.getBrokerService().findByBrokerOfficeId(brokerOfficeId, callback);
		else 
			ServiceFactory.getBrokerService().findAll(callback);
	}
	

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	private void brokersRecived(ArrayList<BrokerDTO> result){
		display.setData(result);
	}

	private class ServiceCallback implements AsyncCallback<ArrayList<BrokerDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<BrokerDTO> result) {
			brokersRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		if(brokerOffices==null){
			requestBrokerOffices();
		}else{
			Integer defOfficeId = defParams.getParamAsInteger(AppParamConstants.subID);
			display.setSelectedBrokerOffice(defOfficeId);
			requestBrokers();
		}
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}


	private void requestBrokerOffices() {
		ServiceFactory.getBrokerOfficeService().findAll(brokerOfficesCallback); 
	}
	
	private void brokerOfficesRecived(ArrayList<BrokerOfficeDTO> result){
		brokerOffices = result;
		display.setBrokerOffices(brokerOffices);
		Integer defOfficeId = defParams.getParamAsInteger(AppParamConstants.subID);
		if(defOfficeId!=null){
			display.setSelectedBrokerOffice(defOfficeId);
		}
		requestBrokers();
	}

	private class BrokerOfficesCallback implements AsyncCallback<ArrayList<BrokerOfficeDTO>>{
		@Override
		public void onFailure(Throwable caught) {
			//TODO
		}
		@Override
		public void onSuccess(ArrayList<BrokerOfficeDTO> result) {
			brokerOfficesRecived(result);			
		}
	}




}
