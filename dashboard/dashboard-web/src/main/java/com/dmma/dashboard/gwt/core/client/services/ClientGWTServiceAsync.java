package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>ClientGWTService</code>.
 */
public interface ClientGWTServiceAsync {
	public void findById(Integer id, AsyncCallback<ClientDTO> callback);
	public void saveOrUpdate(ClientDTO entity, AsyncCallback<Integer> callback);
	public void findAll(AsyncCallback<ArrayList<ClientDTO>> callback);
	public void findAllIDs(AsyncCallback<ArrayList<Integer>> callback);
	public void findByPhone(String phone, AsyncCallback<ClientDTO> callback);
	public void findByStartsWithPhone(String phoneStart, AsyncCallback<ArrayList<ClientDTO>> callback);
	public void findAllShort(AsyncCallback<ArrayList<ListBoxDTO>> callback);
}
