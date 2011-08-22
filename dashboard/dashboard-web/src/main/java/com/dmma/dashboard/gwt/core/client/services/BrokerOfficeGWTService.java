package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("BrokerOfficeGWTService")
public interface BrokerOfficeGWTService extends RemoteService {
	public BrokerOfficeDTO findById(Integer id) throws ObjectNotExistGError;
	public Integer         saveOrUpdate(BrokerOfficeDTO entity) throws ExternalOrMidasIdIsInUseGError;
	public BrokerOfficeDTO getMyOffice();
	public BrokerOfficeDTO findByMidasId(Long midasId);
	public ArrayList<BrokerOfficeDTO> findAll();
	public ArrayList<ListBoxDTO> findAllShort();
	
}
