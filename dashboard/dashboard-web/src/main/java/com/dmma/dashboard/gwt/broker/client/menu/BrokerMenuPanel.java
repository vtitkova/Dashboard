package com.dmma.dashboard.gwt.broker.client.menu;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.add.presenter.AddEstatePresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.list.preaenter.MyEstatesPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.home.presenter.BrokerHomePresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.presenter.BrokersHtsPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.setups.myinfo.presenter.MyInfoPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.tip.myTips.presenter.BrokersTipsPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.presenter.BrokersTipFormPresenter;
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

public class BrokerMenuPanel extends DecoratedStackPanel{
	private static BrokerMenuPanel INSTANCE;

	public static BrokerMenuPanel get(){
		if(INSTANCE==null)
			INSTANCE = new BrokerMenuPanel();
		return 	INSTANCE;
	}


	private BrokerMenuPanel() {
		super();
		init();
	}

	private void init() {
		this.setWidth("230px");
		addHomeMen();
		addTipsMen();
		addHtsMen();
		addClientsMen();
		addEstatesMen();
		addSetupsMen();
	}
	
	private void addHomeMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuHome(), DashboardImages.IMG.home());
		this.add(createHomeItems(), header, true);
	}

	private VerticalPanel createHomeItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuBrokerHome(), BrokerHomePresenter.PRESENTER_ID));
		return panel;
	}
	
	
	
	// TIPSS
	private void addTipsMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuTip(), DashboardImages.IMG.editor());
		this.add(createTipsItems(), header, true);
	}
	private VerticalPanel createTipsItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuMyTips(),  BrokersTipsPresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuTipForm(), BrokersTipFormPresenter.PRESENTER_ID));
		return panel;
	}
	
	// HTS
	private void addHtsMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuHts(), DashboardImages.IMG.editor());
		this.add(createHtsItems(), header, true);
	}
	private VerticalPanel createHtsItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuMyHts(),  BrokersHtsPresenter.PRESENTER_ID));
		//panel.add(createHyperlinkToUserPanel(DashboardTRL.msg.menuHtsForm(), BrokersHtsFormPresenter.PRESENTER_ID));
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
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuAddClient(), EditClientPresenter.PRESENTER_ID));
		return panel;
	}
	
	
	private void addSetupsMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuSetups(), DashboardImages.IMG.setup());
		this.add(createSetupsItems(), header, true);
	}
	
	private VerticalPanel createSetupsItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuSetupsMyProfile(),  MyInfoPresenter.PRESENTER_ID));
		
		return panel;
	}
	
	private void addEstatesMen() {
		String header = getHeaderString(DashboardMessages.MSG.menuEstates(), DashboardImages.IMG.home());
		this.add(createEstatesItems(), header, true);
	}

	private VerticalPanel createEstatesItems() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuEstatesAdd(),   AddEstatePresenter.PRESENTER_ID));
		panel.add(createHyperlinkToUserPanel(DashboardMessages.MSG.menuEstatesList(),  MyEstatesPresenter.PRESENTER_ID));
		return panel;
	}


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
