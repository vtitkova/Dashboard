package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.HtsSearchWrapper;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>HaveToSellGWTService</code>.
 */
public interface HaveToSellGWTServiceAsync {
	public void saveOrUpdate(HaveToSellDTO entity, AsyncCallback<Integer> callback);
	
	public void findById(Integer id, AsyncCallback<HaveToSellDTO> callback);
	public void findAll(AsyncCallback<ArrayList<HaveToSellDTO> > callback);
	public void findByClientId(Integer clientId, AsyncCallback<HaveToSellDTO> callback);
	public void findByBrokerCreated(Integer brokerId, AsyncCallback<ArrayList<HaveToSellDTO> > callback);
	
	public void findMyHTS(AsyncCallback<ArrayList<HaveToSellDTO> > callback);
	public void findPartnersHTS(AsyncCallback<ArrayList<HaveToSellDTO> > callback);
	
	public void findHtsBySearchWrapperAsBroker(HtsSearchWrapper wrapper, AsyncCallback<ArrayList<HaveToSellDTO> > callback);
	public void findHtsBySearchWrapperAsAdmin(HtsSearchWrapper wrapper, AsyncCallback<ArrayList<HaveToSellDTO> > callback);
	
	public void findByIdAsBroker(Integer id, AsyncCallback<HaveToSellDTO> callback);
}
