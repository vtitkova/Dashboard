package com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.bankers.presenter;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface BankersPresenterDisplay {
	public Widget asWidget();
	public void setData(ArrayList<BankerDTO> data);
	public void setDataRequested();
	public HasClickHandlers getAddNewButton();
	public void setBankOffices(ArrayList<BankOfficeDTO> bankOffices);
	
	public HasChangeHandlers  getBankOfficesLB();
	public void               setSelectedBankOffice(Integer id);
	public Integer            getSelectedBankOffice();
}
