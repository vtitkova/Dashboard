package com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.view;

import gwt.dmma.base.client.ui.listBox.DmListBox;
import gwt.dmma.base.client.utils.CssStyles;

import java.util.ArrayList;

import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.editor.GwtEntityEditor;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.presenter.EditBrokerPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.BrokerCM;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditBrokerView extends BaseCompositeView implements EditBrokerPresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuAddEditBroker();
	public static String VIEW_WIDTH = "800px";

	private Button saveButton;
	private Label  linkToNewBrokerOffice;
	private Label  linkToUser;
	private FlowPanel newUserProfile;
	private TextBox password;
	private GwtEntityEditor<BrokerDTO> editor; 
	private DmListBox<BrokerOfficeDTO> brokerOfficeFieldEditor;

	
	public EditBrokerView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");

		layout.setWidget(0, 0, getLineTableRowWidget());
		

		linkToNewBrokerOffice = new Label(DashboardMessages.MSG.menuAddBrokerOffice());
		linkToNewBrokerOffice.addStyleName(CssStyles.ACTION_WRAP);
	
		linkToUser = new Label(DashboardMessages.MSG.userDetails());
		linkToUser.addStyleName(CssStyles.ACTION_WRAP);
		
		newUserProfile = new FlowPanel();
		Label noteLabel = new Label(DashboardMessages.MSG.newUserWillBeCreated());
		newUserProfile.add(noteLabel);
		password = new TextBox();
		newUserProfile.add(password);
		newUserProfile.setVisible(false);
		layout.setWidget(1, 0, newUserProfile);
		layout.setWidget(2, 0, getBottomWidget());
		
		return layout;
	}

	private Widget getLineTableRowWidget() {
		editor = new GwtEntityEditor<BrokerDTO>(new BrokerCM());
		return editor;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}


	private Widget getBottomWidget() {
		FlexTable widget = new FlexTable();

		saveButton = new  Button();
		saveButton.setText("Save");
		widget.setWidget(0, 0, saveButton);
		widget.addStyleName(CssStyles.TABLE_DATA_PADDING_20);

		return widget;
	}
	

	@Override
	public BrokerDTO getData() {
		return editor.getData();
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	public void setData(BrokerDTO data, ArrayList<BrokerOfficeDTO> offices) {
		brokerOfficeFieldEditor = new DmListBox<BrokerOfficeDTO>(true);
		brokerOfficeFieldEditor.setItems(offices);
		editor.setFieldEditor(BrokerOfficeDTO.class,brokerOfficeFieldEditor);
		editor.setData(data);
		
		editor.getContentTable().setWidget(9,2, linkToNewBrokerOffice);
		if(data.getUserId()!=null){
			editor.getContentTable().setWidget(1,2, linkToUser);
		}
		
		if(data.getId()==null&&data.getUserId()==null){
			newUserProfile.setVisible(true);
			password.setText("");
		}else{
			newUserProfile.setVisible(false);
		}
	}

	@Override
	public HasClickHandlers getLinkToNewBrokerOfficeButton() {
		return linkToNewBrokerOffice;
	}

	@Override
	public HasClickHandlers getLinkToUserButton() {
		return linkToUser;
	}

	@Override
	public String getPassword() {
		return password.getValue();
	}

	@Override
	public void errorInMidasIdField() {
		editor.setHaveErrorInField(2);
	}

	@Override
	public void errorInUserField() {
		editor.setHaveErrorInField(1);
	}

	@Override
	public void errorInEmailField() {
		editor.setHaveErrorInField(5);
	}

}