/*package com.dmma.dashboard.gwt.admin.client.mvp.setups.mailtemplate.view;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.rte.RichTextEditor;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.entities.MailTemplateDTO;
import com.dmma.dashboard.gwt.admin.client.mvp.setups.mailtemplate.presenter.MailTemplatePresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.types.MailTemplateNameType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class MailTemplateView extends BaseCompositeView implements  MailTemplatePresenterDisplay{
	interface MyUiBinder extends UiBinder<Widget, MailTemplateView> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	public static String VIEW_TITLE = DashboardMessages.MSG.menuMailTemplates();
	public static String VIEW_WIDTH = "800px";
	
	@UiField
	ListBox nameLB;
	
	@UiField
	HTML availableTags;
	
	@UiField
	TextBox headerTB;
	
	@UiField
	RichTextEditor bodyRT;
	
	@UiField
	Button saveButton;
	
	
	@UiField
	HTMLPanel mailPanelContainer;
	@UiField
	HTMLPanel loadingPanelContainer;
	
	public MailTemplateView(){
		super(VIEW_TITLE, "BookingPoView");
		
		nameLB.addItem(BaseMessages.MSG.select(), "select");
		for(MailTemplateNameType value: MailTemplateNameType.values()){
			nameLB.addItem(value.getTitle(), value.getName());
		}
		mailPanelContainer.setVisible(false);
		loadingPanelContainer.setVisible(false);
	}

	
	@Override
	protected Widget createContent() {
		return uiBinder.createAndBindUi(this);
	}

	public MailTemplateDTO data;
	@Override
	public void setData(MailTemplateDTO data, String[] availableTags) {
		this.data = data;
		loadingPanelContainer.setVisible(false);
		nameLB.setEnabled(true);
		if(data==null){
			mailPanelContainer.setVisible(false);
			return;
		}
		mailPanelContainer.setVisible(true);
		StringBuilder sb = new StringBuilder();
		if(availableTags != null){
			for(int i = 0; i<availableTags.length; i++ ){
				sb.append("$").append(availableTags[i]).append("$");
				if(i<availableTags.length - 1)
					sb.append(", ");
			}
		}
		this.availableTags.setText(sb.toString());
		
		headerTB.setValue(data.getHeader());
		bodyRT.setHTML(data.getBody());
		saveButton.setEnabled(true);
	}


	@Override
	public void setDataRequested() {
		loadingPanelContainer.setVisible(true);
		nameLB.setEnabled(false);
	}


	@Override
	public MailTemplateDTO getData() {
		if(data == null) return null;
		
		data.setHeader(headerTB.getValue());
		data.setBody(bodyRT.getHTML());
		return data;
	}


	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	public HasChangeHandlers getNamesListBox() {
		return nameLB;
	}

	@Override
	protected String getPrefferedWidth() {
		return VIEW_WIDTH;
	}


	@Override
	public String getSelectedName() {
		String val = BaseListBoxUtils.getSelectedValueAsString(nameLB);
		if(val==null||val.equals("select"))
			return null;
		else
			return val;
	}

	@Override
	public void setSaveRequested() {
		saveButton.setEnabled(false);
	}

	@Override
	public void setSaved() {
		saveButton.setEnabled(true);
	}

}*/