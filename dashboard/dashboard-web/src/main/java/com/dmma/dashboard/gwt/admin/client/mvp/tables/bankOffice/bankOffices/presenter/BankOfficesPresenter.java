package com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.bankOffices.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.bankOffices.view.BankOfficesView;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter.EditBankOfficePresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class BankOfficesPresenter implements Presenter {  
	public static String PRESENTER_ID = "bankOffices";

	private ServiceCallback  callback       = new ServiceCallback();
	private final BankOfficesPresenterDisplay     display;

	public BankOfficesPresenter(){
		this.display = new BankOfficesView();
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
		AppEvent e = new AppEvent(EditBankOfficePresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(e), true );		
	}
	

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestBankOffices() {
		display.setDataRequested();
		ServiceFactory.getBankOfficeService().findAll(callback); 
	}
	private void bankOfficesRecived(ArrayList<BankOfficeDTO> result){
		display.setData(result);
	}
	private class ServiceCallback implements AsyncCallback<ArrayList<BankOfficeDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<BankOfficeDTO> result) {
			bankOfficesRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		requestBankOffices();
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}






}
