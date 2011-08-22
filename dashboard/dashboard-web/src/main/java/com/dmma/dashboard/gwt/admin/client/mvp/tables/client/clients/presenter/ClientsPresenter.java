package com.dmma.dashboard.gwt.admin.client.mvp.tables.client.clients.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.client.clients.view.ClientsView;
import com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter.EditClientPresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class ClientsPresenter implements Presenter {  
	public static String PRESENTER_ID = "Clients";
	private AppEvent defParams;

	private ServiceCallback  callback       = new ServiceCallback();
	private final ClientsPresenterDisplay     display;

	public ClientsPresenter() {
		this.display = new ClientsView();
		init();
	}


	private void init() {
		this.display.getAddNewButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				AppEvent e = new AppEvent(EditClientPresenter.PRESENTER_ID, this.getClass().getName());
				History.newItem(URLParser.toHistoryToken(e), true );
			}
		});
		this.display.getFindButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doFind();
			}
		});
	}

	private void doFind() {
		String phoneStarts = display.getPhoneStarts();
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		if(phoneStarts!=null)
			e.addParam(EKP.PHONE_STARTS, phoneStarts);
		History.newItem(URLParser.toHistoryToken(e), false);
		requestClients();
	}
	

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestClients() {
		String phoneStarts = display.getPhoneStarts();
		display.setDataRequested();
		if(phoneStarts!=null)
			ServiceFactory.getClientService().findByStartsWithPhone(phoneStarts, callback);
		else
			ServiceFactory.getClientService().findAll(callback); 
	}


	private void clientRecived(ArrayList<ClientDTO> result){
		display.setData(result);
	}

	private class ServiceCallback implements AsyncCallback<ArrayList<ClientDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<ClientDTO> result) {
			clientRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		String phoneStarts = defParams.getParamAsString(EKP.PHONE_STARTS);
		display.setPhoneStarts(phoneStarts);
		requestClients();
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}






}
