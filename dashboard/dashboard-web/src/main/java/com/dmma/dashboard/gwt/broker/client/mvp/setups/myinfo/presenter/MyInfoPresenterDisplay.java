package com.dmma.dashboard.gwt.broker.client.mvp.setups.myinfo.presenter;

import com.dmma.base.gwt.client.ui.changepassword.ChangePasswordListener;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.user.client.ui.Widget;

public interface MyInfoPresenterDisplay {
	public Widget asWidget();
	public void setData(BrokerDTO data);
	public void setDataRequested();
	public void setChangePasswordListener(ChangePasswordListener changePasswordListener);
	public void setPasswordChangeStatus(Boolean status);
	
	
	//public HasClickHandlers getNextButton();
	//public HasClickHandlers getNextButton();
	
	
}
