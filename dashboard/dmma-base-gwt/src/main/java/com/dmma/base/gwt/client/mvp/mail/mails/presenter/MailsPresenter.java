package com.dmma.base.gwt.client.mvp.mail.mails.presenter;

import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.mvp.mail.mails.view.MailsView;
import com.dmma.base.gwt.client.presenter.IPresenter;
import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.services.factory.BaseServiceFactory;
import com.dmma.base.gwt.shared.entities.MailDTO;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.base.gwt.shared.wrappers.MailSearchWrapper;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.History;

public class MailsPresenter implements IPresenter{  
	public static final String PRESENTER_ID = "mail";
	
	private GetDataCallback  getDatacallback;
	private MailsPresenterDisplay   display;

	public MailsPresenter(){
		// WE ARE LAZY. WE WILL BE INITIALAZEY ONLY AFTER FIRST CALL
	}

	
	@Override
	public IPresenterDisplay getPresenterDisplay() {
		if(display ==null){
			init();
		}
		return display;
	}
	
	private void init() {
		display = new MailsView();
		getDatacallback = new GetDataCallback();
		
		this.display.getStatusCB().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				doChangeHistory();
				requestMails();
			}
		});
		this.display.getTemplateCB().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				doChangeHistory();
				requestMails();
			}
		});
	}

	AppEvent defParams;
	private void doChangeHistory() {
		MailSearchWrapper wrapper = display.getMailSearchWrapper();
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		if(wrapper.getStatusIdId()!=null)
			e.addParam(AppParamConstants.statusId, wrapper.getStatusIdId());
		if(wrapper.getMailTemplateName()!=null)
			e.addParam(AppParamConstants.TEMPLATE_NAME, wrapper.getMailTemplateName());
		
		if(wrapper.getDateFrom()!=null)
			e.addParam(AppParamConstants.FROM_DATE, wrapper.getDateFrom());
		if(wrapper.getDateTo()!=null)
			e.addParam(AppParamConstants.TO_DATE, wrapper.getDateTo());
		defParams = e;
		History.newItem(URLParser.toHistoryToken(e), false );	
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		
		display.setSelectedTemplateName(defParams.getParamAsString(AppParamConstants.TEMPLATE_NAME));
		display.setSelectedStatusId(defParams.getParamAsInteger(AppParamConstants.statusId));
		display.setDateFrom(defParams.getParamAsDate(AppParamConstants.FROM_DATE));
		display.setDateTo(defParams.getParamAsDate(AppParamConstants.TO_DATE));
		requestMails();
	}

	
	


	private void requestMails() {
		MailSearchWrapper wrapper = display.getMailSearchWrapper();
		display.setDataRequested();
		display.setDataRequested();
		BaseServiceFactory.getMailService().findAllMails(wrapper, getDatacallback); 
	}
	private void mailsRecived(ArrayList<MailDTO> result){
		display.setData(result); 
	}
	private class GetDataCallback extends MyAsyncCallback<ArrayList<MailDTO>>{
		@Override
		public void onSuccess(ArrayList<MailDTO> result) {
			mailsRecived(result);
		}
	}
	
	
	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}
	






}
