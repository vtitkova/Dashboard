package com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.brokerOffices.presenter.BrokerOfficesPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.view.EditBrokerOfficeView;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditBrokerOfficePresenter implements Presenter {  
	public static String PRESENTER_ID = "EditBrokerOffice";

	private AppEvent         defParams;

	private GetCallback    callback        = new GetCallback();
	private SaveCallback   saveCallback    = new SaveCallback();

	private final EditBrokerOfficePresenterDisplay     display;

	public EditBrokerOfficePresenter(){
		this.display = new EditBrokerOfficeView();
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


	private void requestBrokerOffice(Integer id) {
		ServiceFactory.getBrokerOfficeService().findById(id, callback); 
	}


	private void brokerOfficeRecived(BrokerOfficeDTO result){
		if(result==null)
			result = new BrokerOfficeDTO();
		display.setData(result);
	}

	private class GetCallback implements AsyncCallback<BrokerOfficeDTO>{
		@Override
		public void onFailure(Throwable caught) {
		}
		@Override
		public void onSuccess(BrokerOfficeDTO result) {
			brokerOfficeRecived(result);			
		}
	}



	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id!=null)
			requestBrokerOffice(id);
		else 
			display.setData(new BrokerOfficeDTO());

	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	private void doSave() {
		BrokerOfficeDTO eee = display.getData();
		if(eee==null) return;
		ServiceFactory.getBrokerOfficeService().saveOrUpdate(eee,saveCallback); 
	}
	private void dataSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		AppEvent e = new AppEvent(BrokerOfficesPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(e), true );	
		//EventBus.get().fireEvent(new AppGwtEvent(event));
	}
	private class SaveCallback extends MyAsyncCallback<Integer>{
		@Override
		public void onnFailure(Throwable caught) {
			if(caught!=null && caught instanceof ExternalOrMidasIdIsInUseGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisMidasId(), AppDialog.ERROR_MESSAGE);
				display.errorInMidasIdField();
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
