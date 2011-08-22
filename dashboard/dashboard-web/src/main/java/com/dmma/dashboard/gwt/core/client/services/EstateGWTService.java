package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.errors.SynhronizationGError;
import com.dmma.dashboard.gwt.core.shared.errors.ThatIsNotBrokersEstateGError;
import com.dmma.dashboard.gwt.core.shared.errors.ThisEstateisRegisteredGError;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("EstateGWTService")
public interface EstateGWTService extends RemoteService {
	public EstateDTO findByIdAsBroker(Integer id)  throws MethodPermissionGError, ObjectNotExistGError, ObjectPermissionGError;
	public EstateDTO findByIdAsAdmin(Integer id)   throws MethodPermissionGError, ObjectNotExistGError;
	public ArrayList<EstateDTO> getMyEstates() throws MethodPermissionGError;
	public EstateDTO getMyEstateFromMidas(Long estateMidasId)                          throws ThatIsNotBrokersEstateGError, MethodPermissionGError, ThisEstateisRegisteredGError;
	public EstateDTO getBrokersEstateFromMidas(Long estateMidasId, Long brokerMidasId) throws ThatIsNotBrokersEstateGError, MethodPermissionGError, ThisEstateisRegisteredGError;
	public Integer   saveMyEstateFromMidas(EstateDTO estate)                           throws MethodPermissionGError, ThisEstateisRegisteredGError;
	public ArrayList<EstateDTO>  findEstateBySearchWrapper(EstateSearchWrapper wrapper )   throws MethodPermissionGError;
	public ArrayList<EstateDTO>  findEstateBySearchWrapperForAll(EstateSearchWrapper wrapper);
	public ArrayList<ListBoxDTO> findEstateBySearchWrapperShort(EstateSearchWrapper wrapper )   throws MethodPermissionGError;
	public ArrayList<EstateDTO>  findMyEstateBySearchWrapper(EstateSearchWrapper wrapper ) throws MethodPermissionGError;
	public EstateDTO synhronizeEstateById(Integer id) throws MethodPermissionGError, ObjectNotExistGError, SynhronizationGError;
	
}
