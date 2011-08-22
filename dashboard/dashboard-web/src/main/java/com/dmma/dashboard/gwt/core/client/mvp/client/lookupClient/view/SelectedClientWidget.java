package com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.view;


import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.contactInfo.ContactCellBig;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

public class SelectedClientWidget extends BaseComposite {
	private Button picUpButton;
	private Button switchToCreateButton;
	
	private FlexTable container;
	private ContactCellBig contactCell;
	private ClientDTO pickedUpObject;
	
	
	public SelectedClientWidget() {
		super(null);
		init();
	}
	private void init() {
		contactCell = new ContactCellBig();
		container = new FlexTable();
		container.setWidth("100%");
		
		picUpButton = new Button(BaseMessages.MSG.pickUp());
		switchToCreateButton = new Button(BaseMessages.MSG.createNew());
		container.setHTML(0, 0, "");
		container.getFlexCellFormatter().setColSpan(0, 0, 2);
		container.setWidget(1, 0, picUpButton);
		container.setWidget(1, 1, switchToCreateButton);
		
		add(container);
	}
	
	
	public HasClickHandlers getPicUpButton() {
		return picUpButton;
	}
	
	public HasClickHandlers getSwitchToCreateButton() {
		return switchToCreateButton;
	}
	 
	public void setSelectedObject(ClientDTO object) {
		pickedUpObject = object;
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
		contactCell.render(null, object, sb);
		container.setHTML(0, 0, sb.toSafeHtml());
		
	}
	public ClientDTO getPickedUpObject() {
		return pickedUpObject;
	}
	
	
}
