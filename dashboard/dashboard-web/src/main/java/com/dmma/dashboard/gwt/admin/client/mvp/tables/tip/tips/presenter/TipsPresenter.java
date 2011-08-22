package com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tips.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tips.view.TipsView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class TipsPresenter implements Presenter {  
	public static String PRESENTER_ID = "Tips";
	private AppEvent     defParams;

	private GetCallback    getCallback    = new GetCallback();
	private final TipsPresenterDisplay   display;
	private ArrayList<ListBoxDTO> brokerOfficeList;
	private ArrayList<ListBoxDTO> bankOfficeList;
	
	public TipsPresenter() {
		display = new TipsView();
		init();
	}


	private void init() {
		this.display.getFindButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doChangeHistory();
				requestTips();
			}
		});
		this.display.getBrokerOfficeChange().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				requestBrokerList();
			}
		});
		this.display.getBankOfficeChange().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				requestBankerList();
			}
		});
	}
	
	private void doChangeHistory() {
		TipSearchWrapper wrapper = display.getTipSearchWrapper();
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		if(wrapper.getTipDirectionSearchTypeId()!=null)
			e.addParam(EKP.TIP_DIRECTION, wrapper.getTipDirectionSearchTypeId());
		if(wrapper.getTipTypeSearchTypeId()!=null)
			e.addParam(EKP.TIP_TYPE, wrapper.getTipTypeSearchTypeId());
		if(wrapper.getTipStatusSearchTypeId()!=null)
			e.addParam(EKP.TIP_STATUS, wrapper.getTipStatusSearchTypeId());
		
		if(wrapper.getBankOfficeId()!=null)
			e.addParam(EKP.BANK_OFFICE_ID, wrapper.getBankOfficeId());
		if(wrapper.getBankerId()!=null)
			e.addParam(EKP.BANKER_ID, wrapper.getBankerId());
		
		
		if(wrapper.getBrokerOfficeId()!=null)
			e.addParam(EKP.BROKER_OFFICE_ID, wrapper.getBrokerOfficeId());
		if(wrapper.getBrokerId()!=null)
			e.addParam(EKP.BROKER_ID, wrapper.getBrokerId());
		
		
		if(wrapper.getDateFrom()!=null)
			e.addParam(EKP.FROM_DATE, wrapper.getDateFrom());
		if(wrapper.getDateTo()!=null)
			e.addParam(EKP.TO_DATE, wrapper.getDateTo());
		defParams = e;
		History.newItem(URLParser.toHistoryToken(e), false );	
	}
	
	
	private void requestBrokerList(){
		display.setBrokerDataNA();
		Integer brokerOfficeId = display.getSelectedBrokerOfficeId();
		if(brokerOfficeId!=null && brokerOfficeId > 0)
			ServiceFactory.getBrokerService().findByBrokerOfficeIdShort(brokerOfficeId, brokerListCallback);
	}
	private void brokerListReceved(ArrayList<ListBoxDTO> result){
		display.setBrokerData(result);
		Integer brokerId = defParams.getParamAsInteger(EKP.BROKER_ID);
		if(brokerId!=null&&brokerId>0){
			display.setSelectedBrokerId(brokerId);
			defParams.addParam(EKP.BROKER_ID, null);
		}
	}
	private BrokerListCallback brokerListCallback = new BrokerListCallback(); 
	private class BrokerListCallback implements AsyncCallback<ArrayList<ListBoxDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<ListBoxDTO> result) {
			brokerListReceved(result);			
		}
	}
	private void requestBankerList(){
		display.setBankerDataNA();
		Integer bankOfficeId = display.getSelectedBankOfficeId();
		if(bankOfficeId!=null && bankOfficeId > 0)
			ServiceFactory.getBankerService().findByBankOfficeIdShort(bankOfficeId, bankerListCallback);
	}
	private void bankerListReceved(ArrayList<ListBoxDTO> result){
		display.setBankerData(result);
		Integer bankerId = defParams.getParamAsInteger(EKP.BANKER_ID);
		if(bankerId!=null&&bankerId>0){
			display.setSelectedBankerId(bankerId);
			defParams.addParam(EKP.BANKER_ID, null);
		}
	}
	private BankerListCallback bankerListCallback = new BankerListCallback(); 
	private class BankerListCallback extends MyAsyncCallback<ArrayList<ListBoxDTO>>{
		@Override
		public void onSuccess(ArrayList<ListBoxDTO> result) {
			bankerListReceved(result);			
		}
	}
	
	
	private void requestTips() {
		display.setDataRequested();
		TipSearchWrapper wrapper = display.getTipSearchWrapper();
		ServiceFactory.getTipService().findTipsBySearchWrapperAsAdmin(wrapper, getCallback);
	}
	private void tipsReceived(ArrayList<TipDTO> result){
		display.setData(result);
	}
	
	private class GetCallback extends MyAsyncCallback<ArrayList<TipDTO>>{
		@Override
		public void onSuccess(ArrayList<TipDTO> result) {
			tipsReceived(result);			
		}
	}
	
	
	
	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		
		if(brokerOfficeList==null){
			requestBrokerOfficeList();
		}else{
			Integer brokerOfficeId = defParams.getParamAsInteger(EKP.BROKER_OFFICE_ID);
			display.setSelectedBrokerOfficeId(brokerOfficeId);
			requestBrokerList();
		}
		
		if(bankOfficeList==null){
			requestBankOfficeList();
		}else{
			Integer bankOfficeId = defParams.getParamAsInteger(EKP.BANK_OFFICE_ID);
			display.setSelectedBankOfficeId(bankOfficeId);
			requestBankerList();
		}
		
		display.setTipDirectionSearchTypeId(defParams.getParamAsInteger(EKP.TIP_DIRECTION));
		display.setTipTypeSearchTypeId(defParams.getParamAsInteger(EKP.TIP_TYPE));
		display.setTipStatusSearchTypeId(defParams.getParamAsInteger(EKP.TIP_STATUS));
		
		display.setDateFrom(defParams.getParamAsDate(EKP.FROM_DATE));
		display.setDateTo(defParams.getParamAsDate(EKP.TO_DATE));
	}
	
	private void requestBrokerOfficeList() {
		ServiceFactory.getBrokerOfficeService().findAllShort(new AsyncCallback<ArrayList<ListBoxDTO>>() {
			@Override
			public void onSuccess(ArrayList<ListBoxDTO> result) {
				brokerOfficeList = result;
				display.setBrokerOfficeData(brokerOfficeList);
				Integer brokerOfficeId = defParams.getParamAsInteger(EKP.BROKER_OFFICE_ID);
				if(brokerOfficeId!=null&&brokerOfficeId>0){
					display.setSelectedBrokerOfficeId(brokerOfficeId);
					requestBrokerList();
				}
			}
			@Override
			public void onFailure(Throwable arg0) {
			}
		});
	}

	private void requestBankOfficeList() {
		ServiceFactory.getBankOfficeService().findAllShort(new AsyncCallback<ArrayList<ListBoxDTO>>() {
			@Override
			public void onSuccess(ArrayList<ListBoxDTO> result) {
				bankOfficeList = result;
				display.setBankOfficeData(bankOfficeList);
				Integer bankOfficeId = defParams.getParamAsInteger(EKP.BANK_OFFICE_ID);
				if(bankOfficeId!=null&&bankOfficeId>0){
					display.setSelectedBankOfficeId(bankOfficeId);
					requestBankerList();
				}
			}
			@Override
			public void onFailure(Throwable arg0) {
			}
		});
	}


	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

}
