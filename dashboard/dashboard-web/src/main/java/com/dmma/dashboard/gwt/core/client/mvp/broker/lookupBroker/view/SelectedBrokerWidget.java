package com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.view;


import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.contactInfo.ContactCellBig;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

public class SelectedBrokerWidget extends BaseComposite {
	private Button picUpButton;
	
	private FlexTable container;
	private ContactCellBig contactCell;
	private BrokerDTO pickedUpObject;
	
	
	public SelectedBrokerWidget() {
		super(null);
		init();
	}
	private void init() {
		contactCell = new ContactCellBig();
		container = new FlexTable();
		container.setWidth("100%");
		
		picUpButton = new Button(BaseMessages.MSG.pickUp());
		container.setHTML(0, 0, "");
		container.setWidget(1, 0, picUpButton);
		add(container);
	}
	
	
	public HasClickHandlers getPicUpButton() {
		return picUpButton;
	}
	
	 
	public void setSelectedObject(BrokerDTO object) {
		pickedUpObject = object;
		renderPickedUpObject();
	}
	
	private void renderPickedUpObject(){
		if(pickedUpObject!=null){
			picUpButton.setEnabled(true);
			SafeHtmlBuilder sb = new SafeHtmlBuilder();
			contactCell.render(null, pickedUpObject, sb);
			container.setHTML(0, 0, sb.toSafeHtml());
		}else{
			picUpButton.setEnabled(false);
			container.setHTML(0, 0, "-NA-");
		}
	}
	
	public BrokerDTO getPickedUpObject() {
		return pickedUpObject;
	}
	
	
}
