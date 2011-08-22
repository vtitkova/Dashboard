package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>TipGWTService</code>.
 */
public interface TipGWTServiceAsync {
	public void saveOrUpdate(TipDTO entity, AsyncCallback<Integer> callback);
	public void saveOrUpdateForAll(TipDTO entity, AsyncCallback<Integer> callback);
	public void findByIdAsBanker(Integer id, AsyncCallback<TipDTO> callback);
	public void findByIdAsBroker(Integer id, AsyncCallback<TipDTO> callback);
	public void findByIdAsAdmin(Integer id, AsyncCallback<TipDTO> callback);
	
	public void findTipsBySearchWrapperAsBroker(TipSearchWrapper wrapper, AsyncCallback<ArrayList<TipDTO>> callback);
	public void findTipsBySearchWrapperAsBanker(TipSearchWrapper wrapper, AsyncCallback<ArrayList<TipDTO>> callback);
	public void findTipsBySearchWrapperAsAdmin(TipSearchWrapper wrapper, AsyncCallback<ArrayList<TipDTO>> callback );
	// HOME
	public void findTipsTodoAsBroker(AsyncCallback<ArrayList<TipDTO>> callback);
	public void findTipsTodoAsBanker(AsyncCallback<ArrayList<TipDTO>> callback);
}
