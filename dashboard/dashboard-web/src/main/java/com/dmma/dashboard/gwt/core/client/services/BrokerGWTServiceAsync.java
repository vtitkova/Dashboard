package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>BrokerGWTService</code>.
 */
public interface BrokerGWTServiceAsync {
	public void findById(Integer id, AsyncCallback<BrokerDTO> callback);
	public void findByUserId(Integer userId, AsyncCallback<BrokerDTO> callback);
	public void findAll(AsyncCallback<ArrayList<BrokerDTO>> callback);
	public void findAllShort(AsyncCallback<ArrayList<ListBoxDTO>> callback);
	public void saveOrUpdate(BrokerDTO entity, String password, AsyncCallback<Integer> callback);
	
	public void getMyInfo(AsyncCallback<BrokerDTO> callback);
	public void findByMidasId(Long midasId, AsyncCallback<BrokerDTO> callback);
	public void findByBrokerOfficeId(Integer brokerOfficeId, AsyncCallback<ArrayList<BrokerDTO>> callback);
    public void findByBrokerOfficeIdShort(Integer brokerOfficeId, AsyncCallback<ArrayList<ListBoxDTO>> callback);

    public void findMyRecentBrokerList(AsyncCallback<ArrayList<BrokerDTO>> callback);
	
}
