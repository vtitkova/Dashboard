package com.dmma.dashboard.gwt.broker.client.mvp.home.view;

import gwt.dmma.base.client.utils.CssStyles;
import gwt.dmma.base.client.utils.WidgetUtil;

import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.dashboard.gwt.broker.client.mvp.home.presenter.BrokerHomePresenterDisplay;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.presenter.BrokersHtsFormPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.tip.tipform.presenter.BrokersTipFormPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.client.types.TipType;
import com.dmma.dashboard.gwt.core.client.utils.DashboardWidgetUtils;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.UnfinalyzedViewingDTOW;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class BrokerHomeView extends BaseCompositeView implements BrokerHomePresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuBrokerHome();
	public static String VIEW_WIDTH = "800px";
	
	private AppEvent editTipsEventTemplate;
	private AppEvent editHTSEventTemplate;
	
	private DisclosurePanel tipsDPanel; 
	private DisclosurePanel myHaveToSellDPanel; 
	private DisclosurePanel partnersHaveToSellDPanel; 
	private FlexTable tipsTable;
	private FlexTable myHaveToSellTable;
	private FlexTable partnersHaveToSellTable;
	
	private UnfinalyzedPart unfinalyzedPart;
	
	
	public BrokerHomeView() {
		super(VIEW_TITLE,"BookingPoView");
		editTipsEventTemplate = new AppEvent(BrokersTipFormPresenter.PRESENTER_ID, this.getClass().getName());
		editHTSEventTemplate = new AppEvent(BrokersHtsFormPresenter.PRESENTER_ID, this.getClass().getName());
	}

	@Override
	protected Widget createContent(){
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");
		layout.setWidget(0, 0, createTipsTodo());
		layout.setWidget(1, 0, createMyHaveToSell());
		layout.setWidget(2, 0, createPartnersHaveToSell());
		unfinalyzedPart = new UnfinalyzedPart();
		layout.setWidget(3, 0, unfinalyzedPart);
		return layout;
	}

	private Widget createMyHaveToSell() {
		myHaveToSellDPanel = new DisclosurePanel(DashboardMessages.MSG.iNeedToAskClients());
		myHaveToSellTable = new FlexTable();
		myHaveToSellDPanel.setContent(myHaveToSellTable);
		return myHaveToSellDPanel;
	}
	
	private Widget createPartnersHaveToSell() {
		partnersHaveToSellDPanel = new DisclosurePanel(DashboardMessages.MSG.partnersNeedToAskClients());
		partnersHaveToSellTable = new FlexTable();
		partnersHaveToSellDPanel.setContent(partnersHaveToSellTable);
		return partnersHaveToSellDPanel;
	}
	
	private Widget createTipsTodo() {
		tipsDPanel = new DisclosurePanel(DashboardMessages.MSG.homeShowTipsTodo());
		tipsTable = new FlexTable();
		tipsDPanel.setContent(tipsTable);
		return tipsDPanel;
	}
	
	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
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
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.banker());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.client());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.estate());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.tipType());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.comments());
		tipsTable.setHTML(0, col++, BaseMessages.MSG.created());
		tipsTable.setHTML(0, col++, DashboardMessages.MSG.status());
		tipsTable.setHTML(0, col++, "&nbsp;");
		tipsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}
	
	private void createMyHTSTableHeader() {
		int col = 0;
		myHaveToSellTable.setHTML(0, col++, DashboardMessages.MSG.id());
		myHaveToSellTable.setHTML(0, col++, DashboardMessages.MSG.client());
		myHaveToSellTable.setHTML(0, col++, BaseMessages.MSG.created());
		myHaveToSellTable.setHTML(0, col++, "R?");
		myHaveToSellTable.setHTML(0, col++, "&nbsp;");
		myHaveToSellTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}
	
	private void createPartnersHTSTableHeader() {
		int col = 0;
		partnersHaveToSellTable.setHTML(0, col++, DashboardMessages.MSG.id());
		partnersHaveToSellTable.setHTML(0, col++, DashboardMessages.MSG.client());
		partnersHaveToSellTable.setHTML(0, col++, BaseMessages.MSG.created());
		partnersHaveToSellTable.setHTML(0, col++, "R?");
		partnersHaveToSellTable.setHTML(0, col++, DashboardMessages.MSG.broker());
		partnersHaveToSellTable.setHTML(0, col++, "&nbsp;");
		partnersHaveToSellTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}
	
	private void createOneRow(TipDTO tip){
		int row = tipsTable.getRowCount();
		int col = 0;
		tipsTable.setHTML(row, col++, tip.getId().toString());
		
		tipsTable.setWidget(row, col++, DashboardWidgetUtils.createBankerWidget(tip.getBanker())); 
		tipsTable.setWidget(row, col++, DashboardWidgetUtils.createClientWidget(tip.getClient()));
		tipsTable.setWidget(row, col++, DashboardWidgetUtils.createEstateWidget(tip.getEstate()));
		
		
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
	
	private void createOneRowMyHTS(HaveToSellDTO hts){
		int row = myHaveToSellTable.getRowCount();
		int col = 0;
		myHaveToSellTable.setHTML(  row, col++, hts.getId().toString());
		myHaveToSellTable.setWidget(row, col++, DashboardWidgetUtils.createClientWidget(hts.getClient())); 
		myHaveToSellTable.setHTML(  row, col++, BaseFormats.getFormattedDate(hts.getActiveFrom()));
		if(hts.getParrentId()!=null ){
			myHaveToSellTable.setHTML(row, col++, "R");
		}else{
			myHaveToSellTable.setHTML(row, col++, "&nbsp");
		}
		
		AppEvent currentEvent = editHTSEventTemplate.clone();
		currentEvent.addParam(EKP.ID, hts.getId());
		ImageResource editIcon = DashboardImages.IMG.reply16();
		
		Widget w = WidgetUtil.createEditWidget(editIcon, currentEvent);
		myHaveToSellTable.setWidget(row, col++, w);
		
		if(row%2==0)
			myHaveToSellTable.getRowFormatter().setStyleName(row, CssStyles.TABLE_COLOR_ROW);
	}
	
	private void createOneRowPartnerHTS(HaveToSellDTO hts){
		int row = partnersHaveToSellTable.getRowCount();
		int col = 0;
		partnersHaveToSellTable.setHTML(  row, col++, hts.getId().toString());
		partnersHaveToSellTable.setWidget(row, col++, DashboardWidgetUtils.createClientWidget(hts.getClient()));  
		partnersHaveToSellTable.setHTML(  row, col++, BaseFormats.getFormattedDate(hts.getActiveFrom()));
		if(hts.getParrentId()!=null ){
			partnersHaveToSellTable.setHTML(row, col++, "R");
		}else{
			partnersHaveToSellTable.setHTML(row, col++, "&nbsp");
		}
		partnersHaveToSellTable.setWidget(row, col++,  DashboardWidgetUtils.createBrokerWidget(hts.getDefaultBroker()));
		
		AppEvent currentEvent = editHTSEventTemplate.clone();
		currentEvent.addParam(EKP.ID, hts.getId());
		ImageResource editIcon = DashboardImages.IMG.reply16();
		
		Widget w = WidgetUtil.createEditWidget(editIcon, currentEvent);
		partnersHaveToSellTable.setWidget(row, col++, w);
		
		if(row%2==0)
			partnersHaveToSellTable.getRowFormatter().setStyleName(row, CssStyles.TABLE_COLOR_ROW);
	}

	@Override
	public void setMyHTS(ArrayList<HaveToSellDTO> data) {
		myHaveToSellTable.removeAllRows();
		createMyHTSTableHeader();
		if(data==null||data.isEmpty()){
			BaseFlexTableUtil.addDataNotFound(myHaveToSellTable);
			return;
		}
		for(HaveToSellDTO hts : data){
			createOneRowMyHTS(hts);
		}
	}

	@Override
	public void setMyHTSRequested() {
		myHaveToSellTable.removeAllRows();
		createMyHTSTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingData(myHaveToSellTable);
	}

	@Override
	public void setPartnersHTS(ArrayList<HaveToSellDTO> data) {
		partnersHaveToSellTable.removeAllRows();
		createPartnersHTSTableHeader();
		if(data==null||data.isEmpty()){
			BaseFlexTableUtil.addDataNotFound(partnersHaveToSellTable);
			return;
		}
		for(HaveToSellDTO hts : data){
			createOneRowPartnerHTS(hts);
		}
	}

	@Override
	public void setPartnersHTSRequested() {
		partnersHaveToSellTable.removeAllRows();
		createPartnersHTSTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingData(partnersHaveToSellTable);
	}

	@Override
	public void setUnfinalyzedViewings(ArrayList<UnfinalyzedViewingDTOW> data) {
		unfinalyzedPart.setData(data);
	}

	@Override
	public void setUnfinalyzedViewingsRequested() {
		unfinalyzedPart.setDataRequested();
	}
	

}