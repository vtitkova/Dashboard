package com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.brokers.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;

import java.util.ArrayList;

import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.brokers.presenter.BrokersPresenterDisplay;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.presenter.EditBrokerPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.BrokerCM;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class BrokersView extends BaseCompositeView implements BrokersPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuBrokers();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT = "400px";

	private ListBox officesLB;
	private Button addNewButton;

	private GwtTable              table;
	private AbstractMetaGwtTableModel<BrokerDTO> tableModel;

	public BrokersView() {
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
		BrokerDTO example = new BrokerDTO();
		IGwtEntityCM META = new BrokerCM();
		tableModel = new AbstractMetaGwtTableModel<BrokerDTO>(example, META);
		table = new GwtTable(tableModel, false, true, EditBrokerPresenter.PRESENTER_ID);

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
		addNewButton.setText(DashboardMessages.MSG.menuAddBroker());
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
	public void setData(ArrayList<BrokerDTO> data) {
		tableModel.setObjects(data);
	}

	@Override
	public void setBrokerOffices(ArrayList<BrokerOfficeDTO> brokerOffices) {
		officesLB.clear();
		officesLB.addItem(" - All - ", "-1");
		for(BrokerOfficeDTO dto:brokerOffices){
			officesLB.addItem(dto.getName(), ""+dto.getId());
		}
	}

	@Override
	public HasChangeHandlers getBrokerOfficesLB() {
		return officesLB;
	}

	@Override
	public void setSelectedBrokerOffice(Integer id) {
		if(id==null) id = -1;
		BaseListBoxUtils.setSelectedItemByValue(officesLB, ""+id);
	}

	@Override
	public Integer getSelectedBrokerOffice() {
		return BaseListBoxUtils.getSelectedValueAsInteger(officesLB);
	}

}