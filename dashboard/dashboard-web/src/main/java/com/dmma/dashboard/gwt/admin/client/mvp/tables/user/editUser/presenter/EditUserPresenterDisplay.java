package com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter;

import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface EditUserPresenterDisplay {
	public Widget asWidget();
	public void setData(UserDTO data);
	public void setBrokerProfile(final BrokerDTO broker, final Integer userId);
	public void setBankerProfile(final BankerDTO banker, final Integer userId);
	public void setAdminProfile(Boolean isAdmin);
	public HasClickHandlers getSaveButton();
	public UserDTO getData();
	public void setBrokerProfileRequested();
	public void setBankerProfileRequested();
	public void setAdminProfileRequested();
	public HasClickHandlers getIsAdminCB();
	public Boolean getIsAdmin();
	public void setDataRequested();
	public void errorInEmailField();
	
	
}
