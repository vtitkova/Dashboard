package com.dmma.dashboard.gwt.core.client.mvp.banker.lookupBanker.presenter;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;

import java.util.ArrayList;

import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.banker.lookupBanker.view.LookupBankerView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
 
 
public class LookupBankerPresenter implements LookupPresenterAndView<BankerDTO>{  
	public String title = DashboardMessages.MSG.lookupBanker(); 
	private LookUpPanelListener<BankerDTO> listener;

	private final LookupBankerPresenterDisplay     display;

	public LookupBankerPresenter() {
		this.display = new LookupBankerView();
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
		this.display.getBankOfficeChangeHandler().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				requestBankerList();
			}
		});
		
		requestBankOfficeList();
		requestRecentBankerList();
	}
	private void requestBankOfficeList() {
		ServiceFactory.getBankOfficeService().findAllShort(new MyAsyncCallback<ArrayList<ListBoxDTO>>() {
			@Override
			public void onSuccess(ArrayList<ListBoxDTO> result) {
				display.setBankOfficeData(result);
			}
		});
	}
	private void requestRecentBankerList() {
		ServiceFactory.getBankerService().findMyRecentBankerList(new MyAsyncCallback<ArrayList<BankerDTO>>() {
			@Override
			public void onSuccess(ArrayList<BankerDTO> result) {
				display.setRecentData(result);
			}
		});
	}
	

	public void doPickUp(){
		BankerDTO pickedUp = display.getPickedUpObject();
		if(listener!=null&&pickedUp!=null){
			listener.onLookUpPickUp(pickedUp);
		}
	}

	public Widget asWidget(){
		return display.asWidget();
	}

	private void requestBankerList(){
		Integer bankOfficeId = display.getSelectedBankOfficeId();
		if(bankOfficeId!=null && bankOfficeId > 0){
			display.setDataRequested();
			ServiceFactory.getBankerService().findByBankOfficeId(bankOfficeId, bankerListCallback);
		}else{
			display.setData(null);
		}
	}
	private BankerListCallback bankerListCallback = new BankerListCallback(); 
	private class BankerListCallback extends MyAsyncCallback<ArrayList<BankerDTO>>{
		@Override
		public void onSuccess(ArrayList<BankerDTO> result) {
			display.setData(result);			
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setLookUpPanelListener(LookUpPanelListener<BankerDTO> listener) {
		this.listener = listener;
	}

	@Override
	public void setDefaultPickedUpObject(BankerDTO defaultObject) {
		display.setDefaultPickedUpObject(defaultObject);
	}

}
