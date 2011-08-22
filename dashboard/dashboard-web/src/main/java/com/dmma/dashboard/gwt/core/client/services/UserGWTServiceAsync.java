package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.UserSearchWrapper;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>UserGWTService</code>.
 */
public interface UserGWTServiceAsync {
	public void findById(Integer id, AsyncCallback<UserDTO> callback);
	public void findAll(AsyncCallback<ArrayList<UserDTO>> callback);
	public void saveOrUpdate(UserDTO entity, AsyncCallback<Integer> callback);
	public void changeMyPassword(String oldPassword, String newPassword, AsyncCallback<Boolean> callback);
	public void findByUserSearchWrapper(UserSearchWrapper wrapper, AsyncCallback<ArrayList<UserDTO>> callback);
	public void isUserAdmin(Integer userId, AsyncCallback<Boolean> callback);
	public void setUserIsAdmin(Integer userId, Boolean isAdmin, AsyncCallback<Boolean> callback);
}
