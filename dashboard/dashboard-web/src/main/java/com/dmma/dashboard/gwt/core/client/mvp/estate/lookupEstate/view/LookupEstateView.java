package com.dmma.dashboard.gwt.core.client.mvp.estate.lookupEstate.view;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.estateInfo.PlaceCellSmall;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.interfaces.PlaceInfoSmall;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.estate.lookupEstate.presenter.LookupEstatePresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
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

public class LookupEstateView extends BaseComposite implements LookupEstatePresenterDisplay{
	private Button closeButton;
	
	private Label   brokerOfficeLA;
	private ListBox brokerOfficeLB;
	private ListBox brokerLB;

	private CheckBox showOnlyActiveCB;
	
	//related to list
	private FlowPanel lishHolder;
	private PlaceCellSmall placeCell;
	private CellList<PlaceInfoSmall> cellList;
	private SingleSelectionModel<PlaceInfoSmall> selectionModel;

	// related to form
	private FlowPanel rightWidgetHolder;
	private SelectedEstateWidget  selectedEstateWidget;
	
	
	public LookupEstateView() {
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
		placeCell = new PlaceCellSmall();
		cellList = new CellList<PlaceInfoSmall>(placeCell);
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
		sb.appendHtmlConstant("<b>Data not found</b>");
		cellList.setEmptyListMessage(sb.toSafeHtml());
		selectionModel = new SingleSelectionModel<PlaceInfoSmall>();
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				setSelectedObject((EstateDTO) selectionModel.getSelectedObject());
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
		
		
		selectedEstateWidget = new SelectedEstateWidget();
		rightWidgetHolder.add(selectedEstateWidget);

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
		// Office
		brokerOfficeLA = new Label(DashboardMessages.MSG.brokerOffice());
		fp.setWidget(0, 0, brokerOfficeLA ); 
		brokerOfficeLB = new ListBox();
		brokerOfficeLB.setWidth("250px");
		BaseListBoxUtils.setItemsNAToLB(brokerOfficeLB);
		fp.setWidget(0, 1, brokerOfficeLB);
		
		// Office
		fp.setWidget(0, 2, new Label(DashboardMessages.MSG.broker())); 
		brokerLB = new ListBox();
		brokerLB.setWidth("250px");
		BaseListBoxUtils.setItemsNAToLB(brokerLB);
		fp.setWidget(0, 3, brokerLB);
		
		showOnlyActiveCB = new CheckBox(DashboardMessages.MSG.showOnlyActiveEstate());
		showOnlyActiveCB.setValue(true);
		fp.setWidget(0, 4, showOnlyActiveCB);
		
		
		return fp;
	}

	private void setSelectedObject(EstateDTO object){
		selectedEstateWidget.setSelectedObject(object);
	}

	@Override
	public void setEstateData(ArrayList<EstateDTO> data) {
		lishHolder.clear();
		cellList.setRowData(data);
		lishHolder.add(cellList);
	}

	@Override
	public void setEstateDataRequested() {
		cellList.removeFromParent();
		lishHolder.add(new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public HasClickHandlers getCloseButton() {
		return closeButton;
	}

	@Override
	public HasClickHandlers getPicUpButton() {
		return selectedEstateWidget.getPicUpButton();
	}

	@Override
	public EstateDTO getPickedUpObject() {
		return selectedEstateWidget.getPickedUpObject();
	}

	
	@Override
	public void setDefaultPickedUpObject(EstateDTO defaultEstate) {
			setSelectedObject(defaultEstate);
	}

	@Override
	public HasChangeHandlers getBrokerOfficeChangeHandler() {
		return brokerOfficeLB;
	}

	@Override
	public HasChangeHandlers getBrokerChangeHandler() {
		return brokerLB;
	}
	
	@Override
	public Integer getSelectedBrokerOfficeId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(brokerOfficeLB);
	}

	@Override
	public Integer getSelectedBrokerId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(brokerLB);
	}

	
	@Override
	public void setBrokerOfficeData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(brokerOfficeLB, data);
	}
	
	@Override
	public void setBrokerData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(brokerLB, data);
	}

	@Override
	public void setBrokerDataRequested() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HasValueChangeHandlers<Boolean> getIsShowOnlyActiveHandler() {
		return showOnlyActiveCB;
	}

	@Override
	public Boolean getIsShowOnlyActive() {
		return showOnlyActiveCB.getValue();
	}

	@Override
	public void setDefaultBroker(BrokerDTO b) {
		brokerOfficeLA.setVisible(false);
		brokerOfficeLB.setVisible(false);
		brokerLB.clear();
		brokerLB.setEnabled(false);
		brokerLB.addItem(b.getName() + " "+b.getSurname(), b.getId()+"");
	}
}