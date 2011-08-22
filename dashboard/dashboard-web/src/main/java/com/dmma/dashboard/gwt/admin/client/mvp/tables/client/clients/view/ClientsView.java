package com.dmma.dashboard.gwt.admin.client.mvp.tables.client.clients.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.client.clients.presenter.ClientsPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.ClientCM;
import com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter.EditClientPresenter;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ClientsView extends BaseCompositeView implements ClientsPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuClients();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	private Button addNewButton;
	private Button findButton;
	private TextBox phoneStartsTB;
	
	private GwtTable              table;
	private AbstractMetaGwtTableModel<ClientDTO> tableModel;

	
	public ClientsView() {
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
	
	private Widget getHeaderWidget() {
		FlexTable widget = new FlexTable();
		widget.setHTML(0, 0, DashboardMessages.MSG.phoneStarts());
		phoneStartsTB = new TextBox();
		widget.setWidget(0, 1, phoneStartsTB);
		
		findButton  = new Button();
		findButton.setText(BaseMessages.MSG.find());
		widget.setWidget(0, 2, findButton);
		return widget;
	}

	private Widget getLineTableRowWidget() {
		ClientDTO example = new ClientDTO();
		IGwtEntityCM META = new ClientCM();
		tableModel = new AbstractMetaGwtTableModel<ClientDTO>(example, META);
		table = new GwtTable(tableModel, true, true, EditClientPresenter.PRESENTER_ID);

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
		addNewButton.setText(DashboardMessages.MSG.menuAddClient());
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
	public void setData(ArrayList<ClientDTO> data) {
		tableModel.setObjects(data);
	}

	@Override
	public HasClickHandlers getFindButton() {
		return findButton;
	}

	@Override
	public String getPhoneStarts() {
		String phoneStarts = phoneStartsTB.getText().trim();
		return phoneStarts.length()==0?null:phoneStarts;
	}

	@Override
	public void setPhoneStarts(String phoneStarts){
		if(phoneStarts==null)
			phoneStartsTB.setText("");
		else
			phoneStartsTB.setText(phoneStarts);
	}

}