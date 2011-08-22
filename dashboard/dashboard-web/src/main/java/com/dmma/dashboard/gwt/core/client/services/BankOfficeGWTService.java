package com.dmma.dashboard.gwt.core.client.services;

import java.util.ArrayList;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("BankOfficeGWTService")
public interface BankOfficeGWTService extends RemoteService {
	public BankOfficeDTO findById(Integer id) throws ObjectNotExistGError;
	public Integer         saveOrUpdate(BankOfficeDTO entity) throws ExternalOrMidasIdIsInUseGError;
	public BankOfficeDTO getMyOffice();
	public BankOfficeDTO findByExternalId(Long midasId);
	public ArrayList<BankOfficeDTO> findAll();
	public ArrayList<ListBoxDTO> findAllShort();
}
