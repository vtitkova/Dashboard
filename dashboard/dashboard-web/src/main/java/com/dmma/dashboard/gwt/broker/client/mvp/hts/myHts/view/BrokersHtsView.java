package com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.view;

import gwt.dmma.base.client.utils.CssStyles;
import gwt.dmma.base.client.utils.WidgetUtil;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.utils.BaseDateUtils;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.presenter.BrokersHtsFormPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.presenter.BrokersHtsPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.utils.DashboardWidgetUtils;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.HtsSearchWrapper;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class BrokersHtsView extends BaseCompositeView implements BrokersHtsPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuMyHts();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	private ListBox htsStatusSearchTypeLB;
	private ListBox wantsToSellSearchTypeLB;
	
	private DateBox dateFrom;
	private DateBox dateTo;
	
	private Button findButton;
	
	private FlexTable table;
	private AppEvent editEventTemplate;
	
	public BrokersHtsView() {
		super(VIEW_TITLE,"BookingPoView");
		editEventTemplate = new AppEvent(BrokersHtsFormPresenter.PRESENTER_ID, this.getClass().getName());
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
		
		widget.setHTML(0, 0, DashboardMessages.MSG.status());
		htsStatusSearchTypeLB = new ListBox();
		htsStatusSearchTypeLB.addItem(DashboardMessages.MSG.all(), "-1");
		htsStatusSearchTypeLB.addItem(DashboardMessages.MSG.processed(), "1");
		htsStatusSearchTypeLB.addItem(DashboardMessages.MSG.toBeDone(), "2");
		widget.setWidget(0, 1, htsStatusSearchTypeLB);

		
		widget.setHTML(0, 2, DashboardMessages.MSG.wantToSell());
		wantsToSellSearchTypeLB  = new ListBox();
		wantsToSellSearchTypeLB.addItem(DashboardMessages.MSG.all(), "-1");
		wantsToSellSearchTypeLB.addItem(BaseMessages.MSG.yes(), "1");
		wantsToSellSearchTypeLB.addItem(BaseMessages.MSG.no(), "2");
		widget.setWidget(0, 3, wantsToSellSearchTypeLB);

				
		
		widget.setHTML(1, 0, BaseMessages.MSG.from());
		dateFrom = new DateBox();
		dateFrom.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		widget.setWidget(1, 1, dateFrom);
		
		widget.setHTML(1, 2, BaseMessages.MSG.to());
		dateTo = new DateBox();
		dateTo.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		widget.setWidget(1, 3, dateTo);
		
		widget.setWidget(1, 4, createQuickLink(BaseMessages.MSG.thisMonth(), BaseDateUtils.getThisMonthFirstDay(), BaseDateUtils.getToday(false)));
		widget.setWidget(1, 5, createQuickLink(BaseMessages.MSG.lastMonth(), BaseDateUtils.getLastMonthFirstDay(), BaseDateUtils.getLastMonthLastDay()));
		
		
		findButton = new Button();
		findButton.setText(BaseMessages.MSG.find());
		widget.setWidget(2, 0, findButton);
		
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
		table.setHTML(0, col++, BaseMessages.MSG.id());
		table.setHTML(0, col++, DashboardMessages.MSG.client());
		table.setHTML(0, col++, DashboardMessages.MSG.wantToSellShort());
		table.setHTML(0, col++, BaseMessages.MSG.created());
		table.setHTML(0, col++, DashboardMessages.MSG.processed());
		table.setHTML(0, col++, DashboardMessages.MSG.comments());
		table.setHTML(0, col++, "R?");

		/*table.setWidget(0, col++,  new Image(RES.arrowsLeftRight22()));
		table.setHTML(0, col++, DashboardTRL.msg.estate());
		table.setHTML(0, col++, DashboardTRL.msg.banker());
		table.setHTML(0, col++, DashboardTRL.msg.tipType());
		table.setHTML(0, col++, DashboardTRL.msg.modificationComments());
		table.setHTML(0, col++, DashboardTRL.msg.modificationDate());*/
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
	public void setData(ArrayList<HaveToSellDTO> data) {
		table.removeAllRows();
		createTableHeader();
		if(data==null||data.isEmpty()){
			BaseFlexTableUtil.addDataNotFound(table);
			return;
		}
		for(HaveToSellDTO tip : data){
			createOneRow(tip);
		}
	}

	private void createOneRow(HaveToSellDTO hts){
		int row = table.getRowCount();
		int col = 0;
		table.setHTML(row, col++, hts.getId().toString());
		table.setWidget(row, col++, DashboardWidgetUtils.createClientWidget(hts.getClient()));
		if(hts.getProcessedDate() == null ){
			table.setWidget(row, col++, new Image(DashboardImages.IMG.notKnown16()));
		}else if(hts.getWantsToSell()){
			table.setWidget(row, col++, new Image(DashboardImages.IMG.true16()));
		}else{
			table.setWidget(row, col++, new Image(BaseImages.IMG.cancelSmall()));
		}
		table.setHTML(row, col++, BaseFormats.getFormattedDate(hts.getActiveFrom()));
		table.setHTML(row, col++, BaseFormats.getFormattedDate(hts.getProcessedDate()));
		table.setHTML(row, col++, hts.getProcessedComments());
			
		if(hts.getParrentId()!=null ){
			table.setHTML(row, col++, "R");
		}else{
			table.setHTML(row, col++, "&nbsp");
		}
		
		AppEvent currentEvent = editEventTemplate.clone();
		currentEvent.addParam(EKP.ID, hts.getId());
		ImageResource editIcon = BaseImages.IMG.editSmall();
		
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
	public HtsSearchWrapper getHtsSearchWrapper() {
		HtsSearchWrapper wrapper = new HtsSearchWrapper();
		wrapper.setHtcStatusSearchTypeId(BaseListBoxUtils.getSelectedValueAsInteger(htsStatusSearchTypeLB));
		wrapper.setWantsToSellSearchTypeId(BaseListBoxUtils.getSelectedValueAsInteger(wantsToSellSearchTypeLB));
		
		wrapper.setDateFrom(dateFrom.getValue());
		wrapper.setDateTo(dateTo.getValue());

		return wrapper;
	}

	@Override
	protected String getPrefferedWidth() {
		return VIEW_WIDTH;
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
	public void setWantsToSellSearchTypeId(Integer paramAsInteger) {
		BaseListBoxUtils.setSelectedItemByValue(wantsToSellSearchTypeLB, ""+paramAsInteger);
	}

	@Override
	public void setHtcStatusSearchTypeId(Integer paramAsInteger) {
		BaseListBoxUtils.setSelectedItemByValue(htsStatusSearchTypeLB, ""+paramAsInteger);
		
	}
	
}