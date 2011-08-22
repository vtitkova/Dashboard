package com.dmma.dashboard.gwt.core.client.mvp.estate.lookupEstate.presenter;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;

import java.util.ArrayList;

import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.estate.lookupEstate.view.LookupEstateView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.client.types.search.EstateStatusSearchType;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;
 
 
public class LookupEstatePresenter implements LookupPresenterAndView<EstateDTO>{  
	public String title = DashboardMessages.MSG.lookupEstate(); 
	private LookUpPanelListener<EstateDTO> listener;

	private final LookupEstatePresenterDisplay     display;

	public LookupEstatePresenter() {
		this.display = new LookupEstateView();
		init();
	}

	public LookupEstatePresenter(BrokerDTO b) {
		this.display = new LookupEstateView();
		display.setDefaultBroker(b);
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
		this.display.getBrokerChangeHandler().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				requestEstateList();
			}
		});
		this.display.getIsShowOnlyActiveHandler().addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> arg0) {
				requestEstateList();
			}
		});
		requestBrokerOfficeList();
	}
	private void requestBrokerOfficeList() {
		ServiceFactory.getBrokerOfficeService().findAllShort(new MyAsyncCallback<ArrayList<ListBoxDTO>>() {
			@Override
			public void onSuccess(ArrayList<ListBoxDTO> result) {
				display.setBrokerOfficeData(result);
			}
		});
	}
	

	public void doPickUp(){
		EstateDTO pickedUp = display.getPickedUpObject();
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
			display.setBrokerDataRequested();
			ServiceFactory.getBrokerService().findByBrokerOfficeIdShort(bankOfficeId, brokerListCallback);
		}else{
			display.setBrokerData(null);
		}
	}
	private BrokerListCallback brokerListCallback = new BrokerListCallback(); 
	private class BrokerListCallback extends MyAsyncCallback<ArrayList<ListBoxDTO>>{
		@Override
		public void onSuccess(ArrayList<ListBoxDTO> result) {
			display.setBrokerData(result);			
		}
	}
	
	public void requestEstateList(){
		Integer brokerId = display.getSelectedBrokerId();
		if(brokerId!=null && brokerId > 0){
			display.setEstateDataRequested();
			EstateSearchWrapper wrapper = new EstateSearchWrapper();
			if(display.getIsShowOnlyActive())
				wrapper.setStatusSearchTypeId(EstateStatusSearchType.isActive.getId());
			wrapper.setBrokerId(brokerId);
			ServiceFactory.getEstateService().findEstateBySearchWrapperForAll(wrapper, estateListCallback);
		}else{
			display.setEstateData(null);
		}
	}
	private EstateListCallback estateListCallback = new EstateListCallback(); 
	private class EstateListCallback extends MyAsyncCallback<ArrayList<EstateDTO>>{
		@Override
		public void onSuccess(ArrayList<EstateDTO> result) {
			display.setEstateData(result);			
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setLookUpPanelListener(LookUpPanelListener<EstateDTO> listener) {
		this.listener = listener;
	}

	@Override
	public void setDefaultPickedUpObject(EstateDTO defaultObject) {
		display.setDefaultPickedUpObject(defaultObject);
	}

}
