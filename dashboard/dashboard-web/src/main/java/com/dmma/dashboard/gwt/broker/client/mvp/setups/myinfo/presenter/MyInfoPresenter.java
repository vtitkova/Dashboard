package com.dmma.dashboard.gwt.broker.client.mvp.setups.myinfo.presenter;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.ui.changepassword.ChangePasswordListener;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.dashboard.gwt.broker.client.mvp.setups.myinfo.view.MyInfoView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class MyInfoPresenter implements Presenter {  
	public static String PRESENTER_ID = "MyInfo";
	private final MyInfoPresenterDisplay     display;

	private GetCallback      callback          = new GetCallback();
	private ChangePasswordCallback  changePasswordCallback       = new ChangePasswordCallback();
	
	public MyInfoPresenter() {
		this.display = new MyInfoView();
		init();
	}

	private void init() {
		this.display.setChangePasswordListener(new ChangePasswordListener() {
			@Override
			public void changePassword(String oldPassword, String newPassword) {
				ServiceFactory.getUserService().changeMyPassword(oldPassword, newPassword, changePasswordCallback);
			}   
		});
	}


	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	private void requestMyInfo() {
		display.setDataRequested();
		ServiceFactory.getBrokerService().getMyInfo(callback);
	}


	private void myInfoRecived(BrokerDTO result){
		display.setData(result);
	}

	private class GetCallback implements AsyncCallback<BrokerDTO>{
		@Override
		public void onFailure(Throwable caught) {
			AppDialog.show("Request failed", AppDialog.ERROR_MESSAGE);
			myInfoRecived(null);
		}
		@Override
		public void onSuccess(BrokerDTO result) {
			myInfoRecived(result);			
		}
	}

	@Override
	public void applyNewParams(AppEvent e) {
		requestMyInfo();
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	private class ChangePasswordCallback implements AsyncCallback<Boolean>{
		@Override
		public void onFailure(Throwable caught) {
			display.setPasswordChangeStatus(false);
		}
		@Override
		public void onSuccess(Boolean result) {
			display.setPasswordChangeStatus(result);		
		}
	}

	
}
