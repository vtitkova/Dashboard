package com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.view;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.editor.GwtEntityEditor;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter.EditBankOfficePresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.BankOfficeCM;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class EditBankOfficeView extends BaseCompositeView implements EditBankOfficePresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuAddEditBankOffice();
	public static String VIEW_WIDTH = "800px";

	private Button saveButton;

	private GwtEntityEditor<BankOfficeDTO> editor; 
	
	public EditBankOfficeView() {
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
		editor = new GwtEntityEditor<BankOfficeDTO>(new BankOfficeCM());
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
	public BankOfficeDTO getData() {
		return editor.getData();
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	public void setData(BankOfficeDTO data) {
		editor.setData(data);
	}

	@Override
	public void errorInExternalIdField() {
		editor.setHaveErrorInField(1);
	}

	

}