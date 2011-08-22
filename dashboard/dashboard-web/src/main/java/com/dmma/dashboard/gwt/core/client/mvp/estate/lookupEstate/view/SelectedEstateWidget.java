package com.dmma.dashboard.gwt.core.client.mvp.estate.lookupEstate.view;


import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.estateInfo.PlaceCellBig;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

public class SelectedEstateWidget extends BaseComposite {
	private Button picUpButton;
	
	private FlexTable container;
	private PlaceCellBig placeCell;
	private EstateDTO pickedUpObject;
	
	
	public SelectedEstateWidget() {
		super(null);
		init();
	}
	private void init() {
		placeCell = new PlaceCellBig();
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
	
	 
	public void setSelectedObject(EstateDTO object) {
		pickedUpObject = object;
		renderPickedUpObject();
	}
	
	private void renderPickedUpObject(){
		if(pickedUpObject!=null){
			picUpButton.setEnabled(true);
			SafeHtmlBuilder sb = new SafeHtmlBuilder();
			placeCell.render(null, pickedUpObject, sb);
			container.setHTML(0, 0, sb.toSafeHtml());
		}else{
			picUpButton.setEnabled(false);
			container.setHTML(0, 0, "-NA-");
		}
	}
	
	public EstateDTO getPickedUpObject() {
		return pickedUpObject;
	}
	
	
}
