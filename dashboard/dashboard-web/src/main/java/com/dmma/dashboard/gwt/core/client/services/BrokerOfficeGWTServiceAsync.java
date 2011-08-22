package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>OfficeGWTService</code>.
 */
public interface BrokerOfficeGWTServiceAsync {
	public void findById(Integer id, AsyncCallback<BrokerOfficeDTO> callback);
	public void saveOrUpdate(BrokerOfficeDTO entity, AsyncCallback<Integer> callback);

	public void getMyOffice(AsyncCallback<BrokerOfficeDTO> callback);
	public void findByMidasId(Long midasId, AsyncCallback<BrokerOfficeDTO> callback);
	public void findAll(AsyncCallback<ArrayList<BrokerOfficeDTO>> callback);
	public void findAllShort(AsyncCallback<ArrayList<ListBoxDTO>> callback);
	
	
	
}
