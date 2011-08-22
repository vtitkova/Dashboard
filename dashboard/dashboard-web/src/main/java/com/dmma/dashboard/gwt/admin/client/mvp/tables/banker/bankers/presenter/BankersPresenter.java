package com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.bankers.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.bankers.view.BankersView;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.editBanker.presenter.EditBankerPresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class BankersPresenter implements Presenter {  
	public static String PRESENTER_ID = "Bankers";

	private AppEvent              defParams;
	private ArrayList<BankOfficeDTO> bankOffices;
	private BankOfficesCallback   bankOfficesCallback = new BankOfficesCallback();
	private ServiceCallback       callback = new ServiceCallback();
	private final BankersPresenterDisplay     display;

	
	public BankersPresenter() {
		this.display = new BankersView();
		init();
	}


	private void init() {
		this.display.getAddNewButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				AppEvent e = new AppEvent(EditBankerPresenter.PRESENTER_ID, this.getClass().getName());
				History.newItem(URLParser.toHistoryToken(e), true );
			}
		});
		this.display.getBankOfficesLB().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				onBankOfficeChange();				
			}
		});
	}

	private void onBankOfficeChange(){
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		Integer bankOfficeId = display.getSelectedBankOffice();
		if(bankOfficeId!=null&&bankOfficeId>0)
			e.addParam(AppParamConstants.subID, bankOfficeId);
		History.newItem(URLParser.toHistoryToken(e), false );
		requestBankers();
	}
	
	private void requestBankers() {
		Integer bankOfficeId = display.getSelectedBankOffice();
		display.setDataRequested();
		if(bankOfficeId!=null&&bankOfficeId>0)
			ServiceFactory.getBankerService().findByBankOfficeId(bankOfficeId, callback);
		else 
			ServiceFactory.getBankerService().findAll(callback);
	}
	

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	private void bankersRecived(ArrayList<BankerDTO> result){
		display.setData(result);
	}

	private class ServiceCallback implements AsyncCallback<ArrayList<BankerDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<BankerDTO> result) {
			bankersRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		if(bankOffices==null){
			requestBankOffices();
		}else{
			Integer defOfficeId = defParams.getParamAsInteger(AppParamConstants.subID);
			display.setSelectedBankOffice(defOfficeId);
			requestBankers();
		}
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}


	private void requestBankOffices() {
		ServiceFactory.getBankOfficeService().findAll(bankOfficesCallback); 
	}
	private void bankOfficesRecived(ArrayList<BankOfficeDTO> result){
		display.setBankOffices(result);
		Integer defOfficeId = defParams.getParamAsInteger(AppParamConstants.subID);
		if(defOfficeId!=null){
			display.setSelectedBankOffice(defOfficeId);
		}
		onBankOfficeChange();
	}

	private class BankOfficesCallback implements AsyncCallback<ArrayList<BankOfficeDTO>>{
		@Override
		public void onFailure(Throwable caught) {
			//TODO
		}
		@Override
		public void onSuccess(ArrayList<BankOfficeDTO> result) {
			bankOfficesRecived(result);			
		}
	}




}
