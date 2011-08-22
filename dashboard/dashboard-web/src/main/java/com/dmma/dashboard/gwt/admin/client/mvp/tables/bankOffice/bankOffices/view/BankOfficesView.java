package com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.bankOffices.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;

import java.util.ArrayList;

import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.bankOffices.presenter.BankOfficesPresenterDisplay;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter.EditBankOfficePresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.BankOfficeCM;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class BankOfficesView extends BaseCompositeView implements BankOfficesPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuBrokerOffices();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	private Button addNewButton;

	private GwtTable              table;
	private AbstractMetaGwtTableModel<BankOfficeDTO> tableModel;

	
	public BankOfficesView() {
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
		BankOfficeDTO example = new BankOfficeDTO();
		IGwtEntityCM META = new BankOfficeCM();
		tableModel = new AbstractMetaGwtTableModel<BankOfficeDTO>(example, META);
		table = new GwtTable(tableModel, false, true, EditBankOfficePresenter.PRESENTER_ID);

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
		addNewButton.setText(DashboardMessages.MSG.menuAddBankOffice());
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
	public void setData(ArrayList<BankOfficeDTO> data) {
		tableModel.setObjects(data);
	}

}