/*package com.dmma.dashboard.gwt.admin.client.mvp.setups.mailtemplate.presenter;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.services.factory.BaseServiceFactory;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.entities.MailTemplateDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.dashboard.gwt.admin.client.mvp.setups.mailtemplate.view.MailTemplateView;
import com.dmma.dashboard.gwt.core.client.types.MailTemplateNameType;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class MailTemplatePresenter implements Presenter {  
	public static String PRESENTER_ID = "mailTemplates";

	private ServiceCallback  callback       = new ServiceCallback();
	private SaveCallback     saveCallback   = new SaveCallback();
	private final MailTemplatePresenterDisplay   display;

	public MailTemplatePresenter(){
		this.display = new MailTemplateView();
		init();
	}


	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
		this.display.getNamesListBox().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				requestMailTemplate();				
			}
		});
	}

	private void doSave() {
		MailTemplateDTO template = display.getData();
		if(template!=null){
			display.setSaveRequested();
			BaseServiceFactory.getMailService().saveOrUpdateTemplate(template, saveCallback); 
		}
	}
	
	private class SaveCallback implements AsyncCallback<Integer>{
		@Override
		public void onFailure(Throwable caught) {
			if(caught!=null && caught instanceof MethodPermissionGError){
				AppDialog.show(BaseMessages.MSG.methodPermissionGError(), AppDialog.ERROR_MESSAGE);
				return;
			}
			AppDialog.show(BaseMessages.MSG.saveOperationFailed(), AppDialog.ERROR_MESSAGE);
			display.setSaved();	
		}
		@Override
		public void onSuccess(Integer result) {
			if(result!=null){
				AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
			}else{
				AppDialog.show(BaseMessages.MSG.saveOperationFailed(), AppDialog.ERROR_MESSAGE);
			}
			display.setSaved();		
		}
	}


	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestMailTemplate() {
		display.setDataRequested();
		String name = display.getSelectedName();
		if(name!=null){
			BaseServiceFactory.getMailService().findTemplateByKey(name, callback); 
		}else{
			display.setData(null, null);
		}
	}
	private void mailTemplateRecived(MailTemplateDTO result){
		if(result==null){
			result = new MailTemplateDTO();
			result.setName(display.getSelectedName());
		}
		display.setData(result, MailTemplateNameType.getTagsByName(result.getName()));
	}
	private class ServiceCallback implements AsyncCallback<MailTemplateDTO>{
		@Override
		public void onFailure(Throwable caught) {
			if(caught!=null && caught instanceof MethodPermissionGError){
				AppDialog.show(BaseMessages.MSG.methodPermissionGError(), AppDialog.ERROR_MESSAGE);
				return;
			}
			mailTemplateRecived(null);	
		}
		@Override
		public void onSuccess(MailTemplateDTO result) {
			mailTemplateRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}






}
*/