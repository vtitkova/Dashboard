package com.dmma.dashboard.gwt.banker.client.mvp.tip.myTips.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.IPresenter;
import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.myTips.view.BankersTipsView;
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

public class BankersTipsPresenter implements IPresenter {  
	public static String PRESENTER_ID = "MyTips";
	private AppEvent     defParams;

	private GetCallback    getCallback;
	private BankersTipsPresenterDisplay   display;
	private ArrayList<ListBoxDTO> brokerOfficeList;
	
	public BankersTipsPresenter() {
		// WE ARE LAZY. WE WILL BE INITIALAZEY ONLY AFTER FIRST CALL
	}
	
	@Override
	public IPresenterDisplay getPresenterDisplay() {
		if(display ==null){
			init();
		}
		return display;
	}


	private void init() {
		display     = new BankersTipsView();
		getCallback = new GetCallback();
		
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
	
	
	private void requestTips() {
		display.setDataRequested();
		TipSearchWrapper wrapper = display.getTipSearchWrapper();
		ServiceFactory.getTipService().findTipsBySearchWrapperAsBanker(wrapper, getCallback);
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


	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

}
