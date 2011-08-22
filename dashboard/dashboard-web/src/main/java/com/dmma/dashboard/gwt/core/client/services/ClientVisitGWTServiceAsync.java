package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.ClientVisitDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitPlanDTOW;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.UnfinalyzedViewingDTOW;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ViewingAndVisitsDTOW;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>ClientVisitGWTService</code>.
 */
public interface ClientVisitGWTServiceAsync {
	public void findById(Integer id, AsyncCallback<ClientVisitDTO> callback);
	public void findFutureViewingAndVisits(Integer estateId, AsyncCallback<ArrayList<ViewingAndVisitsDTOW>> callback);
	public void findPastViewingAndVisits(Integer estateId, AsyncCallback<ArrayList<ViewingAndVisitsDTOW>> callback);

	public void getClientVisitPlanAsAdmin(Integer  viewingId, AsyncCallback<ClientVisitPlanDTOW> callback); 
	public void getClientVisitPlanAsBroker(Integer viewingId, AsyncCallback<ClientVisitPlanDTOW> callback);

	public void saveOrUpdate(ClientVisitDTO entity,  AsyncCallback<Integer> callback);
	public void saveOrUpdateDTOS(ClientVisitDTOS entity, AsyncCallback<ClientVisitDTOS> callback);
	public void findUnfinalyzedViewings(AsyncCallback<ArrayList<UnfinalyzedViewingDTOW>> callback);
	public void findUnfinalyzedViewingsAsAdmin(Integer brokerId, AsyncCallback<ArrayList<UnfinalyzedViewingDTOW>> callback);

}
