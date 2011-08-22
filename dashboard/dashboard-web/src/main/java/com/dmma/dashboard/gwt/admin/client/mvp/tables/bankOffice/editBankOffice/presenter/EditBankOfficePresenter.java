package com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.bankOffices.presenter.BankOfficesPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.view.EditBankOfficeView;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditBankOfficePresenter implements Presenter {  
	public static String PRESENTER_ID = "EditBankOffice";

	private AppEvent         defParams;

	private GetCallback    callback        = new GetCallback();
	private SaveCallback   saveCallback    = new SaveCallback();

	private final EditBankOfficePresenterDisplay     display;

	public EditBankOfficePresenter() {
		this.display = new EditBankOfficeView();
		init();
	}

	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
	}

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestBankOffice(Integer id) {
		ServiceFactory.getBankOfficeService().findById(id, callback); 
	}


	private void bankOfficeRecived(BankOfficeDTO result){
		if(result==null)
			result = new BankOfficeDTO();
		display.setData(result);
	}

	private class GetCallback implements AsyncCallback<BankOfficeDTO>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(BankOfficeDTO result) {
			bankOfficeRecived(result);			
		}
	}



	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id!=null)
			requestBankOffice(id);
		else display.setData(new BankOfficeDTO());
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	private void doSave() {
		BankOfficeDTO eee = display.getData();
		if(eee==null) return;
		ServiceFactory.getBankOfficeService().saveOrUpdate(eee,saveCallback); 
	}
	private void dataSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		AppEvent e = new AppEvent(BankOfficesPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(e), true );
		//EventBus.get().fireEvent(new AppGwtEvent(event));
	}
	private class SaveCallback extends MyAsyncCallback<Integer>{
		@Override
		public void onnFailure(Throwable caught) {
			if(caught!=null && caught instanceof ExternalOrMidasIdIsInUseGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisExternalId(), AppDialog.ERROR_MESSAGE);
				display.errorInExternalIdField();
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

	

}
