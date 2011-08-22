package com.dmma.dashboard.gwt.admin.client;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.dashboard.gwt.admin.client.menu.AdminMenuPanel;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.bankOffices.presenter.BankOfficesPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter.EditBankOfficePresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.bankers.presenter.BankersPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.editBanker.presenter.EditBankerPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.brokers.presenter.BrokersPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.presenter.EditBrokerPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.brokerOffices.presenter.BrokerOfficesPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter.EditBrokerOfficePresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.client.clients.presenter.ClientsPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.estate.estates.presenter.EstatesPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tipform.presenter.TipFormPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tips.presenter.TipsPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter.EditUserPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.users.presenter.UsersPresenter;
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


public class AdminMainController implements ValueChangeHandler<String> {
	private final HasWidgets rootPanel;
	private HasWidgets workContainer;
	private Presenter  currentPresenter;

	public AdminMainController(RootPanel rootPanel) {
		this.rootPanel = rootPanel;
		init();
		History.addValueChangeHandler(this);
		History.fireCurrentHistoryState();
	}

	private void init() {
		rootPanel.clear();
		FlexTable content = new FlexTable();
		rootPanel.add(content);

		content.setWidget(0, 0, AdminMenuPanel.get());
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
			if(UsersPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new UsersPresenter();
			}else if(EditUserPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EditUserPresenter();
			}else if(BrokerOfficesPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BrokerOfficesPresenter();
			}else if(EditBrokerOfficePresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EditBrokerOfficePresenter();
			}else if(BrokersPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BrokersPresenter();
			}else if(EditBrokerPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EditBrokerPresenter();
			}else if(BankOfficesPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BankOfficesPresenter();
			}else if(EditBankOfficePresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EditBankOfficePresenter();
			}else if(EditBankerPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EditBankerPresenter();
			}else if(BankersPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new BankersPresenter();
			}else if(ClientsPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new ClientsPresenter();
			}else if(EditClientPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EditClientPresenter();
			}else if(EstatesPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new EstatesPresenter();
			}else if(TipFormPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new TipFormPresenter();
			}else if(TipsPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new TipsPresenter();
			}else if(ClientVisitPlannerPresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new ClientVisitPlannerPresenter(ClientVisitPlannerView.ADMIN_MODE);
			/*}else if(MailTemplatePresenter.PRESENTER_ID.equals(key)){
				currentPresenter = new MailTemplatePresenter();*/
			}else {
				// nothing found, redirecting to home
				History.newItem("home");
				return;
			}
			currentPresenter.repaintWidget(workContainer);
		}

		currentPresenter.applyNewParams(e);

	}

}
