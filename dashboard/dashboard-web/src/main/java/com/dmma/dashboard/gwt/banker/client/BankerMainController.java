package com.dmma.dashboard.gwt.banker.client;

import java.util.HashMap;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.mvp.mail.MailTemplateSuggestion;
import com.dmma.base.gwt.client.mvp.mail.mailTemplate.MailTemplatePresenter;
import com.dmma.base.gwt.client.mvp.mail.mailTemplates.MailTemplatesPresenter;
import com.dmma.base.gwt.client.mvp.mail.mails.presenter.MailsPresenter;
import com.dmma.base.gwt.client.ui.menu.MenuEntry;
import com.dmma.base.gwt.client.ui_sample.MenuAndPresenterView;
import com.dmma.dashboard.gwt.banker.client.mvp.home.presenter.BankerHomePresenter;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.myTips.presenter.BankersTipsPresenter;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.presenter.BankersTipFormPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter.EditClientPresenter;
import com.google.gwt.user.client.ui.RootPanel;

public class BankerMainController extends MenuAndPresenterView{
	
	public BankerMainController(RootPanel rootPanel) {
		super(rootPanel, 50);
		createMenu();
		registerPresenters();
		fireCurrentHistoryState();
	}
	
	private void createMenu() {
		MenuEntry home = new MenuEntry(DashboardMessages.MSG.menuHome(), DashboardImages.IMG.home());
		home.addItem(DashboardMessages.MSG.menuBankerHome(), BankerHomePresenter.PRESENTER_ID);
		
		MenuEntry tips = new MenuEntry(DashboardMessages.MSG.menuTip(),  DashboardImages.IMG.editor());
		tips.addItem(DashboardMessages.MSG.menuMyTips(),  BankersTipsPresenter.PRESENTER_ID);
		tips.addItem(DashboardMessages.MSG.menuTipForm(), BankersTipFormPresenter.PRESENTER_ID);
		
		MenuEntry clients = new MenuEntry(DashboardMessages.MSG.menuClients(), DashboardImages.IMG.users());
		clients.addItem(DashboardMessages.MSG.menuAddClient(), EditClientPresenter.PRESENTER_ID);
		clients.addItem(BaseMessages.MSG.menuMails(), MailsPresenter.PRESENTER_ID);
		clients.addItem(BaseMessages.MSG.menuMailTemplates(), MailTemplatesPresenter.PRESENTER_ID);
		clients.addItem(BaseMessages.MSG.menuMailTemplates(), MailTemplatePresenter.PRESENTER_ID);
		
		this.addMenuEntry(home);
		this.addMenuEntry(tips);
		this.addMenuEntry(clients);
	}

	private void registerPresenters() {
		addPresenter(new BankerHomePresenter());
		addPresenter(new EditClientPresenter());
		addPresenter(new BankersTipsPresenter());
		addPresenter(new BankersTipFormPresenter());
		addPresenter(new MailsPresenter());
		addPresenter(new MailTemplatesPresenter());
		
		
		MailTemplateSuggestion mts1 = new MailTemplateSuggestion("BrokerWelcome", DashboardMessages.MSG.brokerWelcomeMailTemplate(), new String[]{"NAME","OFFICE"});
		MailTemplateSuggestion mts2 = new MailTemplateSuggestion("BankerWelcome", DashboardMessages.MSG.bankerWelcomeMailTemplate(), new String[]{"NAME","BANK"});
		HashMap<String, MailTemplateSuggestion> suggestions = new HashMap<String, MailTemplateSuggestion>();
		suggestions.put(mts1.getName(), mts1);
		suggestions.put(mts2.getName(), mts2);
		
		addPresenter(new MailTemplatePresenter(suggestions));

	}
}
