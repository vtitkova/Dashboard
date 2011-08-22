package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>BankerGWTService</code>.
 */
public interface BankerGWTServiceAsync {
	public void findById(Integer id, AsyncCallback<BankerDTO> callback);
	public void findByUserId(Integer userId, AsyncCallback<BankerDTO> callback);
	public void findAll(AsyncCallback<ArrayList<BankerDTO>> callback);
	public void findAllShort(AsyncCallback<ArrayList<ListBoxDTO>> callback);
	public void saveOrUpdate(BankerDTO entity, String password, AsyncCallback<Integer> callback);
	
	public void getMyInfo(AsyncCallback<BankerDTO> callback);
	public void findByExternalId(Long externalId, AsyncCallback<BankerDTO> callback);
	public void findByBankOfficeId(Integer bankOfficeId, AsyncCallback<ArrayList<BankerDTO>> callback);
    public void findByBankOfficeIdShort(Integer bankOfficeId, AsyncCallback<ArrayList<ListBoxDTO>> callback);
	
    public void findMyRecentBankerList(AsyncCallback<ArrayList<BankerDTO>> callback);
	
    
}
