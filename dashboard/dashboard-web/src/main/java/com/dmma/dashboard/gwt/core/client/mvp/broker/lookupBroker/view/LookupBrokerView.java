package com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.view;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.contactInfo.ContactCellSmall;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.interfaces.ContactInfoSmall;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.presenter.LookupBrokerPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class LookupBrokerView extends BaseComposite implements LookupBrokerPresenterDisplay{
	private Button closeButton;

	private ListBox brokerOfficeLB;

	//related to list
	private FlowPanel lishHolder;
	private ContactCellSmall contactCell;
	private CellList<ContactInfoSmall> cellList;
	private SingleSelectionModel<ContactInfoSmall> selectionModel;

	// related to form
	private FlowPanel rightWidgetHolder;
	private SelectedBrokerWidget  selectedBrokerWidget;
	
	
	public LookupBrokerView() {
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
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
		sb.appendHtmlConstant("<b>Data not found</b>");
		cellList.setEmptyListMessage(sb.toSafeHtml());
		selectionModel = new SingleSelectionModel<ContactInfoSmall>();
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				setSelectedObject((BrokerDTO) selectionModel.getSelectedObject());
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
		
		
		selectedBrokerWidget = new SelectedBrokerWidget();
		rightWidgetHolder.add(selectedBrokerWidget);

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
		FlexTable fp = new FlexTable();
		fp.setWidget(0, 0, new Label(DashboardMessages.MSG.brokerOffice())); 
		brokerOfficeLB = new ListBox();
		brokerOfficeLB.setWidth("250px");
		BaseListBoxUtils.setItemsNAToLB(brokerOfficeLB);
		fp.setWidget(0, 1, brokerOfficeLB);
		return fp;
	}

	private void setSelectedObject(BrokerDTO object){
		selectedBrokerWidget.setSelectedObject(object);
	}

	@Override
	public void setData(ArrayList<BrokerDTO> data) {
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
		return selectedBrokerWidget.getPicUpButton();
	}

	@Override
	public BrokerDTO getPickedUpObject() {
		return selectedBrokerWidget.getPickedUpObject();
	}

	
	@Override
	public void setDefaultPickedUpObject(BrokerDTO defaultClient) {
			setSelectedObject(defaultClient);
	}

	@Override
	public void setRecentData(ArrayList<BrokerDTO> data) {
		// TODO setRecentData - v adminke eto ne aktualjno, a vot v bankere ... 
	}

	@Override
	public HasChangeHandlers getBrokerOfficeChangeHandler() {
		return brokerOfficeLB;
	}

	@Override
	public Integer getSelectedBrokerOfficeId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(brokerOfficeLB);
	}

	@Override
	public void setBrokerOfficeData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(brokerOfficeLB, data);
	}
	
}