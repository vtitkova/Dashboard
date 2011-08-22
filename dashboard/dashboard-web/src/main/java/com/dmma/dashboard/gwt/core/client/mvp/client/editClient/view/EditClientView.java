package com.dmma.dashboard.gwt.core.client.mvp.client.editClient.view;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.ui.gwtentity.editor.GwtEntityEditor;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.ClientCM;
import com.dmma.dashboard.gwt.core.client.mvp.client.editClient.presenter.EditClientPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class EditClientView extends Composite implements EditClientPresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuAddEditClient();

	private Button saveButton;

	private GwtEntityEditor<ClientDTO> editor; 
	
	public EditClientView() {
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");

		layout.setWidget(0, 0, getLineTableRowWidget());
		layout.setWidget(1, 0, getBottomWidget());

		initWidget(layout);
	}

	private Widget getLineTableRowWidget() {
		editor = new GwtEntityEditor<ClientDTO>(new ClientCM());
		return editor;
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
	public ClientDTO getData() {
		return editor.getData();
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	public void setData(ClientDTO data) {
		editor.setData(data);
	}

	@Override
	public void errorInPhoneField() {
		editor.setHaveErrorInField(4);
	}

	@Override
	public void setActiveSaveButton(boolean enabled) {
		saveButton.setEnabled(enabled);
	}

	@Override
	public String getCaption() {
		return VIEW_TITLE;
	}

	

}