package com.dmma.dashboard.gwt.broker.client;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.dashboard.gwt.broker.client.menu.BrokerMenuPanel;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.add.presenter.AddEstatePresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.details.presenter.EstateDetailsPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.list.preaenter.MyEstatesPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.home.presenter.BrokerHomePresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.presenter.BrokersHtsFormPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.presenter.BrokersHtsPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.setups.myinfo.presenter.MyInfoPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.tip.myTips.presenter.BrokersTipsPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.presenter.BrokersTipFormPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter.EditClientPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.presenter.ClientVisitPlannerPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.view.ClientVisitPlannerView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;


public class BrokerMainController implements ValueChangeHandler<String> {
	private final HasWidgets rootPanel;
	private HasWidgets workContainer;
	private Presenter  currentPresenter;
	
	public BrokerMainController(RootPanel rootPanel) {
		this.rootPanel = rootPanel;
		init();
		History.addValueChangeHandler(this);
		History.fireCurrentHistoryState();
	}

	private void init() {
		rootPanel.clear();
		FlexTable content = new FlexTable();
		rootPanel.add(content);

		content.setWidget(0, 0, BrokerMenuPanel.get());
		content.getFlexCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);

		FlowPanel emptyPanel = new FlowPanel();
		this.workContainer = emptyPanel; 
		content.setWidget(0, 1, emptyPanel);
		content.getFlexCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);

		currentPresenter = null;
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		AppEvent e = URLParser.parse(token);
		String key = e.getKey();

		if(currentPresenter == null || !currentPresenter.getPresenterId().equals(key)){
			if(EditClientPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EditClientPresenter();
			}else if(AddEstatePresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new AddEstatePresenter();
			}else if(MyEstatesPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new MyEstatesPresenter();
			}else if(EstateDetailsPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EstateDetailsPresenter();
			}else if(MyInfoPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new MyInfoPresenter();
			}else if(BrokerHomePresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BrokerHomePresenter();
			}else if(BrokersTipsPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BrokersTipsPresenter();
			}else if(BrokersTipFormPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BrokersTipFormPresenter();
			}else if(ClientVisitPlannerPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new ClientVisitPlannerPresenter(ClientVisitPlannerView.MEGLER_MODE);
			}else if(BrokersHtsPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BrokersHtsPresenter();
			}else if(BrokersHtsFormPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BrokersHtsFormPresenter();
			}else {
				History.newItem("home");
				return;
			}
			currentPresenter.repaintWidget(workContainer);
		}
		
		if(currentPresenter!=null){
			currentPresenter.applyNewParams(e);
		}
	}
}
