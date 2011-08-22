package com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter;

import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface EditBankOfficePresenterDisplay {
	public Widget asWidget();
	public void setData(BankOfficeDTO data);
	public HasClickHandlers getSaveButton();
	public BankOfficeDTO getData();
	public void errorInExternalIdField();
	
}
