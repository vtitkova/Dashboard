package com.dmma.dashboard.gwt.core.client.services;


import java.util.ArrayList;

import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.HtsSearchWrapper;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

 /**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("HaveToSellGWTService")
public interface HaveToSellGWTService extends RemoteService {
	public Integer saveOrUpdate(HaveToSellDTO entity) throws MethodPermissionGError, ObjectNotExistGError;
	
	public HaveToSellDTO            findById(Integer id)  throws MethodPermissionGError, ObjectNotExistGError;
	public ArrayList<HaveToSellDTO> findAll() throws MethodPermissionGError;
	public HaveToSellDTO            findByClientId(Integer clientId);
	public ArrayList<HaveToSellDTO> findByBrokerCreated(Integer brokerId);
	
	public ArrayList<HaveToSellDTO> findMyHTS()       throws MethodPermissionGError;
	public ArrayList<HaveToSellDTO> findPartnersHTS() throws MethodPermissionGError;
	
	public  ArrayList<HaveToSellDTO> findHtsBySearchWrapperAsBroker(HtsSearchWrapper wrapper) throws MethodPermissionGError;
	public  ArrayList<HaveToSellDTO> findHtsBySearchWrapperAsAdmin(HtsSearchWrapper wrapper) throws MethodPermissionGError;

	public HaveToSellDTO findByIdAsBroker(Integer id) throws MethodPermissionGError, ObjectNotExistGError, ObjectPermissionGError;
}
