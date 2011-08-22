package com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.view;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.editor.GwtEntityEditor;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter.EditBrokerOfficePresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.BrokerOfficeCM;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class EditBrokerOfficeView extends BaseCompositeView implements EditBrokerOfficePresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuAddEditBrokerOffice();
	public static String VIEW_WIDTH = "800px";

	private Button saveButton;

	private GwtEntityEditor<BrokerOfficeDTO> editor; 
	
	public EditBrokerOfficeView() {
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
		editor = new GwtEntityEditor<BrokerOfficeDTO>(new BrokerOfficeCM());
		return editor;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}


	private Widget getBottomWidget() {
		FlexTable widget = new FlexTable();

		saveButton = new  Button();
		saveButton.setText(DashboardMessages.MSG.save());
		widget.setWidget(0, 0, saveButton);
		widget.addStyleName(CssStyles.TABLE_DATA_PADDING_20);

		return widget;
	}
	

	@Override
	public BrokerOfficeDTO getData() {
		return editor.getData();
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	public void setData(BrokerOfficeDTO data) {
		editor.setData(data);
	}

	@Override
	public void errorInMidasIdField() {
		editor.setHaveErrorInField(1);
	}

	

}