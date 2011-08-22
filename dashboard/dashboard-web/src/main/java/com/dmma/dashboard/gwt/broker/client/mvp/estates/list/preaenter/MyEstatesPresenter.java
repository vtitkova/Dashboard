package com.dmma.dashboard.gwt.broker.client.mvp.estates.list.preaenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.add.presenter.AddEstatePresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.list.view.MyEstatesView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class MyEstatesPresenter implements Presenter {  
	public static String PRESENTER_ID = "myEstates";
	private AppEvent defParams;

	private ServiceCallback  callback       = new ServiceCallback();
	private final MyEstatesPresenterDisplay     display;

	public MyEstatesPresenter() {
		this.display = new MyEstatesView();
		init();
	}


	private void init() {
		this.display.getAddNewButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				AppEvent e = new AppEvent(AddEstatePresenter.PRESENTER_ID, this.getClass().getName());
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
		EstateSearchWrapper wrapper = display.getEstateSearchWrapper();
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		if(wrapper.getStatusSearchTypeId()!=null)
			e.addParam(EKP.STATUS_ID, wrapper.getStatusSearchTypeId());
		History.newItem(URLParser.toHistoryToken(e), false);
		requestMyEstates();
	}
	
	
	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestMyEstates() {
		EstateSearchWrapper wrapper = display.getEstateSearchWrapper();
		display.setDataRequested();
		ServiceFactory.getEstateService().findMyEstateBySearchWrapper(wrapper, callback);
	}


	private void estatesRecived(ArrayList<EstateDTO> result){
		display.setData(result);
	}

	private class ServiceCallback extends MyAsyncCallback<ArrayList<EstateDTO>>{
		@Override
		public void onSuccess(ArrayList<EstateDTO> result) {
			estatesRecived(result);			
		}
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		
		EstateSearchWrapper estateSearchWrapper = toEstateSearchWrapper(defParams);
		display.setEstateSearchWrapper(estateSearchWrapper);
		requestMyEstates();
	}

	private EstateSearchWrapper toEstateSearchWrapper(AppEvent event) {
		EstateSearchWrapper wrapper = new EstateSearchWrapper();
		wrapper.setStatusSearchTypeId( event.getParamAsInteger(EKP.STATUS_ID));
		return wrapper;
	}


	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}






}
