package com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.IPresenter;
import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.client.editClient.view.EditClientView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisPhoneGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditClientPresenter implements IPresenter, Presenter {  
	public static String PRESENTER_ID = "EditClient";

	private AppEvent         defParams;

	private final EditClientPresenterDisplay     display;

	public EditClientPresenter() {
		this.display = new EditClientView();
		init();
	}

	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
	}

	private void requestClient(Integer id) {
		display.setActiveSaveButton(false);
		ServiceFactory.getClientService().findById(id, new MyAsyncCallback<ClientDTO>() {
			@Override
			protected void afterFailure() {
				AppEvent event = new AppEvent(PRESENTER_ID, this.getClass().getName());
				History.newItem(URLParser.toHistoryToken(event), true);
			}
			
			public void onSuccess(ClientDTO result) {
				if(result==null) 
					result = new ClientDTO();
				display.setData(result);		
				display.setActiveSaveButton(true);
			}
		}); 
	}

	@Override
	public void applyNewParams(AppEvent e) {
		defParams = e;
		display.setData(new ClientDTO()); //to clean display
		
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		
		if(id!=null){
			requestClient(id);
		}else{
			display.setActiveSaveButton(true);
		} 
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	private void doSave() {
		ClientDTO eee = display.getData();
		if(eee!=null){
			display.setActiveSaveButton(false);
			ServiceFactory.getClientService().saveOrUpdate(eee,saveCallback); 
		} 
	}
	private void dataSaved(Integer result) {
		display.setActiveSaveButton(true);
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id==null){
			//reload to self
			AppEvent event = new AppEvent(PRESENTER_ID, this.getClass().getName());
			event.addParam(AppParamConstants.ID, result);
			History.newItem(URLParser.toHistoryToken(event), true);
		}		
	}
	private SaveCallback   saveCallback    = new SaveCallback();
	private class SaveCallback extends MyAsyncCallback<Integer>{
		@Override
		public void onnFailure(Throwable caught) {
			if(caught!=null && caught instanceof SomeoneElseHaveThisPhoneGError){
				AppDialog.show(DashboardMessages.MSG.someoneElseHaveThisPhone(), AppDialog.ERROR_MESSAGE);
				display.errorInPhoneField();
			}else{
				super.onnFailure(caught);
			}
			display.setActiveSaveButton(true);
		}
		public void onSuccess(Integer result) {
			if(result==null) onFailure(null);
			else dataSaved(result);			
		}
	}
	
	@Override
	public IPresenterDisplay getPresenterDisplay() {
		return display;
	}

	@Override
	public void repaintWidget(HasWidgets hasWidgetContainer) {
		hasWidgetContainer.clear();
		hasWidgetContainer.add(display.asWidget());
	}

}
