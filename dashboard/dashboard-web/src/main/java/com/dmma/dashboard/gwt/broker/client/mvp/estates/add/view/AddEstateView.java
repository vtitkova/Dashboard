package com.dmma.dashboard.gwt.broker.client.mvp.estates.add.view;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.add.presenter.AddEstatePresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.renderer.ViewingListRenderer;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AddEstateView extends BaseCompositeView implements AddEstatePresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuEstatesAdd();
	public static String VIEW_WIDTH = "800px";

	private TextBox midasIdTB;
	private Button  requestButton;
	private Button  confirmButton;
	
	private FlexTable deatilsTable;
	
	public AddEstateView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlowPanel layout = new FlowPanel();
			
		layout.add(createHeader());

		deatilsTable = new FlexTable();
		deatilsTable.setWidth("100%");
		layout.add(deatilsTable);
		//deatilsTable.setBorderWidth(1); //to test layout
		createDetailsHeader();
		createDetails();
		formatValueContent();
		return layout;
	}

	private void createDetailsHeader() {
		deatilsTable.setHTML(0, 0, DashboardMessages.MSG.estate());
		deatilsTable.getFlexCellFormatter().setColSpan(0, 0, 4);
		deatilsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
		deatilsTable.getColumnFormatter().setWidth(0, "150px");
		deatilsTable.getColumnFormatter().setWidth(1, "250px");
		deatilsTable.getColumnFormatter().setWidth(2, "130px");
		
	}
	
	private void createDetails() {
		confirmButton = new Button();
		confirmButton.setText(DashboardMessages.MSG.save());
		confirmButton.setEnabled(false);
			
		deatilsTable.setHTML(1,0, DashboardMessages.MSG.id());
		deatilsTable.setHTML(2,0, DashboardMessages.MSG.midasId());
		deatilsTable.setHTML(3,0, DashboardMessages.MSG.finnCode());
		deatilsTable.setHTML(4,0, DashboardMessages.MSG.orderNumber());
		deatilsTable.setHTML(5,0, DashboardMessages.MSG.status());
		deatilsTable.setWidget(6,0,confirmButton);
		deatilsTable.getFlexCellFormatter().setRowSpan(6, 0, 2);
		
		deatilsTable.setHTML(1,2, DashboardMessages.MSG.name());
		deatilsTable.setHTML(2,2, DashboardMessages.MSG.address());
		deatilsTable.setHTML(3,2, DashboardMessages.MSG.postCode());
		deatilsTable.setHTML(4,2, DashboardMessages.MSG.postCity());
		deatilsTable.setHTML(5,2, DashboardMessages.MSG.gnr());
		deatilsTable.setHTML(6,2, DashboardMessages.MSG.bnr());
		deatilsTable.setHTML(7,1, DashboardMessages.MSG.viewings());
		
	}

	private Widget createHeader() {
		FlexTable table  = new FlexTable();
		midasIdTB     = new TextBox();
		
		requestButton = new Button();
		requestButton.setText(DashboardMessages.MSG.lookup());
		table.setHTML(  0, 0, DashboardMessages.MSG.midasId());
		table.setHTML(  0, 1, "");
		table.setWidget(1, 0, midasIdTB);
		table.setWidget(1, 1, requestButton);
		table.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
		return table;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
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

	
	@Override
	public void setDataRequested() {
		setData(null);
		deatilsTable.setWidget(1,1, new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public HasClickHandlers getRequestButton() {
		return requestButton;
	}

	@Override
	public Long getMidasId() {
		try{
			return new Long(midasIdTB.getValue());
		}catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public void setData(EstateDTO data) {
		if(data!=null){
			deatilsTable.setHTML(1,1,""+data.getId());
			deatilsTable.setHTML(2,1,""+data.getMidasId());
			deatilsTable.setHTML(3,1,""+data.getFinnCode());
			deatilsTable.setHTML(4,1,""+data.getOrderNumber());
			deatilsTable.setHTML(5,1,""+data.getStatus());
			
			deatilsTable.setHTML(1,3,data.getTitle());
			deatilsTable.setHTML(2,3,data.getAddress());
			deatilsTable.setHTML(3,3,data.getPostCode());
			deatilsTable.setHTML(4,3,data.getPostCity());
			deatilsTable.setHTML(5,3,data.getGnr());
			deatilsTable.setHTML(6,3,data.getBnr());
			
			ViewingListRenderer renderer = new ViewingListRenderer();
			deatilsTable.setHTML(7,2, renderer.getValue(data.getEstateViewings()));
			confirmButton.setEnabled(true);
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
			confirmButton.setEnabled(false);
		}
	}

	@Override
	public HasClickHandlers getConfirmButton() {
		return confirmButton;
	}

	

}