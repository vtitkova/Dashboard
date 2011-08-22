package com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.presenter;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.dashboard.gwt.broker.client.mvp.tip.myTips.presenter.BrokersTipsPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.view.BrokersTipFormView;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.presenter.AbstractTipFormPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.view.AbstractTipFormView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.user.client.History;

public class BrokersTipFormPresenter extends AbstractTipFormPresenter<BrokersTipFormView> implements Presenter {  
	public static String PRESENTER_ID = "TipForm";
	
	public BrokersTipFormPresenter() {
		super(AbstractTipFormView.MEGLER_MODE, new BrokersTipFormView());
	}

	
	@Override
	protected void setPickedUpBanker(BankerDTO object) {
		display.setPickedUpBanker(object);
	}

	@Override
	protected void setPickedUpBroker(BrokerDTO object) {
		// NA - only for Bankers
	}

	@Override
	protected void lookUpPartner() {
		lookUpBanker();
	}

	@Override
	protected void removePartner() {
		setPickedUpBanker(null);
	}
	
	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	@Override
	protected void requestMyInfo() {
		ServiceFactory.getBrokerService().getMyInfo(new MyAsyncCallback<BrokerDTO>() {
			@Override
			public void onSuccess(BrokerDTO result) {
				display.setDefaultBroker(result);
			}
		});
	}

	@Override
	protected void afterSaveSuccessed() {
		AppEvent event = new AppEvent(BrokersTipsPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(event), true );
	}

}
