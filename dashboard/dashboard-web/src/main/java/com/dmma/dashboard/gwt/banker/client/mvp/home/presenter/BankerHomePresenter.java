package com.dmma.dashboard.gwt.banker.client.mvp.home.presenter;


import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.presenter.IPresenter;
import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.dashboard.gwt.banker.client.mvp.home.view.BankerHomeView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;

public class BankerHomePresenter implements IPresenter {  
	public static String PRESENTER_ID = "home";
	
	private BankerHomePresenterDisplay     display;

	public BankerHomePresenter() {
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
		this.display = new BankerHomeView();
	}

		
	@Override
	public void applyNewParams(AppEvent e) {
		requestTips();
	}
	
	private void requestTips() {
		display.setTipsRequested();
		ServiceFactory.getTipService().findTipsTodoAsBanker(new MyAsyncCallback<ArrayList<TipDTO>>() {
			@Override
			public void onSuccess(ArrayList<TipDTO> data) {
				display.setTips(data);
			}
		});
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

}
