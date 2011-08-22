package com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tips.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;
import gwt.dmma.base.client.utils.CssStyles;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.base.gwt.client.utils.BaseDateUtils;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tipform.presenter.TipFormPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tips.presenter.TipsPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.TipCM;
import com.dmma.dashboard.gwt.core.client.renderer.TipDirectionTypeRenderer;
import com.dmma.dashboard.gwt.core.client.renderer.TipStatusTypeRenderer;
import com.dmma.dashboard.gwt.core.client.renderer.TipTypeRenderer;
import com.dmma.dashboard.gwt.core.client.types.TipDirectionType;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.client.types.TipType;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class TipsView extends BaseCompositeView implements TipsPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuTips();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	private ListBox tipDirectionSearchTypeLB;
	private ListBox tipTypeSearchTypeLB;
	private ListBox tipStatusSearchTypeLB;
	
	private ListBox bankOfficeLB;
	private ListBox bankerLB;
	private ListBox brokerOfficeLB;
	private ListBox brokerLB;
	
	private DateBox dateFrom;
	private DateBox dateTo;
	
	private Button findButton;
	
	private GwtTable              table;
	private AbstractMetaGwtTableModel<TipDTO> tableModel;
	
	public TipsView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");
		layout.setWidget(0, 0, getHeaderWidget());
		layout.setWidget(1, 0, getLineTableRowWidget());
		return layout;
	}
	

	private Widget getHeaderWidget() {
		FlexTable widget = new FlexTable();
		
		widget.setHTML(0, 0, DashboardMessages.MSG.tipDirectionType());
		tipDirectionSearchTypeLB  = new ListBox();
		tipDirectionSearchTypeLB.addItem(DashboardMessages.MSG.all(), "-1");
		tipDirectionSearchTypeLB.addItem(TipDirectionType.isMtoB.getTitle(), TipDirectionType.isMtoB.getId().toString());
		tipDirectionSearchTypeLB.addItem(TipDirectionType.isBtoM.getTitle(), TipDirectionType.isBtoM.getId().toString());
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

		
		widget.setHTML(1, 0, DashboardMessages.MSG.bankOffice());
		bankOfficeLB  = new ListBox();
		bankOfficeLB.setWidth("260px");
		setBankOfficeDataNA();
		widget.setWidget(1, 1, bankOfficeLB);
		widget.getFlexCellFormatter().setColSpan(1, 1, 2);
		
		widget.setHTML(1, 2, DashboardMessages.MSG.banker());
		bankerLB  = new ListBox();
		bankerLB.setWidth("260px");
		setBankerDataNA();
		widget.setWidget(1, 3, bankerLB);
		widget.getFlexCellFormatter().setColSpan(1, 3, 2);
		
		
		
		widget.setHTML(2, 0, DashboardMessages.MSG.brokerOffice());
		brokerOfficeLB = new ListBox();
		brokerOfficeLB.setWidth("260px");
		setBrokerOfficeDataNA();
		widget.setWidget(2, 1, brokerOfficeLB);
		widget.getFlexCellFormatter().setColSpan(2, 1, 2);
		
		widget.setHTML(2, 2, DashboardMessages.MSG.broker());
		brokerLB  = new ListBox();
		brokerLB.setWidth("260px");
		setBrokerDataNA();
		widget.setWidget(2, 3, brokerLB);
		widget.getFlexCellFormatter().setColSpan(2,3, 2);
		
		
		widget.setHTML(3, 0, BaseMessages.MSG.from());
		dateFrom = new DateBox();
		dateFrom.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		widget.setWidget(3, 1, dateFrom);
		
		widget.setHTML(3, 2, BaseMessages.MSG.to());
		dateTo = new DateBox();
		dateTo.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		widget.setWidget(3, 3, dateTo);
		
		widget.setWidget(3, 4, createQuickLink(BaseMessages.MSG.thisMonth(), BaseDateUtils.getThisMonthFirstDay(), BaseDateUtils.getToday(false)));
		widget.setWidget(3, 5, createQuickLink(BaseMessages.MSG.lastMonth(), BaseDateUtils.getLastMonthFirstDay(), BaseDateUtils.getLastMonthLastDay()));
		
		
		findButton = new Button();
		findButton.setText(BaseMessages.MSG.find());
		widget.setWidget(4, 0, findButton);
		
		return widget;
	}

	private Widget getLineTableRowWidget() {
		TipDTO example = new TipDTO();
		IGwtEntityCM META = new TipCM();
		tableModel = new AbstractMetaGwtTableModel<TipDTO>(example, META);
		table = new GwtTable(tableModel, true, true, TipFormPresenter.PRESENTER_ID);
		
		table.addEnumRenderer(1, new TipDirectionTypeRenderer());
		table.addEnumRenderer(6, new TipTypeRenderer());
		table.addEnumRenderer(9, new TipStatusTypeRenderer());
			
		table.setEditImageResource(BaseImages.IMG.editSmall());

		table.setViewPortHeight(VIEW_PORT_HEIGHT);
		return table;
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
		tableModel.setObjects(data);
	}

	@Override
	public void setDataRequested() {
		tableModel.setRequesting();
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
		
		wrapper.setBankOfficeId(BaseListBoxUtils.getSelectedValueAsInteger(bankOfficeLB));
		wrapper.setBankerId(BaseListBoxUtils.getSelectedValueAsInteger(bankerLB));
		wrapper.setBrokerOfficeId(BaseListBoxUtils.getSelectedValueAsInteger(brokerOfficeLB));
		wrapper.setBrokerId(BaseListBoxUtils.getSelectedValueAsInteger(brokerLB));
		
		wrapper.setDateFrom(dateFrom.getValue());
		wrapper.setDateTo(dateTo.getValue());

		return wrapper;
	}

	/*@Override
	public void setTipSearchWrapper(MailSearchWrapper wrapper) {
		//TODO 
	}*/



	@Override
	public void setBankOfficeData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(bankOfficeLB, data);
	}

	@Override
	public void setBankOfficeDataNA() {
		BaseListBoxUtils.setItemsNAToLB(bankOfficeLB);
	}
	
	@Override
	public void setBankerDataNA() {
		BaseListBoxUtils.setItemsNAToLB(bankerLB);
	}
	@Override
	public void setBrokerDataNA() {
		BaseListBoxUtils.setItemsNAToLB(brokerLB);
	}
	
	@Override
	public HasChangeHandlers getBankOfficeChange() {
		return bankOfficeLB;
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
	public HasChangeHandlers getBrokerOfficeChange() {
		return brokerOfficeLB;
	}

	@Override
	protected String getPrefferedWidth() {
		return VIEW_WIDTH;
	}

	@Override
	public void setSelectedBankOfficeId(Integer bankOfficeId) {
		BaseListBoxUtils.setSelectedItemByValue(bankOfficeLB, ""+bankOfficeId);
	}

	@Override
	public Integer getSelectedBankOfficeId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(bankOfficeLB);
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
	public void setBankerData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(bankerLB, data);
	}

	@Override
	public void setSelectedBankerId(Integer bankerId) {
		BaseListBoxUtils.setSelectedItemByValue(bankerLB, ""+bankerId);
	}

	@Override
	public Integer getSelectedBankerId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(bankerLB);
	}

	@Override
	public void setBrokerData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(brokerLB, data);
	}

	@Override
	public void setSelectedBrokerId(Integer brokerId) {
		BaseListBoxUtils.setSelectedItemByValue(brokerLB, ""+brokerId);
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
	
}