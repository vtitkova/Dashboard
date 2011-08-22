package com.dmma.dashboard.gwt.banker.client.mvp.home.view;

import gwt.dmma.base.client.utils.CssStyles;
import gwt.dmma.base.client.utils.WidgetUtil;

import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.dashboard.gwt.banker.client.mvp.home.presenter.BankerHomePresenterDisplay;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.presenter.BankersTipFormPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.client.types.TipType;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class BankerHomeView extends Composite implements BankerHomePresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuBankerHome();
	
	private AppEvent editTipsEventTemplate;
	private DisclosurePanel tipsDPanel; 
	private FlexTable tipsTable;
	
	
	public BankerHomeView() {
		editTipsEventTemplate = new AppEvent(BankersTipFormPresenter.PRESENTER_ID, this.getClass().getName());
		
			FlexTable layout = new FlexTable();
			layout.setWidth("100%");
			layout.setWidget(0, 0, createTipsTodo());
			initWidget(layout);
	
	}

	
	@Override
	public String getCaption() {
		return VIEW_TITLE;
	}
	
	
	
	private Widget createTipsTodo() {
		tipsDPanel = new DisclosurePanel(DashboardMessages.MSG.homeShowTipsTodo());
		tipsTable = new FlexTable();
		tipsDPanel.setContent(tipsTable);
		return tipsDPanel;
	}

	
	@Override
	public void setTips(ArrayList<TipDTO> data) {
		tipsTable.removeAllRows();
		createTableHeader();
		if(data==null||data.isEmpty()){
			BaseFlexTableUtil.addDataNotFound(tipsTable);
			return;
		}
		for(TipDTO tip : data){
			createOneRow(tip);
		}		
	}

	@Override
	public void setTipsRequested() {
		tipsTable.removeAllRows();
		createTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingData(tipsTable);
	}
	
	private void createTableHeader() {
		int col = 0;
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.id());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.broker());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.client());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.estate());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.tipType());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.comments());
		tipsTable.setHTML(0, col++, BaseMessages.MSG.created());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.status());
		tipsTable.setHTML(0, col++, "&nbsp;");
		tipsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}
	
	private void createOneRow(TipDTO tip){
		int row = tipsTable.getRowCount();
		int col = 0;
		tipsTable.setHTML(row, col++, tip.getId().toString());
		
		tipsTable.setHTML(row, col++, ""+tip.getBroker());   //TODO razdeli na widget
		tipsTable.setHTML(row, col++, ""+tip.getClient());   //TODO razdli na widget
		tipsTable.setHTML(row, col++, ""+tip.getEstate());   //TODO razdli na widget
		
		
		tipsTable.setHTML(row, col++, TipType.getTitleById(tip.getTipType()));
		tipsTable.setHTML(row, col++, tip.getComments());
		tipsTable.setHTML(row, col++, BaseFormats.getFormattedDate(tip.getCreated()));
		tipsTable.setHTML(row, col++, TipStatusType.getTitleById(tip.getTipStatusType()));
		
		
		AppEvent currentEvent = editTipsEventTemplate.clone();
		currentEvent.addParam(EKP.ID, tip.getId());
		ImageResource editIcon = DashboardImages.IMG.reply16();
		
		Widget w = WidgetUtil.createEditWidget(editIcon, currentEvent);
		tipsTable.setWidget(row, col++, w);
		
		if(row%2==0)
			tipsTable.getRowFormatter().setStyleName(row, CssStyles.TABLE_COLOR_ROW);
	}

	
	

}