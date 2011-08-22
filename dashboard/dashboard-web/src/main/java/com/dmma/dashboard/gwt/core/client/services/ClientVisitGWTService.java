package com.dmma.dashboard.gwt.core.client.services;


import java.util.ArrayList;

import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.gwt.core.shared.entities.ClientVisitDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitPlanDTOW;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.UnfinalyzedViewingDTOW;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ViewingAndVisitsDTOW;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

 /**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("ClientVisitGWTService")
public interface ClientVisitGWTService extends RemoteService {
	public ClientVisitDTO   findById(Integer id)  throws MethodPermissionGError, ObjectPermissionGError, ObjectNotExistGError;
	public ArrayList<ViewingAndVisitsDTOW> findFutureViewingAndVisits(Integer estateId);
	public ArrayList<ViewingAndVisitsDTOW> findPastViewingAndVisits(Integer estateId);

	public ClientVisitPlanDTOW getClientVisitPlanAsAdmin(Integer  viewingId) throws MethodPermissionGError, ObjectNotExistGError;
	public ClientVisitPlanDTOW getClientVisitPlanAsBroker(Integer viewingId) throws MethodPermissionGError, ObjectPermissionGError, ObjectNotExistGError;
	
	public Integer saveOrUpdate(ClientVisitDTO entity) throws MethodPermissionGError, ObjectNotExistGError;
	public ClientVisitDTOS saveOrUpdateDTOS(ClientVisitDTOS entity) throws MethodPermissionGError;
	
	public ArrayList<UnfinalyzedViewingDTOW> findUnfinalyzedViewings() throws MethodPermissionGError;
	public ArrayList<UnfinalyzedViewingDTOW> findUnfinalyzedViewingsAsAdmin(Integer brokerId) throws MethodPermissionGError;

}
