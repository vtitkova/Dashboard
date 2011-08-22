package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisPhoneGError;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("ClientGWTService")
public interface ClientGWTService extends RemoteService {
	public ClientDTO            findById(Integer id) throws ObjectNotExistGError;
	public Integer              saveOrUpdate(ClientDTO entity) throws SomeoneElseHaveThisPhoneGError;
	public ArrayList<ClientDTO> findAll()    throws MethodPermissionGError;
	public ArrayList<Integer>   findAllIDs() throws MethodPermissionGError;
	public ClientDTO            findByPhone(String phone);
	public ArrayList<ClientDTO> findByStartsWithPhone(String phoneStart);
	public ArrayList<ListBoxDTO> findAllShort();
}
