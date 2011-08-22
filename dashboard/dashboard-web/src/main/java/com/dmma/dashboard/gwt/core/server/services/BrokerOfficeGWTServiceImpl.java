package com.dmma.dashboard.gwt.core.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.base.gwt.shared.errors.ObjectNotExistGError;
import com.dmma.dashboard.core.entities.BrokerOffice;
import com.dmma.dashboard.core.services.BrokerOfficeService;
import com.dmma.dashboard.gwt.core.client.services.BrokerOfficeGWTService;
import com.dmma.dashboard.gwt.core.server.mapper.BrokerOfficeMapper;
import com.dmma.dashboard.gwt.core.server.services.base.BaseGWTServiceImpl;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;
import com.dmma.dashboard.gwt.core.shared.errors.ExternalOrMidasIdIsInUseGError;

/**
 * The server side implementation of the RPC service.
 */
public class BrokerOfficeGWTServiceImpl extends BaseGWTServiceImpl implements BrokerOfficeGWTService {
	private static final long serialVersionUID = 3333153923994886123L;
	private BrokerOfficeService brokerOfficeService;
	@Override
	protected void initMe(WebApplicationContext context) {
		brokerOfficeService = context.getBean("brokerOfficeService",    BrokerOfficeService.class);
	}


	@Override
	public BrokerOfficeDTO findById(Integer id) throws ObjectNotExistGError {
		BrokerOffice entity = brokerOfficeService.findById(id);
		if(entity==null) throw new ObjectNotExistGError();
		return BrokerOfficeMapper.toDTO(entity);
	}


	@Override
	public BrokerOfficeDTO findByMidasId(Long midasId) {
		BrokerOffice office = brokerOfficeService.findByMidasId(midasId);
		return BrokerOfficeMapper.toDTO(office);
	}


	@Override
	public ArrayList<BrokerOfficeDTO> findAll() {
		List<BrokerOffice> entities = brokerOfficeService.findAll();
		return BrokerOfficeMapper.toDTOs(entities);
	}


	@Override
	public BrokerOfficeDTO getMyOffice() {
		BrokerDTO loggedBroker =  getLoggedInBrokerDTO();
		if(loggedBroker!=null)
			return loggedBroker.getBrokerOffice();
		return null;
	}


	@Override
	public Integer saveOrUpdate(BrokerOfficeDTO entity) throws ExternalOrMidasIdIsInUseGError {
		BrokerOffice brokerOffice = null; 
		if(entity.getId()!=null)
			brokerOffice = brokerOfficeService.findById(entity.getId());
		
		if(entity.getId()==null || !entity.getMidasId().equals(brokerOffice.getMidasId()))
			checkIfSomeoneElseHaveThisMidasId(entity.getMidasId());
		
		brokerOffice = BrokerOfficeMapper.mapToEntity(entity, brokerOffice);
		brokerOfficeService.saveOrUpdate(brokerOffice);
		return brokerOffice.getId();
	}


	private void checkIfSomeoneElseHaveThisMidasId(Long midasId) throws ExternalOrMidasIdIsInUseGError {
		BrokerOffice existing = brokerOfficeService.findByMidasId(midasId);
		if(existing!=null)
			throw new ExternalOrMidasIdIsInUseGError();
		
	}


	@Override
	public ArrayList<ListBoxDTO> findAllShort() {
		List<BrokerOffice> entities = brokerOfficeService.findAll();
		if(entities == null) return null;
		ArrayList<ListBoxDTO> retVal = new ArrayList<ListBoxDTO>(entities.size());
		for(BrokerOffice entity:entities){
			ListBoxDTO dto = new ListBoxDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			retVal.add(dto);
		}
		return retVal;
	}

	
	
	
}
