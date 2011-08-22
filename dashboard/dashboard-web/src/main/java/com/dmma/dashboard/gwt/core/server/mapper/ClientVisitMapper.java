package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.dashboard.core.entities.ClientVisit;
import com.dmma.dashboard.gwt.core.shared.entities.ClientVisitDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;

public class ClientVisitMapper {

	public static ClientVisitDTO toDTO(ClientVisit entity){
		if(entity == null) return null;
		
		ClientVisitDTO dto = new ClientVisitDTO();
		dto.setId(entity.getId());
		dto.setClient( ClientMapper.toDTO(entity.getClient()));
		dto.setCreated(entity.getCreated());
		dto.setEstate(EstateMapper.toDTO(entity.getEstate()));
		dto.setEstateViewing(EstateViewingMapper.toDTO(entity.getEstateViewing()));
		dto.setStatus(entity.getStatus());
		dto.setComments(entity.getComments());
		return dto;
	}
	
	public static ClientVisitDTOS toDTOS(ClientVisit entity){
		if(entity == null) return null;
		
		ClientVisitDTOS dto = new ClientVisitDTOS();
		dto.setId(entity.getId());
		dto.setClient( ClientMapper.toDTO(entity.getClient()));
		dto.setCreated(entity.getCreated());
		dto.setEstateId(entity.getEstate().getId());
		dto.setEstateViewingId(entity.getEstateViewing().getId());
		dto.setStatus(entity.getStatus());
		dto.setComments(entity.getComments());
		return dto;
	}
	
	public static ArrayList<ClientVisitDTO> toDTOs(List<ClientVisit> entities){
		if(entities == null) return null;
		ArrayList<ClientVisitDTO> retVal = new ArrayList<ClientVisitDTO>(entities.size());
		for(ClientVisit entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static ArrayList<ClientVisitDTOS> toDTOSs(List<ClientVisit> entities){
		if(entities == null) return null;
		ArrayList<ClientVisitDTOS> retVal = new ArrayList<ClientVisitDTOS>(entities.size());
		for(ClientVisit entity:entities){
			retVal.add(toDTOS(entity));
		}
		return retVal;
	}
	
	
	
	
}
