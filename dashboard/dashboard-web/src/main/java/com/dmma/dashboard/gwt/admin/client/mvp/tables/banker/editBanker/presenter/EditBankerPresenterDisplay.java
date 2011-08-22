package com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.editBanker.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface EditBankerPresenterDisplay {
	public Widget asWidget();
	public void setData(BankerDTO data, ArrayList<BankOfficeDTO> offices);
	public HasClickHandlers getSaveButton();
	public HasClickHandlers getLinkToNewBankOfficeButton();
	public HasClickHandlers getLinkToUserButton();
	public BankerDTO getData();
	public String getPassword();
	public void errorInExternalIdField();
	public void errorInUserField();
	public void errorInEmailField();
}
