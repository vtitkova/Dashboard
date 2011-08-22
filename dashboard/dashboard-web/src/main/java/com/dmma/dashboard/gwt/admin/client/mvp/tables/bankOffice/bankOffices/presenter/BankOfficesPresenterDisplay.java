package com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.bankOffices.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface BankOfficesPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<BankOfficeDTO> data);
	public void setDataRequested();
	public HasClickHandlers getAddNewButton();
}
