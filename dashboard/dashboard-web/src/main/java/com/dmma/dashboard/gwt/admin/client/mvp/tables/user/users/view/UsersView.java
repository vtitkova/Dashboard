package com.dmma.dashboard.gwt.admin.client.mvp.tables.user.users.view;

import gwt.dmma.base.client.ui.table.AbstractMetaGwtTableModel;
import gwt.dmma.base.client.ui.table.GwtTable;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter.EditUserPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.users.presenter.UsersPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.UserCM;
import com.dmma.dashboard.gwt.core.client.types.search.UserRoleSearchType;
import com.dmma.dashboard.gwt.core.client.types.search.UserStatusSearchType;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.UserSearchWrapper;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UsersView extends BaseCompositeView implements UsersPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuUsers();
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	private Button addNewButton;
	private Button findButton;

	private TextBox partOfEmailTB;
	private TextBox midasIdTB;
	private TextBox externalIdTB;
	private ListBox userRoleLB;
	private ListBox userStatusLB;
	
	private GwtTable              table;
	private AbstractMetaGwtTableModel<UserDTO> tableModel;

	
	public UsersView() {
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
		widget.setHTML(0, 0, DashboardMessages.MSG.partOfEmail());
		partOfEmailTB = new TextBox();
		widget.setWidget(0, 1, partOfEmailTB);
			
		widget.setHTML(0, 2, DashboardMessages.MSG.midasId());
		midasIdTB = new TextBox();
		midasIdTB.setWidth("70px");
		widget.setWidget(0, 3, midasIdTB);
		
		widget.setHTML(0, 4, DashboardMessages.MSG.externalId());
		externalIdTB = new TextBox();
		externalIdTB.setWidth("70px");
		widget.setWidget(0, 5, externalIdTB);
		
		widget.setHTML(0, 6, DashboardMessages.MSG.userRole());
		userRoleLB       = new ListBox();
		for(UserRoleSearchType userRole: UserRoleSearchType.values()){
			userRoleLB.addItem(userRole.getTitle(), ""+userRole.getId());
		}
		widget.setWidget(0, 7, userRoleLB);
		
		widget.setHTML(0, 8, DashboardMessages.MSG.userStatus());
		userStatusLB      = new ListBox();
		for(UserStatusSearchType userStatus: UserStatusSearchType.values()){
			userStatusLB.addItem(userStatus.getTitle(), ""+userStatus.getId());
		}
		widget.setWidget(0, 9, userStatusLB);
		
		
		findButton  = new Button();
		findButton.setText(BaseMessages.MSG.find());
		widget.setWidget(0, 11, findButton);
		return widget;
	}
	
	private Widget getLineTableRowWidget() {
		UserDTO example = new UserDTO();
		IGwtEntityCM META = new UserCM();
		tableModel = new AbstractMetaGwtTableModel<UserDTO>(example, META);
		table = new GwtTable(tableModel, false, true, EditUserPresenter.PRESENTER_ID);

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
		addNewButton = new  Button();
		addNewButton.setText(DashboardMessages.MSG.menuAddUser());
		widget.setWidget(0, 0, addNewButton);
		return widget;
	}

	@Override
	public void setDataRequested() {
		tableModel.setRequesting();
	}

	@Override
	public HasClickHandlers getAddNewButton() {
		return addNewButton;
	}

	@Override
	public void setData(ArrayList<UserDTO> data) {
		tableModel.setObjects(data);
	}

	@Override
	public HasClickHandlers getFindButton() {
		return findButton;
	}

	@Override
	public UserSearchWrapper getUserSearchWrapper() {
		UserSearchWrapper wrapper = new UserSearchWrapper();
		String partOfEmail = partOfEmailTB.getText().trim();
		if(partOfEmail.length()>0)
			wrapper.setPartOfEmail(partOfEmail);
		Long midasId = null;
		try{
			midasId = new Long(midasIdTB.getText().trim());
		}catch (Exception e) {
			midasIdTB.setText("");
		}
		wrapper.setMidasId(midasId);
		Long externalId = null;
		try{
			externalId = new Long(externalIdTB.getText().trim());
		}catch (Exception e) {
			externalIdTB.setText("");
		}
		wrapper.setExternalId(externalId);

		wrapper.setRoleTypeId(BaseListBoxUtils.getSelectedValueAsInteger(userRoleLB));
		wrapper.setStatusTypeId(BaseListBoxUtils.getSelectedValueAsInteger(userStatusLB));
		return wrapper;
	}

	@Override
	public void setUserSearchWrapper(UserSearchWrapper wrapper) {
		partOfEmailTB.setText(wrapper.getPartOfEmail());
		midasIdTB.setText(wrapper.getMidasId()==null?"":""+wrapper.getMidasId());
		externalIdTB.setText(wrapper.getExternalId()==null?"":""+wrapper.getExternalId());
		if(wrapper.getRoleTypeId()!=null)
			BaseListBoxUtils.setSelectedItemByValue(userRoleLB, ""+wrapper.getRoleTypeId());
		if(wrapper.getStatusTypeId()!=null)
			BaseListBoxUtils.setSelectedItemByValue(userStatusLB, ""+wrapper.getStatusTypeId());
	}

}