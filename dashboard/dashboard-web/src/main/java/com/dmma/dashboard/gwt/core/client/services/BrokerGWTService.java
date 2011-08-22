package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.MethodPermissionGError;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.errors.EmailIsNotUniqueGError;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.dmma.dashboard.gwt.core.shared.errors.SomeoneElseHaveThisUserGError;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("BrokerGWTService")
public interface BrokerGWTService extends RemoteService {
	public BrokerDTO            findById(Integer id) throws ObjectNotExistGError;
	public BrokerDTO            findByUserId(Integer userId) throws MethodPermissionGError;
	public ArrayList<BrokerDTO> findAll();
	public ArrayList<ListBoxDTO> findAllShort();
	public Integer              saveOrUpdate(BrokerDTO entity, String password) throws ExternalOrMidasIdIsInUseGError, SomeoneElseHaveThisUserGError, EmailIsNotUniqueGError;
	public BrokerDTO getMyInfo();
	public BrokerDTO findByMidasId(Long midasId);
	public ArrayList<BrokerDTO> findByBrokerOfficeId(Integer brokerOfficeId);
	public ArrayList<ListBoxDTO> findByBrokerOfficeIdShort(Integer brokerOfficeId);

	public ArrayList<BrokerDTO> findMyRecentBrokerList() throws MethodPermissionGError;
	
}
