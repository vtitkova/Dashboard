package com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.brokers.presenter.BrokersPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.view.EditBrokerView;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter.EditBrokerOfficePresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter.EditUserPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisUserGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditBrokerPresenter implements Presenter {  
	public static String PRESENTER_ID = "EditBroker";

	private AppEvent       defParams;
	private BrokerDTO recivedBrokerDTO;
	
	private GetCallback    callback        = new GetCallback();
	private SaveCallback   saveCallback    = new SaveCallback();
	private BrokerOfficesCallback brokerOfficesCallback = new BrokerOfficesCallback();
	private ArrayList<BrokerOfficeDTO> brokerOffices;
	
	private final EditBrokerPresenterDisplay     display;

	public EditBrokerPresenter() {
		this.display = new EditBrokerView();
		init();
	}

	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
		this.display.getLinkToNewBrokerOfficeButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				AppEvent event = new AppEvent(EditBrokerOfficePresenter.PRESENTER_ID, this.getClass().getName());
				History.newItem(URLParser.toHistoryToken(event), true );
			}
		});
		this.display.getLinkToUserButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				if(recivedBrokerDTO!=null && recivedBrokerDTO.getUserId()!=null  ){
					AppEvent event = new AppEvent(EditUserPresenter.PRESENTER_ID, this.getClass().getName());
					event.addParam(EKP.ID, recivedBrokerDTO.getUserId());
					History.newItem(URLParser.toHistoryToken(event), true );
				}
			}
		});
	}

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestBroker(Integer id) {
		ServiceFactory.getBrokerService().findById(id, callback); 
	}


	private void brokerRecived(BrokerDTO result){
		recivedBrokerDTO = result;
		if(result==null)
			result = new BrokerDTO();
		display.setData(result, brokerOffices);
	}

	private class GetCallback implements AsyncCallback<BrokerDTO>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(BrokerDTO result) {
			brokerRecived(result);			
		}
	}



	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		requestBrokerOffices();
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	private void doSave() {
		BrokerDTO eee = display.getData();
		if(eee==null) return;
		String password = display.getPassword();
		ServiceFactory.getBrokerService().saveOrUpdate(eee, password, saveCallback); 
	}
	private void dataSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		AppEvent event = new AppEvent(BrokersPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(event), true );
	}
	private class SaveCallback  extends MyAsyncCallback<Integer>{
		@Override
		public void onnFailure(Throwable caught) {
			if(caught!=null && caught instanceof ExternalOrMidasIdIsInUseGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisMidasId(), AppDialog.ERROR_MESSAGE);
				display.errorInMidasIdField();
				return;
			}else if(caught!=null && caught instanceof SomeoneElseHaveThisUserGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseBrokerHaveThisUser(), AppDialog.ERROR_MESSAGE);
				display.errorInUserField();
				return;
			}else if(caught!=null && caught instanceof EmailIsNotUniqueGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisEmail(), AppDialog.ERROR_MESSAGE);
				display.errorInEmailField();
				return;
			}
			AppDialog.show(BaseMessages.MSG.saveOperationFailed(), AppDialog.ERROR_MESSAGE);
		}
		@Override
		public void onSuccess(Integer result) {
			if(result==null)
				onFailure(null);
			else
				dataSaved(result);				
		}
	}

	
	
	private void requestBrokerOffices() {
		recivedBrokerDTO = null;
		ServiceFactory.getBrokerOfficeService().findAll(brokerOfficesCallback); 
	}
	private void brokerOfficesRecived(ArrayList<BrokerOfficeDTO> result){
		brokerOffices = result;
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id!=null)
			requestBroker(id);
		else {
			recivedBrokerDTO = new BrokerDTO();
			Integer userId = defParams.getParamAsInteger(EKP.USER_ID);
			recivedBrokerDTO.setUserId(userId);
			display.setData(recivedBrokerDTO, brokerOffices);
		}
	}
	private class BrokerOfficesCallback implements AsyncCallback<ArrayList<BrokerOfficeDTO>>{
		@Override
		public void onFailure(Throwable caught) {
			//TODO
		}
		@Override
		public void onSuccess(ArrayList<BrokerOfficeDTO> result) {
			brokerOfficesRecived(result);			
		}
	}



}
