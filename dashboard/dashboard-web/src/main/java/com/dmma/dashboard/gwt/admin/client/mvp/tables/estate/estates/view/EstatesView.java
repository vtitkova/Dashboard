package com.dmma.dashboard.gwt.admin.client.mvp.tables.estate.estates.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.estate.estates.presenter.EstatesPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.EstateCM;
import com.dmma.dashboard.gwt.core.client.renderer.EstateStatusTypeRenderer;
import com.dmma.dashboard.gwt.core.client.renderer.ViewingListRenderer;
import com.dmma.dashboard.gwt.core.client.types.search.EstateStatusSearchType;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class EstatesView extends BaseCompositeView implements EstatesPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuEstatesList();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	//private Button addNewButton;
	private Button findButton;

	private ListBox officesLB;
	private ListBox brokersLB;
	private ListBox estateStatusLB;
	
	private GwtTable              table;
	private AbstractMetaGwtTableModel<EstateDTO> tableModel;

	
	public EstatesView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");

		layout.setWidget(0, 0, getHeaderWidget());
		layout.setWidget(1, 0, getLineTableRowWidget());
		layout.setWidget(2, 0, getBottomWidget());

		return layout;
	}

	private Widget getHeaderWidget() {
		FlexTable widget = new FlexTable();
		
		widget.setHTML(0, 0, DashboardMessages.MSG.office());
		officesLB      = new ListBox();
		officesLB.setWidth("250px");
		widget.setWidget(0, 1, officesLB);
		
		widget.setHTML(0, 2, DashboardMessages.MSG.broker());
		brokersLB      = new ListBox();
		brokersLB.setWidth("250px");
		widget.setWidget(0, 3, brokersLB);
		
		
		
		widget.setHTML(0, 4, DashboardMessages.MSG.userStatus());
		estateStatusLB      = new ListBox();
		for(EstateStatusSearchType status: EstateStatusSearchType.values()){
			estateStatusLB.addItem(status.getTitle(), ""+status.getId());
		}
		widget.setWidget(0, 5, estateStatusLB);
		
		
		findButton  = new Button();
		findButton.setText(BaseMessages.MSG.find());
		widget.setWidget(0, 6, findButton);
		return widget;
	}
	
	private Widget getLineTableRowWidget() {
		EstateDTO example = new EstateDTO();
		IGwtEntityCM META = new EstateCM();
		tableModel = new AbstractMetaGwtTableModel<EstateDTO>(example, META);
		table = new GwtTable(tableModel, false, true, "yyy"); // TODO WTF   - a 4o na zction
		
		table.addEnumRenderer(4, new EstateStatusTypeRenderer());
		table.addEntityListRenderer(12, new ViewingListRenderer());
		
		table.setEditImageResource(BaseImages.IMG.editSmall());

		table.setViewPortHeight(VIEW_PORT_HEIGHT);
		return table;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}


	private Widget getBottomWidget() {
		FlexTable widget = new FlexTable();
		//addNewButton = new  Button();
		//addNewButton.setText(DashboardTRL.msg.menuAddUser()); // TODO 
		//widget.setWidget(0, 0, addNewButton);
		return widget;
	}

	@Override
	public void setDataRequested() {
		tableModel.setRequesting();
	}

	@Override
	public void setData(ArrayList<EstateDTO> data) {
		tableModel.setObjects(data);
	}

	@Override
	public HasClickHandlers getFindButton() {
		return findButton;
	}

	@Override
	public EstateSearchWrapper getEstateSearchWrapper() {
		EstateSearchWrapper wrapper = new EstateSearchWrapper();
		wrapper.setStatusSearchTypeId(BaseListBoxUtils.getSelectedValueAsInteger(estateStatusLB));
		Integer oId = BaseListBoxUtils.getSelectedValueAsInteger(officesLB);
		if(oId!=null&&oId>0)
			wrapper.setOfficeId(oId);
		Integer bId = BaseListBoxUtils.getSelectedValueAsInteger(brokersLB);
		if(bId!=null&&bId>0)
			wrapper.setBrokerId(bId);
		return wrapper;
	}

	@Override
	public void setEstateSearchWrapper(EstateSearchWrapper wrapper) {
		if(wrapper.getStatusSearchTypeId()!=null)
			BaseListBoxUtils.setSelectedItemByValue(estateStatusLB, ""+wrapper.getStatusSearchTypeId());
	}

	@Override
	public void setOfficesData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(officesLB, data);
	}

	@Override
	public void setOfficesNA() {
		BaseListBoxUtils.setItemsNAToLB(officesLB);
	}

	@Override
	public HasChangeHandlers getOfficesChange() {
		return officesLB;
	}

	@Override
	public void setBrokersNA() {
		BaseListBoxUtils.setItemsNAToLB(brokersLB);
		
	}

	@Override
	public HasChangeHandlers getBrokerChange() {
		return brokersLB;
	}

	@Override
	public HasChangeHandlers getStatusChange() {
		return estateStatusLB;
	}

	@Override
	public void setBrokersData(ArrayList<ListBoxDTO> data) {
		BaseListBoxUtils.setItemsToLB(brokersLB, data);
	}

	
}