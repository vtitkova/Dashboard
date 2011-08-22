package com.dmma.dashboard.gwt.core.client.services;


import java.util.ArrayList;

import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.base.gwt.shared.errors.ObjectPermissionGError;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.TipSearchWrapper;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("TipGWTService")
public interface TipGWTService extends RemoteService {
	public Integer saveOrUpdate(TipDTO entity) throws MethodPermissionGError;
	public Integer saveOrUpdateForAll(TipDTO entity);
	public TipDTO  findByIdAsBanker(Integer id) throws MethodPermissionGError, ObjectNotExistGError, ObjectPermissionGError;
	public TipDTO  findByIdAsBroker(Integer id) throws MethodPermissionGError, ObjectNotExistGError, ObjectPermissionGError;
	public TipDTO  findByIdAsAdmin(Integer id)  throws MethodPermissionGError, ObjectNotExistGError;
	
	public ArrayList<TipDTO> findTipsBySearchWrapperAsBroker(TipSearchWrapper wrapper) throws MethodPermissionGError;
	public ArrayList<TipDTO> findTipsBySearchWrapperAsBanker(TipSearchWrapper wrapper) throws MethodPermissionGError;
	public ArrayList<TipDTO> findTipsBySearchWrapperAsAdmin(TipSearchWrapper wrapper ) throws MethodPermissionGError;
	// HOME
	public ArrayList<TipDTO> findTipsTodoAsBroker() throws MethodPermissionGError;
	public ArrayList<TipDTO> findTipsTodoAsBanker() throws MethodPermissionGError;

	
}
