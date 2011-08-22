package com.dmma.dashboard.gwt.broker.client.mvp.setups.myinfo.view;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.changepassword.ChangePasswordListener;
import com.dmma.base.gwt.client.ui.changepassword.ChangePasswordView;
import com.dmma.dashboard.gwt.broker.client.mvp.setups.myinfo.presenter.MyInfoPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class MyInfoView extends BaseCompositeView implements MyInfoPresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuSetupsMyProfile();
	public static String VIEW_WIDTH = "800px";

	private FlexTable deatilsTable;
	private ChangePasswordView changePasswordWidget;
	
	public MyInfoView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlowPanel layout = new FlowPanel();
			
		deatilsTable = new FlexTable();
		deatilsTable.setWidth("100%");
		changePasswordWidget = new ChangePasswordView();
		layout.add(deatilsTable);
		layout.add(changePasswordWidget);
		
		
		createHeader();
		createTitles();
		formatValueContent();
		
		return layout;
	}

	private void createTitles() {
		deatilsTable.setHTML(1,0, DashboardMessages.MSG.id());
		deatilsTable.setHTML(2,0, DashboardMessages.MSG.midasId());
		deatilsTable.setHTML(3,0, DashboardMessages.MSG.name());
		deatilsTable.setHTML(4,0, DashboardMessages.MSG.surname());
		deatilsTable.setHTML(5,0, DashboardMessages.MSG.email());
		deatilsTable.setHTML(6,0, DashboardMessages.MSG.phone());
		deatilsTable.setHTML(7,0, DashboardMessages.MSG.cellphone());
		
		deatilsTable.setHTML(1,2, DashboardMessages.MSG.id());
		deatilsTable.setHTML(2,2, DashboardMessages.MSG.midasId());
		deatilsTable.setHTML(3,2, DashboardMessages.MSG.name());
		deatilsTable.setHTML(4,2, DashboardMessages.MSG.address());
		deatilsTable.setHTML(5,2, DashboardMessages.MSG.zip());
		deatilsTable.setHTML(6,2, DashboardMessages.MSG.city());
		deatilsTable.setHTML(7,2, DashboardMessages.MSG.phone());
		deatilsTable.setHTML(8,2, DashboardMessages.MSG.email());
	}

	private void createHeader() {
		deatilsTable.setHTML(0, 0, DashboardMessages.MSG.broker());
		deatilsTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		deatilsTable.setHTML(0, 1, DashboardMessages.MSG.office());
		deatilsTable.getFlexCellFormatter().setColSpan(0, 1, 2);
		deatilsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
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
		deatilsTable.getFlexCellFormatter().setStyleName(6,1, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(7,1, CssStyles.DATA_DATA);
		
		deatilsTable.getFlexCellFormatter().setStyleName(1,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(2,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(3,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(4,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(5,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(6,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(7,3, CssStyles.DATA_DATA);
		deatilsTable.getFlexCellFormatter().setStyleName(8,3, CssStyles.DATA_DATA);
	}

	@Override
	public void setData(BrokerDTO data) {
		deatilsTable.setHTML(1,1,""+data.getId());
		deatilsTable.setHTML(2,1,""+data.getMidasId());
		deatilsTable.setHTML(3,1,data.getName());
		deatilsTable.setHTML(4,1,data.getSurname());
		deatilsTable.setHTML(5,1,data.getEmail());
		deatilsTable.setHTML(6,1,data.getPhone());
		deatilsTable.setHTML(7,1,data.getCellPhone());
		
		if(data.getBrokerOffice()!=null){
			deatilsTable.setHTML(1,3,""+data.getBrokerOffice().getId());
			deatilsTable.setHTML(2,3,""+data.getBrokerOffice().getMidasId());
			deatilsTable.setHTML(3,3,data.getBrokerOffice().getName());
			deatilsTable.setHTML(4,3,data.getBrokerOffice().getAddress());
			deatilsTable.setHTML(5,3,data.getBrokerOffice().getZip());
			deatilsTable.setHTML(6,3,data.getBrokerOffice().getCity());
			deatilsTable.setHTML(7,3,data.getBrokerOffice().getPhone());
			deatilsTable.setHTML(8,3,data.getBrokerOffice().getEmail());
		}
	}

	@Override
	public void setDataRequested() {
		deatilsTable.setWidget(1,1, new Image(BaseImages.IMG.loadingSmall()));
		deatilsTable.setWidget(1,3,   new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public void setChangePasswordListener(ChangePasswordListener changePasswordListener) {
		changePasswordWidget.setListener(changePasswordListener);
	}

	@Override
	public void setPasswordChangeStatus(Boolean status) {
		changePasswordWidget.setPasswordChangeStatus(status);
	}

	

}