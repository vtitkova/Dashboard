package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.dashboard.core.entities.HaveToSell;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;

public class HaveToSellMapper {

	public static HaveToSellDTO toDTO(HaveToSell entity){
		if(entity == null) return null;
		
		HaveToSellDTO dto = new HaveToSellDTO();
		dto.setId(entity.getId());
		dto.setParrentId(entity.getParrentId());

		dto.setCreated(entity.getCreated());
		dto.setActiveFrom(entity.getActiveFrom());
		
		dto.setClient( ClientMapper.toDTO(entity.getClient()));
		dto.setClientVisitId(entity.getClientVisitId());
		
		dto.setDefaultBroker(BrokerMapper.toDTO(entity.getDefaultBroker()));

		dto.setProcessedDate(entity.getProcessedDate());
		dto.setProcessedBy(BrokerMapper.toDTO(entity.getProcessedBy()));
		dto.setProcessedComments(entity.getProcessedComments());
		dto.setWantsToSell(entity.getWantsToSell());
		return dto;
	}
	
	public static ArrayList<HaveToSellDTO> toDTOs(List<HaveToSell> entities){
		if(entities == null) return null;
		ArrayList<HaveToSellDTO> retVal = new ArrayList<HaveToSellDTO>(entities.size());
		for(HaveToSell entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}

	
	public static HaveToSell mapToEntity(HaveToSellDTO source, HaveToSell target) {
		if(target==null){
			target = new HaveToSell();
		}
		//target.setId(         source.getId());
		target.setParrentId(         source.getParrentId());
		target.setCreated(        source.getCreated());
		target.setActiveFrom(  source.getActiveFrom());
		
		target.setClientVisitId(     source.getClientVisitId());

		target.setProcessedDate( source.getProcessedDate());
		target.setProcessedComments(  source.getProcessedComments());
		target.setWantsToSell( source.getWantsToSell());
		
		//WE ARE NOT MAPPING THE DTO entity
		//private ClientO2P client;
		//private BrokerO2P defaultBroker;
		//private BrokerO2P processedBy;

		return target;
	}
	
	
	
	
}
