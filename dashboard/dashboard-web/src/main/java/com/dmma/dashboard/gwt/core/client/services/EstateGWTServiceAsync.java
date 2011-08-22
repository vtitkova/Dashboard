package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>EstateGWTService</code>.
 */
public interface EstateGWTServiceAsync {
	public void findByIdAsBroker(Integer id, AsyncCallback<EstateDTO> callback);
	public void findByIdAsAdmin(Integer id, AsyncCallback<EstateDTO> callback);
	public void getMyEstates(AsyncCallback<ArrayList<EstateDTO>> callback);
	public void getMyEstateFromMidas(Long estateMidasId, AsyncCallback<EstateDTO> callback);
	public void getBrokersEstateFromMidas(Long estateMidasId, Long brokerMidasId, AsyncCallback<EstateDTO> callback);
	public void saveMyEstateFromMidas(EstateDTO estate, AsyncCallback<Integer> callback);
	public void findEstateBySearchWrapper(EstateSearchWrapper wrapper, AsyncCallback<ArrayList<EstateDTO>> callback);
	public void findEstateBySearchWrapperForAll(EstateSearchWrapper wrapper, AsyncCallback<ArrayList<EstateDTO>> callback);
	public void findEstateBySearchWrapperShort(EstateSearchWrapper wrapper, AsyncCallback<ArrayList<ListBoxDTO>> callback);
	public void findMyEstateBySearchWrapper(EstateSearchWrapper wrapper, AsyncCallback<ArrayList<EstateDTO>> callback);
	public void synhronizeEstateById(Integer id, AsyncCallback<EstateDTO> callback);
	
}
