package com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.presenter;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.IPresenter;
import com.dmma.base.gwt.client.presenter.IPresenterDisplay;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.myTips.presenter.BankersTipsPresenter;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.view.BankersTipFormView;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.presenter.AbstractTipFormPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.view.AbstractTipFormView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.user.client.History;

public class BankersTipFormPresenter extends AbstractTipFormPresenter<BankersTipFormView> implements IPresenter {  
	public static String PRESENTER_ID = "TipForm";

	public BankersTipFormPresenter() {
		// TODO change presenter init mode!!
		super(AbstractTipFormView.BANKER_MODE, new BankersTipFormView());
	}

	@Override
	protected void setPickedUpBanker(BankerDTO object) {
		// NA - only for Brokers
	}

	@Override
	protected void setPickedUpBroker(BrokerDTO object) {
		display.setPickedUpBroker(object);
		display.setPickedUpEstate(null);
	}
	
	@Override
	protected void lookUpPartner() {
		lookUpBroker();
	}

	@Override
	protected void removePartner() {
		setPickedUpBroker(null);
	}
	
	
	
	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	@Override
	protected void requestMyInfo() {
		ServiceFactory.getBankerService().getMyInfo(new MyAsyncCallback<BankerDTO>() {
			@Override
			public void onSuccess(BankerDTO result) {
				display.setDefaultBanker(result);
			}
		});
	}

	@Override
	protected void afterSaveSuccessed() {
		AppEvent event = new AppEvent(BankersTipsPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(event), true );
	}

	@Override
	public IPresenterDisplay getPresenterDisplay() {
		return display;
	}
	
		
	
	
}
