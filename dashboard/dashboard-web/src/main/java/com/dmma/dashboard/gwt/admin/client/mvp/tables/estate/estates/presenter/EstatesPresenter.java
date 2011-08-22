package com.dmma.dashboard.gwt.admin.client.mvp.tables.estate.estates.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.estate.estates.view.EstatesView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class EstatesPresenter implements Presenter {  
	public static String PRESENTER_ID = "Estates";
	private AppEvent   defParams;
	private ArrayList<ListBoxDTO> officesList;

	private ServiceCallback  callback       = new ServiceCallback();
	private final EstatesPresenterDisplay   display;

	public EstatesPresenter() {
		display = new EstatesView();
		init();
	}


	private void init() {
		this.display.getFindButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doChangeHistory();
				requestMyEstates();
			}
		});
		this.display.getOfficesChange().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				display.setBrokersNA();
				doChangeHistory();
				requestBrokersList();
			}
		});
		this.display.getBrokerChange().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				doChangeHistory();
			}
		});
		this.display.getStatusChange().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				doChangeHistory();
			}
		});
	}

	

	private void doChangeHistory() {
		EstateSearchWrapper wrapper = display.getEstateSearchWrapper();
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		if(wrapper.getStatusSearchTypeId()!=null)
			e.addParam(EKP.STATUS_ID, wrapper.getStatusSearchTypeId());
		if(wrapper.getOfficeId()!=null)
			e.addParam(EKP.OFFICE_ID, wrapper.getOfficeId());
		if(wrapper.getBrokerId()!=null)
			e.addParam(EKP.BROKER_ID, wrapper.getBrokerId());
		defParams = e;
		History.newItem(URLParser.toHistoryToken(e), false );	
	}
	
	
	
	@Override
	public void repaintWidget(HasWidgets hasWidgetContainer) {
		hasWidgetContainer.clear();
		hasWidgetContainer.add(display.asWidget());
	}
	
	

	private void requestMyEstates() {
		EstateSearchWrapper wrapper = new EstateSearchWrapper();
		wrapper.setStatusSearchTypeId(defParams.getParamAsInteger(EKP.STATUS_ID));
		wrapper.setOfficeId(defParams.getParamAsInteger(EKP.OFFICE_ID));
		wrapper.setBrokerId(defParams.getParamAsInteger(EKP.BROKER_ID));
		display.setDataRequested();
		ServiceFactory.getEstateService().findEstateBySearchWrapper(wrapper, callback);
	}


	private void estatesRecived(ArrayList<EstateDTO> result){
		display.setData(result);
	}

	private class ServiceCallback implements AsyncCallback<ArrayList<EstateDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<EstateDTO> result) {
			estatesRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		if(officesList==null){
			requestOfficeList();
		}
	}
	
	private void requestOfficeList() {
		display.setOfficesNA();
		display.setBrokersNA();
		
		ServiceFactory.getBrokerOfficeService().findAllShort(new AsyncCallback<ArrayList<ListBoxDTO>>() {
			@Override
			public void onSuccess(ArrayList<ListBoxDTO> result) {
				officesList = result;
				display.setOfficesData(result);
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	
	private void requestBrokersList() {
		display.setBrokersNA();
		Integer officeId = defParams.getParamAsInteger(EKP.OFFICE_ID);
		if(officeId!=null){
			ServiceFactory.getBrokerService().findByBrokerOfficeIdShort(officeId, new AsyncCallback<ArrayList<ListBoxDTO>>() {
				@Override
				public void onSuccess(ArrayList<ListBoxDTO> result) {
					//brokersList = result;
					display.setBrokersData(result);
				}
				@Override
				public void onFailure(Throwable caught) {
				}
			});
		}
	}

	
	

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}






}
