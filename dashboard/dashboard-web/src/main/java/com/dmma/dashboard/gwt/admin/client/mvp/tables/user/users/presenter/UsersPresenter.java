package com.dmma.dashboard.gwt.admin.client.mvp.tables.user.users.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter.EditUserPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.users.view.UsersView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.UserSearchWrapper;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class UsersPresenter implements Presenter {  
	public static String PRESENTER_ID = "Users";
	private AppEvent defParams;

	private ServiceCallback  callback       = new ServiceCallback();
	private final UsersPresenterDisplay     display;

	public UsersPresenter() {
		this.display = new UsersView();
		init();
	}


	private void init() {
		this.display.getAddNewButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				AppEvent e = new AppEvent(EditUserPresenter.PRESENTER_ID, this.getClass().getName());
				History.newItem(URLParser.toHistoryToken(e), true );
			}
		});
		this.display.getFindButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doFind();
			}
		});
	}


	private void doFind() {
		UserSearchWrapper wrapper = display.getUserSearchWrapper();
		AppEvent e = toAppEvent(wrapper);
		History.newItem(URLParser.toHistoryToken(e), false);
		requestUsers(wrapper);
	}
	
	
	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	
	private UserSearchWrapper toUserSearchWrapper(AppEvent event){
		UserSearchWrapper wrapper = new UserSearchWrapper();
		wrapper.setPartOfEmail( event.getParamAsString( EKP.EMAIL_PART));
		wrapper.setMidasId(     event.getParamAsLong(   EKP.MIDAS_ID));
		wrapper.setExternalId(  event.getParamAsLong(   EKP.EXTERNAL_ID));
		wrapper.setRoleTypeId(  event.getParamAsInteger(EKP.ROLE_ID));
		wrapper.setStatusTypeId(event.getParamAsInteger(EKP.STATUS_ID));
		return wrapper;
	}
	private AppEvent toAppEvent(UserSearchWrapper  wrapper){
		AppEvent event = new AppEvent(PRESENTER_ID, this.getClass().getName());
		if(wrapper.getPartOfEmail()!=null)
			event.addParam(EKP.EMAIL_PART, wrapper.getPartOfEmail());
		if(wrapper.getMidasId()!=null)
			event.addParam(EKP.MIDAS_ID, wrapper.getMidasId());
		if(wrapper.getExternalId()!=null)
			event.addParam(EKP.EXTERNAL_ID, wrapper.getExternalId());
		if(wrapper.getRoleTypeId()!=null)
			event.addParam(EKP.ROLE_ID, wrapper.getRoleTypeId());
		if(wrapper.getStatusTypeId()!=null)
			event.addParam(EKP.STATUS_ID, wrapper.getStatusTypeId());
		return event;
	}
	

	private void requestUsers(UserSearchWrapper userSearchWrapper ) {
		display.setDataRequested();
		ServiceFactory.getUserService().findByUserSearchWrapper(userSearchWrapper, callback); 
	}
	private void userRecived(ArrayList<UserDTO> result){
		display.setData(result);
	}
	private class ServiceCallback implements AsyncCallback<ArrayList<UserDTO>>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(ArrayList<UserDTO> result) {
			userRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		UserSearchWrapper userSearchWrapper = toUserSearchWrapper(defParams);
		display.setUserSearchWrapper(userSearchWrapper);
		requestUsers(userSearchWrapper);
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}






}
