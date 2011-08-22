package com.dmma.dashboard.gwt.broker.client.mvp.estates.details.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.details.view.EstateDetailsView;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.list.preaenter.MyEstatesPresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ViewingAndVisitsDTOW;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class EstateDetailsPresenter implements Presenter {  
	public static String PRESENTER_ID = "EstateDetails";

	private AppEvent     defParams;
	private GetCallback  callback     = new GetCallback();
	private SynhronizeCallback synhronizeCallback = new SynhronizeCallback();

	private final EstateDetailsPresenterDisplay     display;

	public EstateDetailsPresenter() {
		this.display = new EstateDetailsView();
		init();
	}

	private void init() {
		display.getSynhronizeButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
				if(id!=null)
					synhronizeEstate(id);
			}
		});
	}

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	private void requestEstate(Integer id) {
		display.setDataRequested();
		ServiceFactory.getEstateService().findByIdAsBroker(id, callback); 
	}
	private void estateRecived(EstateDTO result){
			display.setData(result);
	}
	private class GetCallback extends MyAsyncCallback<EstateDTO>{
		@Override
		public void afterFailure() {
			AppEvent redirectEvent = new AppEvent(MyEstatesPresenter.PRESENTER_ID, this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(redirectEvent), true );
		}
		@Override
		public void onSuccess(EstateDTO result) {
			estateRecived(result);			
		}
	}
	private FVAVCallback fVAVCallback = new FVAVCallback();
	private void requestFutureViewingAndVisits(Integer estateId) {
		display.setFutureViewingAndVisitsDataRequested();
		ServiceFactory.getClientVisitService().findFutureViewingAndVisits(estateId, fVAVCallback); 
	}
	private void futureViewingAndVisitsRecived(ArrayList<ViewingAndVisitsDTOW> result){
		display.setFutureViewingAndVisits(result);
	}
	private class FVAVCallback extends MyAsyncCallback<ArrayList<ViewingAndVisitsDTOW>>{
		@Override
		public void onSuccess(ArrayList<ViewingAndVisitsDTOW> result) {
			futureViewingAndVisitsRecived(result);			
		}
	}
	
	private PVAVCallback pVAVCallback = new PVAVCallback();
	private void requestPastViewingAndVisits(Integer estateId) {
		display.setPastViewingAndVisitsDataRequested();
		ServiceFactory.getClientVisitService().findPastViewingAndVisits(estateId, pVAVCallback); 
	}
	private void pastViewingAndVisitsRecived(ArrayList<ViewingAndVisitsDTOW> result){
		display.setPastViewingAndVisits(result);
	}
	private class PVAVCallback extends MyAsyncCallback<ArrayList<ViewingAndVisitsDTOW>>{
		@Override
		public void onSuccess(ArrayList<ViewingAndVisitsDTOW> result) {
			pastViewingAndVisitsRecived(result);			
		}
	}
	
	
	private void synhronizeEstate(Integer id) {
		display.setDataSynhronizationRequested();
		ServiceFactory.getEstateService().synhronizeEstateById(id, synhronizeCallback); 
	}
	private void estateSynhronized(EstateDTO result){
			display.setDataAfterSynhronization(result);
			if(result!=null){
				requestFutureViewingAndVisits(result.getId());
				requestPastViewingAndVisits(result.getId());
			}
	}
	private class SynhronizeCallback extends MyAsyncCallback<EstateDTO>{
		@Override
		public void onSuccess(EstateDTO result) {
			estateSynhronized(result);			
		}
	}



	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id!=null){
			requestEstate(id);
			requestFutureViewingAndVisits(id);
			requestPastViewingAndVisits(id);
		}else {
			AppEvent redirectEvent = new AppEvent(MyEstatesPresenter.PRESENTER_ID, this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(redirectEvent), true );
		}
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

}