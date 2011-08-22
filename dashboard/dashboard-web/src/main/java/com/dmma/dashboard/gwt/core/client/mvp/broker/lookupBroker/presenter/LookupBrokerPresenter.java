package com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.presenter;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;

import java.util.ArrayList;

import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.view.LookupBrokerView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
 
 
public class LookupBrokerPresenter implements LookupPresenterAndView<BrokerDTO>{  
	public String title = DashboardMessages.MSG.lookupBroker(); 
	private LookUpPanelListener<BrokerDTO> listener;

	private final LookupBrokerPresenterDisplay     display;

	public LookupBrokerPresenter() {
		this.display = new LookupBrokerView();
		init();
	}

	private void init() {
		this.display.getCloseButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				if(listener!=null){
					listener.onLookUpCanceled();
				}
			}
		});
		this.display.getPicUpButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doPickUp();
			}
		});
		this.display.getBrokerOfficeChangeHandler().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				requestBrokerList();
			}
		});
		
		requestBrokerOfficeList();
		requestRecentBrokerList();
	}
	private void requestBrokerOfficeList() {
		ServiceFactory.getBrokerOfficeService().findAllShort(new MyAsyncCallback<ArrayList<ListBoxDTO>>() {
			@Override
			public void onSuccess(ArrayList<ListBoxDTO> result) {
				display.setBrokerOfficeData(result);
			}
		});
	}
	private void requestRecentBrokerList() {
		ServiceFactory.getBrokerService().findMyRecentBrokerList(new MyAsyncCallback<ArrayList<BrokerDTO>>() {
			@Override
			public void onSuccess(ArrayList<BrokerDTO> result) {
				display.setRecentData(result);
			}
		});
	}
	

	public void doPickUp(){
		BrokerDTO pickedUp = display.getPickedUpObject();
		if(listener!=null&&pickedUp!=null){
			listener.onLookUpPickUp(pickedUp);
		}
	}

	public Widget asWidget(){
		return display.asWidget();
	}

	private void requestBrokerList(){
		Integer bankOfficeId = display.getSelectedBrokerOfficeId();
		if(bankOfficeId!=null && bankOfficeId > 0){
			display.setDataRequested();
			ServiceFactory.getBrokerService().findByBrokerOfficeId(bankOfficeId, brokerListCallback);
		}else{
			display.setData(null);
		}
	}
	private BrokerListCallback brokerListCallback = new BrokerListCallback(); 
	private class BrokerListCallback extends MyAsyncCallback<ArrayList<BrokerDTO>>{
		@Override
		public void onSuccess(ArrayList<BrokerDTO> result) {
			display.setData(result);			
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setLookUpPanelListener(LookUpPanelListener<BrokerDTO> listener) {
		this.listener = listener;
	}

	@Override
	public void setDefaultPickedUpObject(BrokerDTO defaultObject) {
		display.setDefaultPickedUpObject(defaultObject);
	}

}
