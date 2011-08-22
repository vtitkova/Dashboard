package com.dmma.dashboard.gwt.admin.client.mvp.tables.user.users.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.UserSearchWrapper;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface UsersPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<UserDTO> data);
	public void setDataRequested();
	public HasClickHandlers getAddNewButton();
	public HasClickHandlers getFindButton();
	public UserSearchWrapper getUserSearchWrapper();
	public void setUserSearchWrapper(UserSearchWrapper wrapper);
}
