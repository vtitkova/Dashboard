package com.dmma.dashboard.gwt.core.client.services;


import java.util.ArrayList;

import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.wrappers.UserSearchWrapper;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("UserGWTService")
public interface UserGWTService extends RemoteService {
	public UserDTO            findById(Integer id)   throws ObjectNotExistGError;
	public ArrayList<UserDTO> findAll() throws MethodPermissionGError;
	public Integer            saveOrUpdate(UserDTO entity) throws MethodPermissionGError, EmailIsNotUniqueGError;
	public Boolean changeMyPassword(String oldPassword, String newPassword);
	public ArrayList<UserDTO> findByUserSearchWrapper(UserSearchWrapper wrapper) throws MethodPermissionGError;
	public Boolean isUserAdmin(Integer userId)     throws MethodPermissionGError;
	public Boolean setUserIsAdmin(Integer userId, Boolean isAdmin) throws MethodPermissionGError, ObjectNotExistGError;
	
}
