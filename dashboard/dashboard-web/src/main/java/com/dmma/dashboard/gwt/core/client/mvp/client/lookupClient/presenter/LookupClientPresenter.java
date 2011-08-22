package com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.presenter;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;

import java.util.ArrayList;

import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.view.LookupClientView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisPhoneGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Widget;
 
 
public class LookupClientPresenter implements LookupPresenterAndView<ClientDTO>{  
	public String title = DashboardMessages.MSG.lookupClient();
	public static int MIN_LOOKUP_CHARS = 2;
	private LookUpPanelListener<ClientDTO> listener;

	private final LookupClientPresenterDisplay     display;

	public LookupClientPresenter() {
		this.display = new LookupClientView();
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
		this.display.getSaveAndPicUpButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSaveAndPickUp();
			}

		});
		
		this.display.getClientPhone().addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent arg0) {
				requestClient();
			}
		});
	}

	public void doPickUp(){
		ClientDTO pickedUp = display.getPickedUpObject();
		if(listener!=null&&pickedUp!=null){
			listener.onLookUpPickUp(pickedUp);
		}
	}

	
	private void doSaveAndPickUp() {
		final ClientDTO eee = display.getNewClient();
		if(eee!=null){
			display.setSavingInProcess();
			ServiceFactory.getClientService().saveOrUpdate(eee,new MyAsyncCallback<Integer>() {
				@Override
				public void onnFailure(Throwable caught) {
					if(caught!=null && caught instanceof SomeoneElseHaveThisPhoneGError){
						AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisPhone(), AppDialog.ERROR_MESSAGE);
						display.errorInPhoneField();
					}else{
						super.onnFailure(caught);
					}
					display.setSavingFailed();
				}
				public void onSuccess(Integer result) {
					if(result==null || eee == null ) onFailure(null);
					eee.setId(result);
					if(listener!=null){
						listener.onLookUpPickUp(eee);
					}
				}
			}); 
		} 
	}

	public Widget asWidget(){
		return display.asWidget();
	}

	private void requestClient() {
		String phoneStart = display.getPhoneLookupString();
		if(phoneStart!=null && phoneStart.length()>=MIN_LOOKUP_CHARS){
			display.setDataRequested();
			ServiceFactory.getClientService().findByStartsWithPhone(phoneStart, requestCallback);
		}else{
			clientsReceived(null);
		}
	};
	private void clientsReceived(ArrayList<ClientDTO> result) {
		display.setData(result);
	};
	private RequestCallback   requestCallback    = new RequestCallback();
	private class RequestCallback extends MyAsyncCallback<ArrayList<ClientDTO>>{
		public void onSuccess(ArrayList<ClientDTO> result) {
			clientsReceived(result);
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setLookUpPanelListener(LookUpPanelListener<ClientDTO> listener) {
		this.listener = listener;
	}

	@Override
	public void setDefaultPickedUpObject(ClientDTO defaultObject) {
		display.setDefaultPickedUpObject(defaultObject);
	}

}
