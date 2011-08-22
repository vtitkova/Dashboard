package com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.brokerOffices.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.brokerOffices.view.BrokerOfficesView;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter.EditBrokerOfficePresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class BrokerOfficesPresenter implements Presenter {  
	public static String PRESENTER_ID = "brokerOffices";

	private ServiceCallback  callback       = new ServiceCallback();
	private final BrokerOfficesPresenterDisplay     display;

	public BrokerOfficesPresenter() {
		this.display = new BrokerOfficesView();
		init();
	}


	private void init() {
		this.display.getAddNewButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doCreate();
			}
		});
	}

	private void doCreate() { 
		AppEvent e = new AppEvent(EditBrokerOfficePresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(e), true );		
	}
	

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestBrokerOffices() {
		display.setDataRequested();
		ServiceFactory.getBrokerOfficeService().findAll(callback); 
	}


	private void brokerOfficesRecived(ArrayList<BrokerOfficeDTO> result){
		display.setData(result);
	}

	private class ServiceCallback implements AsyncCallback<ArrayList<BrokerOfficeDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<BrokerOfficeDTO> result) {
			brokerOfficesRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		requestBrokerOffices();
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}






}
