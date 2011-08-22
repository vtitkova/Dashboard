package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>BankOfficeGWTService</code>.
 */
public interface BankOfficeGWTServiceAsync {
	public void findById(Integer id, AsyncCallback<BankOfficeDTO> callback);
	public void saveOrUpdate(BankOfficeDTO entity, AsyncCallback<Integer> callback);
	public void getMyOffice(AsyncCallback<BankOfficeDTO> callback);
	public void findByExternalId(Long midasId, AsyncCallback<BankOfficeDTO> callback);
	public void findAll(AsyncCallback<ArrayList<BankOfficeDTO>> callback);
	public void findAllShort(AsyncCallback<ArrayList<ListBoxDTO>> asyncCallback);
}
