package com.dmma.dashboard.gwt.broker.client.mvp.estates.details.view;

import gwt.dmma.base.client.utils.CssStyles;

import java.util.ArrayList;

import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.details.presenter.EstateDetailsPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.renderer.ViewingListRenderer;
import com.dmma.dashboard.gwt.core.client.types.EstateStatusType;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ViewingAndVisitsDTOW;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class EstateDetailsView extends BaseCompositeView implements EstateDetailsPresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuEstateDetails();
	public static String VIEW_WIDTH = "800px";

	private Image  synhronizeButton;
	private FlexTable deatilsTable;
	private FlexTable futureViewingsTable;
	private FlexTable pastViewingsTable;
	
	private Integer estateId;
	public EstateDetailsView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlowPanel layout = new FlowPanel();
		layout.setWidth("100%");
		layout.add(createDetails());
		formatValueContent();
		layout.add(createFutureViewings());
		layout.add(createPastViewings());
		
		return layout;
	}

	private Widget createDetails() {
		deatilsTable = new FlexTable();
		deatilsTable.setWidth("100%");
		
		deatilsTable.setHTML(0, 0, DashboardMessages.MSG.estate());
		deatilsTable.getFlexCellFormatter().setColSpan(0, 0, 4);
		deatilsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
		deatilsTable.getColumnFormatter().setWidth(0, "150px");
		deatilsTable.getColumnFormatter().setWidth(1, "250px");
		deatilsTable.getColumnFormatter().setWidth(2, "130px");
		
		
		synhronizeButton = new Image(DashboardImages.IMG.synchronize22());
		synhronizeButton.setTitle(DashboardMessages.MSG.synchronize());
		synhronizeButton.setVisible(false);
			
		deatilsTable.setHTML(1,0, DashboardMessages.MSG.id());
		deatilsTable.setHTML(2,0, DashboardMessages.MSG.midasId());
		deatilsTable.setHTML(3,0, DashboardMessages.MSG.finnCode());
		deatilsTable.setHTML(4,0, DashboardMessages.MSG.orderNumber());
		deatilsTable.setHTML(5,0, DashboardMessages.MSG.status());
		deatilsTable.setWidget(6,0,synhronizeButton);
		deatilsTable.getFlexCellFormatter().setRowSpan(6, 0, 2);
		
		deatilsTable.setHTML(1,2, DashboardMessages.MSG.name());
		deatilsTable.setHTML(2,2, DashboardMessages.MSG.address());
		deatilsTable.setHTML(3,2, DashboardMessages.MSG.postCode());
		deatilsTable.setHTML(4,2, DashboardMessages.MSG.postCity());
		deatilsTable.setHTML(5,2, DashboardMessages.MSG.gnr());
		deatilsTable.setHTML(6,2, DashboardMessages.MSG.bnr());
		deatilsTable.setHTML(7,1, DashboardMessages.MSG.viewings());
		
		
		
		return deatilsTable;
	}
	
	private void formatValueContent(){
		deatilsTable.getFlexCellFormatter().setStyleName(1,1, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(2,1, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(3,1, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(4,1, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(5,1, CssStyles.DATA_DATA);
		
		deatilsTable.getFlexCellFormatter().setStyleName(1,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(2,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(3,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(4,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(5,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(6,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(7,2, CssStyles.DATA_DATA);
	}

	private Widget createFutureViewings() {
		futureViewingsTable = new FlexTable();
		futureViewingsTable.setWidth("100%");
		return futureViewingsTable;
	}

	private void createFutureViewingsTableHeader(){
		futureViewingsTable.setHTML(0, 0, DashboardMessages.MSG.futureViewings());
		futureViewingsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}
	
	private Widget createPastViewings() {
		pastViewingsTable = new FlexTable();
		pastViewingsTable.setWidth("100%");
		return pastViewingsTable;
	}
	private void createPastViewingsTableHeader(){
		pastViewingsTable.setHTML(0, 0, DashboardMessages.MSG.pastViewings());
		pastViewingsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}
	
	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}

	@Override
	public void setData(EstateDTO data) {
		if(data!=null){
			estateId = data.getId();
			deatilsTable.setHTML(1,1,""+data.getId());
			deatilsTable.setHTML(2,1,""+data.getMidasId());
			deatilsTable.setHTML(3,1,""+data.getFinnCode());
			deatilsTable.setHTML(4,1,""+data.getOrderNumber());
			deatilsTable.setHTML(5,1, EstateStatusType.getTitleById(data.getStatus()));
			
			deatilsTable.setHTML(1,3,data.getTitle());
			deatilsTable.setHTML(2,3,data.getAddress());
			deatilsTable.setHTML(3,3,data.getPostCode());
			deatilsTable.setHTML(4,3,data.getPostCity());
			deatilsTable.setHTML(5,3,data.getGnr());
			deatilsTable.setHTML(6,3,data.getBnr());
			
			ViewingListRenderer renderer = new ViewingListRenderer();
			deatilsTable.setHTML(7,2, renderer.getValue(data.getEstateViewings()));
			synhronizeButton.setVisible(true);
		}else{
			deatilsTable.setHTML(1,1,"");
			deatilsTable.setHTML(2,1,"");
			deatilsTable.setHTML(3,1,"");
			deatilsTable.setHTML(4,1,"");
			deatilsTable.setHTML(5,1,"");
			
			deatilsTable.setHTML(1,3,"");
			deatilsTable.setHTML(2,3,"");
			deatilsTable.setHTML(3,3,"");
			deatilsTable.setHTML(4,3,"");
			deatilsTable.setHTML(5,3,"");
			deatilsTable.setHTML(6,3,"");
			deatilsTable.setHTML(7,2,"");
			synhronizeButton.setVisible(false);
		}
	}
	
	@Override
	public void setDataRequested() {
		setData(null);
		deatilsTable.setWidget(1,1, new Image(BaseImages.IMG.loadingSmall()));
		
	}

	@Override
	public HasClickHandlers getSynhronizeButton() {
		return synhronizeButton;
	}

	@Override
	public void setDataSynhronizationRequested() {
		deatilsTable.setWidget(1,1, new Image(BaseImages.IMG.loadingSmall()));
		synhronizeButton.setVisible(false);
	}

	@Override
	public void setDataAfterSynhronization(EstateDTO data) {
		setData(data);
	}

	@Override
	public void setFutureViewingAndVisitsDataRequested() {
		futureViewingsTable.removeAllRows();
		createFutureViewingsTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingDataSmall(futureViewingsTable);
	}

	@Override
	public void setFutureViewingAndVisits(ArrayList<ViewingAndVisitsDTOW> futureViewingAndVisits) {
		futureViewingsTable.removeAllRows();
		if(futureViewingAndVisits!=null && !futureViewingAndVisits.isEmpty()){
			createFutureViewingsTableHeader();
			for(ViewingAndVisitsDTOW future: futureViewingAndVisits){
				int row = futureViewingsTable.getRowCount();
				FuturePartView f = new FuturePartView(future.getEstateViewing(), estateId);
				f.setClientVisits(future.getClientVisits());
				futureViewingsTable.setWidget(row, 0,  f );
			}
		}
	}

	
	@Override
	public void setPastViewingAndVisitsDataRequested() {
		pastViewingsTable.removeAllRows();
		createPastViewingsTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingDataSmall(pastViewingsTable);
	}

	@Override
	public void setPastViewingAndVisits(ArrayList<ViewingAndVisitsDTOW> pastViewingAndVisits) {
		pastViewingsTable.removeAllRows();
		if(pastViewingAndVisits!=null && !pastViewingAndVisits.isEmpty()){
			createPastViewingsTableHeader();
			for(ViewingAndVisitsDTOW past: pastViewingAndVisits){
				int row = pastViewingsTable.getRowCount();
				PastPartView p = new PastPartView(past.getEstateViewing(), estateId);
				p.setClientVisits(past.getClientVisits());
				pastViewingsTable.setWidget(row, 0,  p );
			}
		}
	}
	
}