package com.dmma.dashboard.gwt.broker.client.mvp.home.view;

import gwt.dmma.base.client.utils.CssStyles;
import gwt.dmma.base.client.utils.WidgetUtil;

import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.presenter.ClientVisitPlannerPresenter;
import com.dmma.dashboard.gwt.core.client.utils.DashboardWidgetUtils;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.UnfinalyzedViewingDTOW;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class UnfinalyzedPart extends Composite{
	private DisclosurePanel unfinalyzedDPanel; 
	private FlexTable unfinalyzedTable;
	private AppEvent editEventTemplate;

	public UnfinalyzedPart() {
		editEventTemplate = new AppEvent(ClientVisitPlannerPresenter.PRESENTER_ID, this.getClass().getName());
		
		unfinalyzedDPanel = new DisclosurePanel(DashboardMessages.MSG.unfinalyzedViewings());
		unfinalyzedTable = new FlexTable();
		unfinalyzedDPanel.setContent(unfinalyzedTable);
		initWidget(unfinalyzedDPanel);
	}

	public void setDataRequested() {
		unfinalyzedTable.removeAllRows();
		createTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingData(unfinalyzedTable);
	}

	private void createTableHeader() {
		int col = 0;
		unfinalyzedTable.setHTML(0, col++, DashboardMessages.MSG.id());
		unfinalyzedTable.setHTML(0, col++, DashboardMessages.MSG.estate());
		unfinalyzedTable.setHTML(0, col++, DashboardMessages.MSG.viewing());
		unfinalyzedTable.setHTML(0, col++, DashboardMessages.MSG.unfinalyzed());
		unfinalyzedTable.setHTML(0, col++, "&nbsp;");
		unfinalyzedTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}

	public void setData(ArrayList<UnfinalyzedViewingDTOW> dataList) {
		unfinalyzedTable.removeAllRows();
		createTableHeader();
		if(dataList==null||dataList.isEmpty()){
			BaseFlexTableUtil.addDataNotFound(unfinalyzedTable);
			return;
		}
		for(UnfinalyzedViewingDTOW data : dataList){
			createOneRow(data);
		}
	}

	private void createOneRow(UnfinalyzedViewingDTOW data) {
		int row = unfinalyzedTable.getRowCount();
		int col = 0;
		unfinalyzedTable.setHTML(row, col++, data.getEstateViewing().getId().toString());
		
		unfinalyzedTable.setWidget(row, col++, DashboardWidgetUtils.createEstateWidget(data.getEstate())); 
	
		String viewing = BaseFormats.getFormattedInterval(data.getEstateViewing().getDateFrom(), data.getEstateViewing().getDateTo());
		unfinalyzedTable.setHTML(row, col++, viewing);
		
		unfinalyzedTable.setHTML(row, col++, data.getUnknownStatusAmount().toString());
		
		AppEvent currentEvent = editEventTemplate.clone();
		currentEvent.addParam(EKP.ID, data.getEstateViewing().getId());
		ImageResource editIcon = DashboardImages.IMG.reply16();
		
		Widget w = WidgetUtil.createEditWidget(editIcon, currentEvent);
		unfinalyzedTable.setWidget(row, col++, w);
		
		if(row%2==0)
			unfinalyzedTable.getRowFormatter().setStyleName(row, CssStyles.TABLE_COLOR_ROW);
	}


}
