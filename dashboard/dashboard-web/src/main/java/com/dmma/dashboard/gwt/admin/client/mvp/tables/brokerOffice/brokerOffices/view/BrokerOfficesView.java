package com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.brokerOffices.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;

import java.util.ArrayList;

import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.brokerOffices.presenter.BrokerOfficesPresenterDisplay;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter.EditBrokerOfficePresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.BrokerOfficeCM;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class BrokerOfficesView extends BaseCompositeView implements BrokerOfficesPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuBrokerOffices();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	private Button addNewButton;

	private GwtTable              table;
	private AbstractMetaGwtTableModel<BrokerOfficeDTO> tableModel;

	
	public BrokerOfficesView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");

		layout.setWidget(0, 0, getLineTableRowWidget());
		layout.setWidget(1, 0, getBottomWidget());

		return layout;
	}

	private Widget getLineTableRowWidget() {
		BrokerOfficeDTO example = new BrokerOfficeDTO();
		IGwtEntityCM META = new BrokerOfficeCM();
		tableModel = new AbstractMetaGwtTableModel<BrokerOfficeDTO>(example, META);
		table = new GwtTable(tableModel, false, true, EditBrokerOfficePresenter.PRESENTER_ID);

		table.setEditImageResource(BaseImages.IMG.editSmall());

		table.setViewPortHeight(VIEW_PORT_HEIGHT);
		return table;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}


	private Widget getBottomWidget() {
		FlexTable widget = new FlexTable();
		addNewButton = new  Button();
		addNewButton.setText(DashboardMessages.MSG.menuAddBrokerOffice());
		widget.setWidget(0, 0, addNewButton);
		return widget;
	}

	@Override
	public void setDataRequested() {
		tableModel.setRequesting();
	}

	@Override
	public HasClickHandlers getAddNewButton() {
		return addNewButton;
	}

	@Override
	public void setData(ArrayList<BrokerOfficeDTO> data) {
		tableModel.setObjects(data);
	}

}