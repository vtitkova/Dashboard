package com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.view;


import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.contactInfo.ContactCellSmall;
import com.dmma.base.gwt.shared.interfaces.ContactInfoSmall;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.presenter.LookupClientPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class LookupClientView extends BaseComposite implements LookupClientPresenterDisplay{
	private Button closeButton;

	private TextBox clientPhone;

	//related to list
	private FlowPanel lishHolder;
	private ContactCellSmall contactCell;
	private CellList<ContactInfoSmall> cellList;
	private SingleSelectionModel<ContactInfoSmall> selectionModel;

	// related to form
	private FlowPanel rightWidgetHolder;
	private NewClientWidget  newClientWidget;
	private SelectedClientWidget  selectedClientWidget;
	
	
	public LookupClientView() {
		super("");


		init();
	}

	private void init(){
		FlexTable mainTable = new FlexTable();

		mainTable.setWidget(0, 0, createHeaderRow());
		mainTable.getFlexCellFormatter().setColSpan(0, 0, 2);

		mainTable.setWidget(1, 0, createMidleLeftCell());
		mainTable.setWidget(1, 1, createMidleRightCell());
		mainTable.getFlexCellFormatter().setRowSpan(1,0,2);
		mainTable.setWidget(2, 0, createBottomRow());
		mainTable.getFlexCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);
		mainTable.getFlexCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_TOP);
		mainTable.getFlexCellFormatter().setHorizontalAlignment(2,0,HasHorizontalAlignment.ALIGN_RIGHT);

		add(mainTable);
	}

	
	private Widget createMidleLeftCell() {
		contactCell = new ContactCellSmall();
		cellList = new CellList<ContactInfoSmall>(contactCell);
		cellList.setEmptyListWidget(new HTML(BaseMessages.MSG.dataNotFound()));
		selectionModel = new SingleSelectionModel<ContactInfoSmall>();
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				setSelectedObject((ClientDTO) selectionModel.getSelectedObject());
			}
		});

		lishHolder = new FlowPanel();
		lishHolder.add(cellList);
		ScrollPanel sp = new ScrollPanel(lishHolder);
		sp.setSize("100%", "100%");
		
		FlowPanel layout = new FlowPanel();
		layout.setWidth("250px");
		layout.setHeight("350px");
		layout.add(sp);

		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setWidget(layout);
		return decPanel;
	}

	private Widget createMidleRightCell() {
		
		rightWidgetHolder = new FlowPanel();
		rightWidgetHolder.setWidth("380px");
		rightWidgetHolder.setHeight("200px");
		
		
		newClientWidget = new NewClientWidget();
		selectedClientWidget = new SelectedClientWidget();
		selectedClientWidget.getSwitchToCreateButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				newClientWidget.clean();
				rightWidgetHolder.clear();
				rightWidgetHolder.add(newClientWidget);
				
			}
		});
		rightWidgetHolder.add(newClientWidget);

		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setWidget(rightWidgetHolder);
		return decPanel;
	}

	private Widget createBottomRow() {
		FlowPanel fp = new FlowPanel();
		closeButton = new Button(BaseMessages.MSG.close());
		fp.add(closeButton);
		return fp;
	}

	private Widget createHeaderRow() {
		FlowPanel fp = new FlowPanel();
		fp.add(new Label(DashboardMessages.MSG.enterPhone()));
		clientPhone = new TextBox();
		fp.add(clientPhone);
		return fp;
	}

	private void setSelectedObject(ClientDTO object){
		rightWidgetHolder.clear();
		rightWidgetHolder.add(selectedClientWidget);
		selectedClientWidget.setSelectedObject(object);
	}

	@Override
	public void setData(ArrayList<ClientDTO> data) {
		lishHolder.clear();
		cellList.setRowData(data);
		lishHolder.add(cellList);
	}

	@Override
	public void setDataRequested() {
		cellList.removeFromParent();
		lishHolder.add(new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public HasClickHandlers getCloseButton() {
		return closeButton;
	}

	@Override
	public HasClickHandlers getPicUpButton() {
		return selectedClientWidget.getPicUpButton();
	}

	@Override
	public ClientDTO getPickedUpObject() {
		return selectedClientWidget.getPickedUpObject();
	}

	@Override
	public HasKeyUpHandlers getClientPhone() {
		return clientPhone;
	}

	@Override
	public String getPhoneLookupString() {
		return clientPhone.getText();
	}

	@Override
	public HasClickHandlers getSaveAndPicUpButton() {
		return newClientWidget.getSaveAndPicUpButton();
	}

	@Override
	public void setDefaultPickedUpObject(ClientDTO defaultClient) {
		if(defaultClient!=null){
			setSelectedObject(defaultClient);
		}
	}

	@Override
	public ClientDTO getNewClient() {
		return newClientWidget.getData();
	}

	@Override
	public void setSavingInProcess() {
		newClientWidget.setSavingInProcess();
	}
	@Override
	public void setSavingFailed() {
		newClientWidget.setSavingFailed();
	}
	@Override
	public void errorInPhoneField() {
		newClientWidget.errorInPhoneField();
	}
}