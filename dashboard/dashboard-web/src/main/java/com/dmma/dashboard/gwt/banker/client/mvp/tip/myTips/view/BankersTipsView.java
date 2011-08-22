package com.dmma.dashboard.gwt.banker.client.mvp.tip.myTips.view;

import gwt.dmma.base.client.utils.CssStyles;
import gwt.dmma.base.client.utils.WidgetUtil;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.utils.BaseDateUtils;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.myTips.presenter.BankersTipsPresenterDisplay;
import com.dmma.dashboard.gwt.banker.client.mvp.tip.tipform.presenter.BankersTipFormPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.types.TipDirectionType;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.client.types.TipType;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class BankersTipsView extends Composite implements BankersTipsPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuMyTips();

	private ListBox tipDirectionSearchTypeLB;
	private ListBox tipTypeSearchTypeLB;
	private ListBox tipStatusSearchTypeLB;
	
	private ListBox brokerOfficeLB;
	private ListBox brokerLB;
	
	private DateBox dateFrom;
	private DateBox dateTo;
	
	private Button findButton;
	
	private FlexTable table;
	private AppEvent editEventTemplate;
	
	public BankersTipsView() {
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");
		layout.setWidget(0, 0, getHeaderWidget());
		layout.setWidget(1, 0, getLineTableRowWidget());
		initWidget(layout);
		editEventTemplate = new AppEvent(BankersTipFormPresenter.PRESENTER_ID, this.getClass().getName());
	}


	private Widget getHeaderWidget() {
		FlexTable widget = new FlexTable();
		
		widget.setHTML(0, 0, DashboardMessages.MSG.tipDirectionType());
		tipDirectionSearchTypeLB  = new ListBox();
		tipDirectionSearchTypeLB.addItem(DashboardMessages.MSG.all(), "-1");
		tipDirectionSearchTypeLB.addItem(DashboardMessages.MSG.tipsFromMe(), TipDirectionType.isBtoM.getId().toString());
		tipDirectionSearchTypeLB.addItem(DashboardMessages.MSG.tipsToMe(), TipDirectionType.isMtoB.getId().toString());
		widget.setWidget(0, 1, tipDirectionSearchTypeLB);

		
		widget.setHTML(0, 2, DashboardMessages.MSG.tipType());
		tipTypeSearchTypeLB  = new ListBox();
		tipTypeSearchTypeLB.addItem(DashboardMessages.MSG.all(), "-1");
		tipTypeSearchTypeLB.addItem(TipType.isLoan.getTitle(), TipType.isLoan.getId().toString());
		tipTypeSearchTypeLB.addItem(TipType.isSell.getTitle(), TipType.isSell.getId().toString());
		tipTypeSearchTypeLB.addItem(TipType.isInventory.getTitle(), TipType.isInventory.getId().toString());
		widget.setWidget(0, 3, tipTypeSearchTypeLB);

		widget.setHTML(0, 4, DashboardMessages.MSG.tipStatus());
		tipStatusSearchTypeLB  = new ListBox();
		tipStatusSearchTypeLB.addItem(DashboardMessages.MSG.all(), "-1");
		tipStatusSearchTypeLB.addItem(TipStatusType.isNew.getTitle(),       TipStatusType.isNew.getId().toString());
		tipStatusSearchTypeLB.addItem(TipStatusType.isInProcess.getTitle(), TipStatusType.isInProcess.getId().toString());
		tipStatusSearchTypeLB.addItem(TipStatusType.isSucceed.getTitle(),   TipStatusType.isSucceed.getId().toString());
		tipStatusSearchTypeLB.addItem(TipStatusType.isRejected.getTitle(),  TipStatusType.isRejected.getId().toString());
		widget.setWidget(0, 5, tipStatusSearchTypeLB);

		
		widget.setHTML(1, 0, DashboardMessages.MSG.brokerOffice());
		brokerOfficeLB  = new ListBox();
		brokerOfficeLB.setWidth("260px");
		setBrokerOfficeDataNA();
		widget.setWidget(1, 1, brokerOfficeLB);
		widget.getFlexCellFormatter().setColSpan(1, 1, 2);
		
		widget.setHTML(1, 2, DashboardMessages.MSG.broker());
		brokerLB  = new ListBox();
		brokerLB.setWidth("260px");
		setBrokerDataNA();
		widget.setWidget(1, 3, brokerLB);
		widget.getFlexCellFormatter().setColSpan(1, 3, 2);
		
		
		widget.setHTML(2, 0, BaseMessages.MSG.from());
		dateFrom = new DateBox();
		dateFrom.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		widget.setWidget(2, 1, dateFrom);
		
		widget.setHTML(2, 2, BaseMessages.MSG.to());
		dateTo = new DateBox();
		dateTo.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		widget.setWidget(2, 3, dateTo);
		
		widget.setWidget(2, 4, createQuickLink(BaseMessages.MSG.thisMonth(), BaseDateUtils.getThisMonthFirstDay(), BaseDateUtils.getToday(false)));
		widget.setWidget(2, 5, createQuickLink(BaseMessages.MSG.lastMonth(), BaseDateUtils.getLastMonthFirstDay(), BaseDateUtils.getLastMonthLastDay()));
		
		
		findButton = new Button();
		findButton.setText(BaseMessages.MSG.find());
		widget.setWidget(3, 0, findButton);
		
		return widget;
	}

	private Widget getLineTableRowWidget() {
		table = new FlexTable();
		table.setWidth("100%");
		createTableHeader();
		BaseFlexTableUtil.addDataNotFound(table);
		return table;
	}
	
	private void createTableHeader() {
		int col = 0;
		table.setHTML(0, col++, DashboardMessages.MSG.id());
		table.setWidget(0, col++, new Image(DashboardImages.IMG.arrowsLeftRight22())); 
		table.setHTML(0, col++, DashboardMessages.MSG.broker());
		table.setHTML(0, col++, DashboardMessages.MSG.client());
		table.setHTML(0, col++, DashboardMessages.MSG.estate());
		table.setHTML(0, col++, DashboardMessages.MSG.tipType());
		table.setHTML(0, col++, DashboardMessages.MSG.comments());
		table.setHTML(0, col++, BaseMessages.MSG.created());
		table.setHTML(0, col++, DashboardMessages.MSG.status());
		table.setHTML(0, col++, DashboardMessages.MSG.modificationComments());
		table.setHTML(0, col++, DashboardMessages.MSG.modificationDate());
		table.setHTML(0, col++, "&nbsp;");
		
		
		table.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}

	private Label createQuickLink(String string, Date date, Date date2) {
		Label l = new Label();
		l.setText(string);
		l.setStyleName(CssStyles.NAVIGATION_LINK);
		l.addClickHandler(new QuickClick(date, date2));
		return l;
	}
	
	private class QuickClick implements ClickHandler{
		private Date date;
		private Date date2;
		public QuickClick(Date date, Date date2) {
			this.date = date;
			this.date2 = date2;
		}

		@Override
		public void onClick(ClickEvent e) {
			doQuickLink(date, date2);
		}
	}
	
	private void doQuickLink(Date date, Date date2) {
		dateFrom.setValue(date);
		dateTo.setValue(date2);
	}
	
	
	@Override
	public void setData(ArrayList<TipDTO> data) {
		table.removeAllRows();
		createTableHeader();
		if(data==null||data.isEmpty()){
			BaseFlexTableUtil.addDataNotFound(table);
			return;
		}
		for(TipDTO tip : data){
			createOneRow(tip);
		}
	}

	private void createOneRow(TipDTO tip){
		int row = table.getRowCount();
		int col = 0;
		table.setHTML(row, col++, tip.getId().toString());
		
		if(TipDirectionType.isBtoM.getId().equals(tip.getTipDirectionType()))
			table.setWidget(row, col++, new Image(DashboardImages.IMG.arrowRightGrey22())); // I send to Megler 
		else
			table.setWidget(row, col++, new Image(DashboardImages.IMG.arrowLeftGreen22())); // Megler sent to me
		
		table.setHTML(row, col++, ""+tip.getBroker());   //TODO razdeli na widget
		table.setHTML(row, col++, ""+tip.getClient());   //TODO razdli na widget
		table.setHTML(row, col++, ""+tip.getEstate());   //TODO razdli na widget
		
		
		table.setHTML(row, col++, TipType.getTitleById(tip.getTipType()));
		table.setHTML(row, col++, tip.getComments());
		table.setHTML(row, col++, BaseFormats.getFormattedDate(tip.getCreated()));
		table.setHTML(row, col++, TipStatusType.getTitleById(tip.getTipStatusType()));
		table.setHTML(row, col++, tip.getStatusComments());
		table.setHTML(row, col++, BaseFormats.getFormattedDate(tip.getModified()));
		
		AppEvent currentEvent = editEventTemplate.clone();
		currentEvent.addParam(EKP.ID, tip.getId());
		ImageResource editIcon = BaseImages.IMG.editSmall();
		
		//depends on logic see XLS file for description  
		if(TipDirectionType.isBtoM.getId().equals(tip.getTipDirectionType())){
			// I send to Megler 
			if(!TipStatusType.isNew.getId().equals(tip.getTipStatusType())){
				editIcon = BaseImages.IMG.infoSmall();
			}
		}else{
			// Megler sent to me
			if(TipStatusType.isNew.getId().equals(tip.getTipStatusType()) 
				|| TipStatusType.isInProcess.getId().equals(tip.getTipStatusType())){
				editIcon = DashboardImages.IMG.reply16();
			}
		}
		
		Widget w = WidgetUtil.createEditWidget(editIcon, currentEvent);
		table.setWidget(row, col++, w);
		
		if(row%2==0)
			table.getRowFormatter().setStyleName(row, CssStyles.TABLE_COLOR_ROW);
	}
	
	@Override
	public void setDataRequested() {
		table.removeAllRows();
		createTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingData(table);
	}

	@Override
	public HasClickHandlers getFindButton() {
		return findButton;
	}

	@Override
	public TipSearchWrapper getTipSearchWrapper() {
		TipSearchWrapper wrapper = new TipSearchWrapper();
		wrapper.setTipDirectionSearchTypeId(BaseListBoxUtils.getSelectedValueAsInteger(tipDirectionSearchTypeLB));
		wrapper.setTipTypeSearchTypeId(BaseListBoxUtils.getSelectedValueAsInteger(tipTypeSearchTypeLB));
		wrapper.setTipStatusSearchTypeId(BaseListBoxUtils.getSelectedValueAsInteger(tipStatusSearchTypeLB));
		
		wrapper.setBrokerOfficeId(BaseListBoxUtils.getSelectedValueAsInteger(brokerOfficeLB));
		wrapper.setBrokerId(BaseListBoxUtils.getSelectedValueAsInteger(brokerLB));
		
		wrapper.setDateFrom(dateFrom.getValue());
		wrapper.setDateTo(dateTo.getValue());

		return wrapper;
	}

	@Override
	public void setBrokerOfficeData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(brokerOfficeLB, data);
	}

	@Override
	public void setBrokerOfficeDataNA() {
		BaseListBoxUtils.setItemsNAToLB(brokerOfficeLB);
	}
	
	@Override
	public void setBrokerDataNA() {
		BaseListBoxUtils.setItemsNAToLB(brokerLB);
	}
	
	@Override
	public HasChangeHandlers getBrokerOfficeChange() {
		return brokerOfficeLB;
	}

	
	@Override
	public void setSelectedBrokerOfficeId(Integer brokerOfficeId) {
		BaseListBoxUtils.setSelectedItemByValue(brokerOfficeLB, ""+brokerOfficeId);
	}

	@Override
	public Integer getSelectedBrokerOfficeId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(brokerOfficeLB);
	}

	
	
	@Override
	public void setBrokerData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(brokerLB, data);
	}

	@Override
	public void setSelectedBrokerId(Integer bankerId) {
		BaseListBoxUtils.setSelectedItemByValue(brokerLB, ""+bankerId);
	}

	@Override
	public Integer getSelectedBrokerId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(brokerLB);
	}

	
	@Override
	public void setTipDirectionSearchTypeId(Integer paramAsInteger) {
		BaseListBoxUtils.setSelectedItemByValue(tipDirectionSearchTypeLB, ""+paramAsInteger);
	}

	@Override
	public void setTipTypeSearchTypeId(Integer paramAsInteger) {
		BaseListBoxUtils.setSelectedItemByValue(tipTypeSearchTypeLB, ""+paramAsInteger);
	}

	@Override
	public void setTipStatusSearchTypeId(Integer paramAsInteger) {
		BaseListBoxUtils.setSelectedItemByValue(tipStatusSearchTypeLB, ""+paramAsInteger);
	}

	@Override
	public void setDateFrom(Date paramAsDate) {
		dateFrom.setValue(paramAsDate);
	}

	@Override
	public void setDateTo(Date paramAsDate) {
		dateTo.setValue(paramAsDate);
	}


	@Override
	public String getCaption() {
		return VIEW_TITLE;
	}
	
}