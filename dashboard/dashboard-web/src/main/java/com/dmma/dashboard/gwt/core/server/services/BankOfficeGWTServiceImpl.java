package com.dmma.dashboard.gwt.core.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.core.entities.BankOffice;
import com.dmma.dashboard.core.services.BankOfficeService;
import com.dmma.dashboard.gwt.core.client.services.BankOfficeGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.BankOfficeMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;

/**
 * The server side implementation of the RPC service.
 */
public class BankOfficeGWTServiceImpl extends BaseGWTServiceImpl implements BankOfficeGWTService {
	private static final long serialVersionUID = 3333153923994886123L;
	private BankOfficeService bankOfficeService;
	@Override
	protected void initMe(WebApplicationContext context) {
		bankOfficeService = context.getBean("bankOfficeService",    BankOfficeService.class);
	}


	@Override
	public BankOfficeDTO findById(Integer id)  throws ObjectNotExistGError{
		BankOffice entity = bankOfficeService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return BankOfficeMapper.toDTO(entity);
	}

	@Override
	public BankOfficeDTO findByExternalId(Long externalId) {
		BankOffice office = bankOfficeService.findByExternalId(externalId);
		return BankOfficeMapper.toDTO(office);
	}


	@Override
	public ArrayList<BankOfficeDTO> findAll() {
		List<BankOffice> entities = bankOfficeService.findAll();
		return BankOfficeMapper.toDTOs(entities);
	}


	@Override
	public BankOfficeDTO getMyOffice() {
		BankerDTO loggedBanker =  getLoggedInBankerDTO();
		if(loggedBanker!=null)
			return loggedBanker.getBankOffice();
		return null;
	}


	@Override
	public Integer saveOrUpdate(BankOfficeDTO entity) throws ExternalOrMidasIdIsInUseGError {
		BankOffice bankOffice = null; 
		if(entity.getId()!=null)
			bankOffice = bankOfficeService.findById(entity.getId());
		
		if(entity.getId()==null || !entity.getExternalId().equals(bankOffice.getExternalId()))
			checkIfSomeoneElseHaveThisExternalId(entity.getExternalId());
		
		bankOffice = BankOfficeMapper.mapToEntity(entity, bankOffice);
		bankOfficeService.saveOrUpdate(bankOffice);
		return bankOffice.getId();
	}

	private void checkIfSomeoneElseHaveThisExternalId(Long externalId) throws ExternalOrMidasIdIsInUseGError {
		BankOffice existing = bankOfficeService.findByExternalId(externalId);
		if(existing!=null)
			throw new ExternalOrMidasIdIsInUseGError();
		
	}


	@Override
	public ArrayList<ListBoxDTO> findAllShort() {
		List<BankOffice> entities = bankOfficeService.findAll();
		if(entities == null) return null;
		ArrayList<ListBoxDTO> retVal = new ArrayList<ListBoxDTO>(entities.size());
		for(BankOffice entity:entities){
			ListBoxDTO dto = new ListBoxDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			retVal.add(dto);
		}
		return retVal;
	}
	
	
	
}
