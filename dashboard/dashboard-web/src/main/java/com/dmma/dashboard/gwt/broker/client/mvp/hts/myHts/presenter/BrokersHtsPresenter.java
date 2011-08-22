package com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.view.BrokersHtsView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.HtsSearchWrapper;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class BrokersHtsPresenter implements Presenter {  
	public static String PRESENTER_ID = "MyHts";
	private AppEvent     defParams;

	private GetCallback    getCallback    = new GetCallback();
	private final BrokersHtsPresenterDisplay   display;
	
	public BrokersHtsPresenter() {
		display = new BrokersHtsView();
		init();
	}

	private void init() {
		this.display.getFindButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doChangeHistory();
				requestHts();
			}
		});
	}
	
	private void doChangeHistory() {
		HtsSearchWrapper wrapper = display.getHtsSearchWrapper();
		AppEvent e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		if(wrapper.getWantsToSellSearchTypeId()!=null)
			e.addParam(EKP.HTS_WTS_TYPE, wrapper.getWantsToSellSearchTypeId());
		if(wrapper.getHtcStatusSearchTypeId()!=null)
			e.addParam(EKP.HTS_STATUS, wrapper.getHtcStatusSearchTypeId());
		
		/* only in admin mode
		 * if(wrapper.getBrokerOfficeId()!=null)
			e.addParam(EKP.BROKER_OFFICE_ID, wrapper.getBrokerOfficeId());
		if(wrapper.getBrokerId()!=null)
			e.addParam(EKP.BROKER_ID, wrapper.getBrokerId());*/
		
		
		if(wrapper.getDateFrom()!=null)
			e.addParam(EKP.FROM_DATE, wrapper.getDateFrom());
		if(wrapper.getDateTo()!=null)
			e.addParam(EKP.TO_DATE, wrapper.getDateTo());
		defParams = e;
		History.newItem(URLParser.toHistoryToken(e), false );	
	}
	
	
	
	private void requestHts() {
		display.setDataRequested();
		HtsSearchWrapper wrapper = display.getHtsSearchWrapper();
		ServiceFactory.getHaveToSellService().findHtsBySearchWrapperAsBroker(wrapper, getCallback);
	}
	private void htsReceived(ArrayList<HaveToSellDTO> result){
		display.setData(result);
	}
	
	private class GetCallback extends MyAsyncCallback<ArrayList<HaveToSellDTO>>{
		@Override
		public void onSuccess(ArrayList<HaveToSellDTO> result) {
			htsReceived(result);			
		}
	}
	
	
	
	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
	
	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		
		display.setWantsToSellSearchTypeId(defParams.getParamAsInteger(EKP.HTS_WTS_TYPE));
		display.setHtcStatusSearchTypeId(defParams.getParamAsInteger(EKP.HTS_STATUS));
		
		display.setDateFrom(defParams.getParamAsDate(EKP.FROM_DATE));
		display.setDateTo(defParams.getParamAsDate(EKP.TO_DATE));
	}
	
	
	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

}
