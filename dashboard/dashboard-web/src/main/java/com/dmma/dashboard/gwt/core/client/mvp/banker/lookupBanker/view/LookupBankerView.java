package com.dmma.dashboard.gwt.core.client.mvp.banker.lookupBanker.view;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.contactInfo.ContactCellSmall;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.interfaces.ContactInfoSmall;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.banker.lookupBanker.presenter.LookupBankerPresenterDisplay;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
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

public class LookupBankerView extends BaseComposite implements LookupBankerPresenterDisplay{
	private Button closeButton;

	private ListBox bankOfficeLB;

	//related to list
	private FlowPanel lishHolder;
	private ContactCellSmall contactCell;
	private CellList<ContactInfoSmall> cellList;
	private SingleSelectionModel<ContactInfoSmall> selectionModel;

	// related to form
	private FlowPanel rightWidgetHolder;
	private SelectedBankerWidget  selectedBankerWidget;
	
	
	public LookupBankerView() {
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
				setSelectedObject((BankerDTO) selectionModel.getSelectedObject());
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
		
		
		selectedBankerWidget = new SelectedBankerWidget();
		rightWidgetHolder.add(selectedBankerWidget);

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
		fp.setWidget(0, 0, new Label(DashboardMessages.MSG.bankOffice())); 
		bankOfficeLB = new ListBox();
		bankOfficeLB.setWidth("250px");
		BaseListBoxUtils.setItemsNAToLB(bankOfficeLB);
		fp.setWidget(0, 1, bankOfficeLB);
		return fp;
	}

	private void setSelectedObject(BankerDTO object){
		selectedBankerWidget.setSelectedObject(object);
	}

	@Override
	public void setData(ArrayList<BankerDTO> data) {
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
		return selectedBankerWidget.getPicUpButton();
	}

	@Override
	public BankerDTO getPickedUpObject() {
		return selectedBankerWidget.getPickedUpObject();
	}

	
	@Override
	public void setDefaultPickedUpObject(BankerDTO defaultClient) {
			setSelectedObject(defaultClient);
	}

	@Override
	public void setRecentData(ArrayList<BankerDTO> data) {
		// TODO setRecentData - v adminke eto ne aktualjno, a vot v brokere ... 
	}

	@Override
	public HasChangeHandlers getBankOfficeChangeHandler() {
		return bankOfficeLB;
	}

	@Override
	public Integer getSelectedBankOfficeId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(bankOfficeLB);
	}

	@Override
	public void setBankOfficeData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(bankOfficeLB, data);
	}
	
}