package com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.view.EditUserView;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditUserPresenter implements Presenter {  
	public static String PRESENTER_ID = "EditUser";

	private AppEvent     defParams;
	private GetCallback  callback     = new GetCallback();
	private SaveCallback saveCallback = new SaveCallback();

	private final EditUserPresenterDisplay     display;

	public EditUserPresenter() {
		this.display = new EditUserView();
		init();
	}

	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
		this.display.getIsAdminCB().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				Boolean status = display.getIsAdmin();
				Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
				doChangeMyAdminStatus(id,status);
			}
		});
	}

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());

		
	}


	private void requestUser(Integer id) {
		display.setBankerProfileRequested();
		display.setBrokerProfileRequested();
		display.setAdminProfileRequested();
		display.setDataRequested();
		ServiceFactory.getUserService().findById(id, callback); 
	}

	private void userRecived(UserDTO result){
		if(result==null){
			// Redirect
			AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(e), true );
			//EventBus.get().fireEvent(new AppGwtEvent(e));
		}else{
			display.setData(result);
			display.setBrokerProfileRequested();
			display.setBankerProfileRequested();
			display.setAdminProfileRequested();
			requestBrokerProfile( result.getId());
			requestBankerProfile( result.getId());
			requestAdminProfile(  result.getId());
		}
	}

	
	private class GetCallback implements AsyncCallback<UserDTO>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(UserDTO result) {
			userRecived(result);			
		}
	}



	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id!=null)
			requestUser(id);
		else {
			display.setData(new UserDTO());
			display.setBrokerProfile(null, null);
			display.setBankerProfile(null, null);
			display.setAdminProfile(null);
		}
		
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	
	private void doSave() {
		UserDTO eee = display.getData();
		if(eee==null) return;
		ServiceFactory.getUserService().saveOrUpdate(eee,saveCallback); 
	}
	private void dataSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		AppEvent event = new AppEvent(PRESENTER_ID, this.getClass().getName());
		event.addParam(EKP.ID, result);
		History.newItem(URLParser.toHistoryToken(event), true );
		//EventBus.get().fireEvent(new AppGwtEvent(event));
	}

	private class SaveCallback extends MyAsyncCallback<Integer>{
		@Override
		public void onnFailure(Throwable caught) {
			if(caught!=null && caught instanceof EmailIsNotUniqueGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisEmail(), AppDialog.ERROR_MESSAGE);
				display.errorInEmailField();
				return;
			}
			AppDialog.show(BaseMessages.MSG.saveOperationFailed(), AppDialog.ERROR_MESSAGE);
		}
		@Override
		public void onSuccess(Integer result) {
			if(result==null)
				onnFailure(null);
			else
				dataSaved(result);			
		}
	}

	

	/* Processing BrokerProfile, Banker profile*/
	private void requestBrokerProfile(final Integer userId) {
		ServiceFactory.getBrokerService().findByUserId(userId, new AsyncCallback<BrokerDTO>() {
			public void onSuccess(BrokerDTO result) {
				EditUserPresenter.this.display.setBrokerProfile(result, userId);
			}
			public void onFailure(Throwable caught) {
			}
		});
	}
	private void requestBankerProfile(final Integer userId) {
		ServiceFactory.getBankerService().findByUserId(userId, new AsyncCallback<BankerDTO>() {
			public void onSuccess(BankerDTO result) {
				EditUserPresenter.this.display.setBankerProfile(result, userId);
			}
			public void onFailure(Throwable caught) {
			}
		});
	}
	private void requestAdminProfile(Integer userId) {
		ServiceFactory.getUserService().isUserAdmin(userId, new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean isUserAdmin) {
				EditUserPresenter.this.display.setAdminProfile(isUserAdmin);
			}
			public void onFailure(Throwable caught) {
			}
		});
	}
	
	private void doChangeMyAdminStatus(Integer userId, Boolean isAdmin) {
		ServiceFactory.getUserService().setUserIsAdmin(userId, isAdmin, new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean isUserAdmin) {
				if(!isUserAdmin)
					onFailure(null);
			}
			public void onFailure(Throwable caught) {
				AppDialog.show("Can't change role!", AppDialog.ERROR_MESSAGE);
			}
		});
	}

}