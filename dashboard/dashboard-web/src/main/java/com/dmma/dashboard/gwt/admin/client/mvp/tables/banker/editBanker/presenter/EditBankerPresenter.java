package com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.editBanker.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter.EditBankOfficePresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.bankers.presenter.BankersPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.editBanker.view.EditBankerView;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter.EditUserPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisUserGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditBankerPresenter implements Presenter {  
	public static String PRESENTER_ID = "EditBanker";

	private AppEvent         defParams;
	private BankerDTO   recivedBankerDTO;

	private GetCallback    callback        = new GetCallback();
	private SaveCallback   saveCallback    = new SaveCallback();
	private BankOfficesCallback bankOfficesCallback = new BankOfficesCallback();
	private ArrayList<BankOfficeDTO> bankOffices;
	
	private final EditBankerPresenterDisplay     display;

	public EditBankerPresenter() {
		this.display = new EditBankerView();
		init();
	}

	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
		this.display.getLinkToNewBankOfficeButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				AppEvent event = new AppEvent(EditBankOfficePresenter.PRESENTER_ID, this.getClass().getName());
				History.newItem(URLParser.toHistoryToken(event), true );
			}
		});
		this.display.getLinkToUserButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				if(recivedBankerDTO!=null && recivedBankerDTO.getUserId()!=null  ){
					AppEvent event = new AppEvent(EditUserPresenter.PRESENTER_ID, this.getClass().getName());
					event.addParam(EKP.ID, recivedBankerDTO.getUserId());
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


	private void requestBanker(Integer id) {
		ServiceFactory.getBankerService().findById(id, callback); 
	}


	private void bankerRecived(BankerDTO result){
		recivedBankerDTO = result;
		if(result==null)
			result = new BankerDTO();
		display.setData(result, bankOffices);
	}

	private class GetCallback implements AsyncCallback<BankerDTO>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(BankerDTO result) {
			bankerRecived(result);			
		}
	}



	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		requestBankOffices();
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	private void doSave() {
		BankerDTO eee = display.getData();
		if(eee==null) return;
		String password = display.getPassword();
		ServiceFactory.getBankerService().saveOrUpdate(eee, password, saveCallback); 
	}
	private void dataSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		AppEvent event = new AppEvent(BankersPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(event), true );
	}
	
	private class SaveCallback  extends MyAsyncCallback<Integer>{
		@Override
		public void onnFailure(Throwable caught) {
			if(caught!=null && caught instanceof ExternalOrMidasIdIsInUseGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisMidasId(), AppDialog.ERROR_MESSAGE);
				display.errorInExternalIdField();
				return;
			}else if(caught!=null && caught instanceof SomeoneElseHaveThisUserGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseBankerHaveThisUser(), AppDialog.ERROR_MESSAGE);
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

	
	
	
	
	
	private void requestBankOffices() {
		ServiceFactory.getBankOfficeService().findAll(bankOfficesCallback); 
	}
	private void bankOfficesRecived(ArrayList<BankOfficeDTO> result){
		bankOffices = result;
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id!=null)
			requestBanker(id);
		else {
			recivedBankerDTO = new BankerDTO();
			Integer userId = defParams.getParamAsInteger(EKP.USER_ID);
			recivedBankerDTO.setUserId(userId);
			display.setData(recivedBankerDTO, bankOffices);
		}
	}
	private class BankOfficesCallback implements AsyncCallback<ArrayList<BankOfficeDTO>>{
		@Override
		public void onFailure(Throwable caught) {
			//TODO
		}
		@Override
		public void onSuccess(ArrayList<BankOfficeDTO> result) {
			bankOfficesRecived(result);			
		}
	}



}
