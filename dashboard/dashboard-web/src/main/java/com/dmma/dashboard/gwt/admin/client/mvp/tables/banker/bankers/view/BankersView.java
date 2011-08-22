package com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.bankers.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;

import java.util.ArrayList;

import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.bankers.presenter.BankersPresenterDisplay;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.editBanker.presenter.EditBankerPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.BankerCM;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class BankersView extends BaseCompositeView implements BankersPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuBankers();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT = "400px";

	private ListBox officesLB;
	private Button addNewButton;

	private GwtTable              table;
	private AbstractMetaGwtTableModel<BankerDTO> tableModel;

	public BankersView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");

		layout.setWidget(0, 0, getHeaderWidget());
		layout.setWidget(1, 0, getLineTableRowWidget());
		layout.setWidget(2, 0, getBottomWidget());

		return layout;
	}

	private Widget getLineTableRowWidget() {
		BankerDTO example = new BankerDTO();
		IGwtEntityCM META = new BankerCM();
		tableModel = new AbstractMetaGwtTableModel<BankerDTO>(example, META);
		table = new GwtTable(tableModel, false, true, EditBankerPresenter.PRESENTER_ID);

		table.setEditImageResource(BaseImages.IMG.editSmall());

		table.setViewPortHeight(VIEW_PORT_HEIGHT);
		return table;
	}

	private Widget getHeaderWidget() {
		FlexTable widget = new FlexTable();
		officesLB = new ListBox();
		widget.setWidget(0, 0, officesLB);
		return widget;
	}
	
	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}


	private Widget getBottomWidget() {
		FlexTable widget = new FlexTable();
		addNewButton = new  Button();
		addNewButton.setText(DashboardMessages.MSG.menuAddBanker());
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
	public void setData(ArrayList<BankerDTO> data) {
		tableModel.setObjects(data);
	}

	@Override
	public void setBankOffices(ArrayList<BankOfficeDTO> bankOffices) {
		officesLB.clear();
		officesLB.addItem(" - All - ", "-1");
		for(BankOfficeDTO dto:bankOffices){
			officesLB.addItem(dto.getName(), ""+dto.getId());
		}
	}

	@Override
	public HasChangeHandlers getBankOfficesLB() {
		return officesLB;
	}

	@Override
	public void setSelectedBankOffice(Integer id) {
		BaseListBoxUtils.setSelectedItemByValue(officesLB, ""+id);
	}

	@Override
	public Integer getSelectedBankOffice() {
		return BaseListBoxUtils.getSelectedValueAsInteger(officesLB);
	}

}