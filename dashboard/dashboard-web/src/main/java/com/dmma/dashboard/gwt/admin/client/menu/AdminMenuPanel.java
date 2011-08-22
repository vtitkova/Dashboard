package com.dmma.dashboard.gwt.admin.client.menu;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
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
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter.EditClientPresenter;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AdminMenuPanel extends DecoratedStackPanel{
	private static AdminMenuPanel INSTANCE;

	public static AdminMenuPanel get(){
		if(INSTANCE==null)
			INSTANCE = new AdminMenuPanel();
		return 	INSTANCE;
	}


	private AdminMenuPanel() {
		super();
		init();
	}

	private void init() {
		this.setWidth("230px");
		addUsersMen();
		addBrokerMen();
		addBankerMen();
		addClientsMen();
		addEstatesMen();
		addTipsMen();
		addSetupsMen();
	}
	
	// CLIENTS
	private void addTipsMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuTip(), DashboardImages.IMG.editor());
		this.add(createTipsItems(), header, true);
	}
	private VerticalPanel createTipsItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuTips(),    TipsPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuTipForm(), TipFormPresenter.PRESENTER_ID));
		return panel;
	}

		
	private void addSetupsMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuSetups(), DashboardImages.IMG.setup());
		this.add(createSetupsItems(), header, true);
	}
	
	private VerticalPanel createSetupsItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuSetupsMyProfile(),  ""));
		//panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuMailTemplates(), MailTemplatePresenter.PRESENTER_ID));
		
		return panel;
	}
	
	private void addEstatesMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuEstates(), DashboardImages.IMG.home());
		this.add(createEstatesItems(), header, true);
	}

	private VerticalPanel createEstatesItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuEstates(), EstatesPresenter.PRESENTER_ID));
		return panel;
	}
	
	private void addUsersMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuUsers(), DashboardImages.IMG.userFolder());
		this.add(createUsersItems(), header, true);
	}

	private VerticalPanel createUsersItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuUsers(),   UsersPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuAddUser(), EditUserPresenter.PRESENTER_ID));
		return panel;
	}

	
	// CLIENTS
	private void addClientsMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuClients(), DashboardImages.IMG.users());
		this.add(createClientsItems(), header, true);
	}
	private VerticalPanel createClientsItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuClients(),   ClientsPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuAddClient(), EditClientPresenter.PRESENTER_ID));
		return panel;
	}
	
	// BROKERS
	private void addBrokerMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuBrokers(), DashboardImages.IMG.userBlue());
		this.add(createBrokerItems(), header, true);
	}
	private VerticalPanel createBrokerItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuBrokerOffices(),   BrokerOfficesPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuAddBrokerOffice(), EditBrokerOfficePresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuBrokers(),   BrokersPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuAddBroker(), EditBrokerPresenter.PRESENTER_ID));
		return panel;
	}
	// BANKERS
	private void addBankerMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuBankers(), DashboardImages.IMG.userGreen());
		this.add(createBankerItems(), header, true);
	}
	private VerticalPanel createBankerItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuBankOffices(),   BankOfficesPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuAddBankOffice(), EditBankOfficePresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuBankers(),   BankersPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuAddBanker(), EditBankerPresenter.PRESENTER_ID));
		return panel;
	}
	

	/*private VerticalPanel createReportsItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel("Groups report", ""));
		//panel.add(createHyperlinkToUserPanel("Types  report", TypesReportPresenter.PRESENTER_ID));
		//panel.add(createHyperlinkToUserPanel("Period report", PeriodPresenter.PRESENTER_ID));
		return panel;
	}*/
	
	private String getHeaderString(String text, ImageResource imageResource) {
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setSpacing(0);
		hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hPanel.add(new Image(imageResource));
		HTML headerText = new HTML(text);
		headerText.setStyleName("cw-StackPanelHeader");
		hPanel.add(headerText);
		return hPanel.getElement().getString();
	}

	private Widget createHyperlinkToUserPanel(String title, String token) {
		AppEvent e = new AppEvent(token, this.getClass().getName());
		Hyperlink hp = new Hyperlink(title, URLParser.toHistoryToken(e));
		return hp;
	}
} 
