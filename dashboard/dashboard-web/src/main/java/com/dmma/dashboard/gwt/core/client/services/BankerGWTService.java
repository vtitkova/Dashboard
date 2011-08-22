package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisUserGError;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("BankerGWTService")
public interface BankerGWTService extends RemoteService {
	public BankerDTO            findById(Integer id) throws ObjectNotExistGError;
	public BankerDTO            findByUserId(Integer userId) throws MethodPermissionGError;
	public ArrayList<BankerDTO> findAll();
	public ArrayList<ListBoxDTO> findAllShort();
	public Integer              saveOrUpdate(BankerDTO entity, String password) throws MethodPermissionGError, ExternalOrMidasIdIsInUseGError, SomeoneElseHaveThisUserGError, EmailIsNotUniqueGError;
	public BankerDTO getMyInfo();
	public BankerDTO findByExternalId(Long externalId);
	public ArrayList<BankerDTO>  findByBankOfficeId(Integer bankOfficeId);	
	public ArrayList<ListBoxDTO> findByBankOfficeIdShort(Integer bankOfficeId);

	public ArrayList<BankerDTO> findMyRecentBankerList() throws MethodPermissionGError;
		
	 
}
