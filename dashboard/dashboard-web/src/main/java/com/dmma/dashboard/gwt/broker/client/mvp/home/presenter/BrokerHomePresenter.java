package com.dmma.dashboard.gwt.broker.client.mvp.home.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.dashboard.gwt.broker.client.mvp.home.view.BrokerHomeView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.UnfinalyzedViewingDTOW;
import com.google.gwt.user.client.ui.HasWidgets;

public class BrokerHomePresenter implements Presenter {  
	public static String PRESENTER_ID = "home";
	
	private final BrokerHomePresenterDisplay     display;
	private HasWidgets container;

	
	public BrokerHomePresenter() {
		this.display = new BrokerHomeView();
		init();
	}


	private void init() {
	}

		
	@Override
	public void repaintWidget(final HasWidgets containerr) {
		container = containerr;
		container.clear();
		container.add(display.asWidget());
	}

	@Override
	public void applyNewParams(AppEvent e) {
		requestTips();
		requestMyHTS();
		requestPartnersHTS();
		requestUnfinalyzedViewings();
	}

	
	private void requestTips() {
		display.setTipsRequested();
		ServiceFactory.getTipService().findTipsTodoAsBroker(new MyAsyncCallback<ArrayList<TipDTO>>() {
			@Override
			public void onSuccess(ArrayList<TipDTO> data) {
				display.setTips(data);
			}
		});
	}
	
	private void requestMyHTS() {
		display.setMyHTSRequested();
		ServiceFactory.getHaveToSellService().findMyHTS(new MyAsyncCallback<ArrayList<HaveToSellDTO>>() {
			@Override
			public void onSuccess(ArrayList<HaveToSellDTO> data) {
				display.setMyHTS(data);
			}
		});
	}
	
	private void requestPartnersHTS() {
		display.setPartnersHTSRequested();
		ServiceFactory.getHaveToSellService().findPartnersHTS(new MyAsyncCallback<ArrayList<HaveToSellDTO>>() {
			@Override
			public void onSuccess(ArrayList<HaveToSellDTO> data) {
				display.setPartnersHTS(data);
			}
		});
	}
	
	
	private void requestUnfinalyzedViewings() {
		display.setUnfinalyzedViewingsRequested();
		ServiceFactory.getClientVisitService().findUnfinalyzedViewings(new MyAsyncCallback<ArrayList<UnfinalyzedViewingDTOW>>() {
			@Override
			public void onSuccess(ArrayList<UnfinalyzedViewingDTOW> data) {
				display.setUnfinalyzedViewings(data);
			}
		});
	}
	
	
	
	
	
	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

}
