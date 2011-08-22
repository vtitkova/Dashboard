package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;

public class EstateMapper {

	public static EstateDTO toDTO(Estate source){
		if(source == null) return null;
		
		EstateDTO target = new EstateDTO();
		
		target.setId(          source.getId());
		target.setMidasId(     source.getMidasId());
		target.setFinnCode(    source.getFinnCode());
		target.setOrderNumber( source.getOrderNumber());
		target.setStatus(      source.getStatus());
		target.setTitle(       source.getTitle());
		target.setAddress(     source.getAddress());
		target.setPostCode(    source.getPostCode());
		target.setPostCity(    source.getPostCity());
		target.setGnr(         source.getGnr());
		target.setBnr(         source.getBnr());
		target.setBroker(      source.getBroker()==null?null:BrokerMapper.toDTO(source.getBroker()));
		target.setEstateViewings(EstateViewingMapper.toDTOs(source.getEstateViewings()));
		return target;
	}
	
	public static ArrayList<EstateDTO> toDTOs(List<Estate> entities){
		if(entities == null) return null;
		ArrayList<EstateDTO> retVal = new ArrayList<EstateDTO>(entities.size());
		
		for(Estate entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static ArrayList<ListBoxDTO> toShortDTOs(List<Estate> entities) {
		if(entities == null) return null;
		ArrayList<ListBoxDTO> retVal = new ArrayList<ListBoxDTO>(entities.size());
		for(Estate entity : entities){
			ListBoxDTO dto = new ListBoxDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getTitle());
			retVal.add(dto);
		}
		return retVal;
	}
	
	public static Estate mapToEntity(EstateDTO source, Estate target){
		if(target==null){
			target = new Estate();
		}
		//target.setId(          source.getId());
		target.setMidasId(     source.getMidasId());
		target.setFinnCode(    source.getFinnCode());
		target.setOrderNumber( source.getOrderNumber());
		target.setStatus(      source.getStatus());
		target.setTitle(       source.getTitle());
		target.setAddress(     source.getAddress());
		target.setPostCode(    source.getPostCode());
		target.setPostCity(    source.getPostCity());
		target.setGnr(         source.getGnr());
		target.setBnr(         source.getBnr());
		//WE ARE NOT MAPPING THE BROKER AND VIEWINGS entities
		//target.setBroker(      source.getBroker()==null?null:BrokerMapper.toDTO(source.getBroker()));
		//target.setEstateViewings(EstateViewingMapper.toDTOs(source.getEstateViewings()));
		return target;
		
		
	}
	public static Estate mapToEntity(Estate source, Estate target){
		if(target==null){
			target = new Estate();
		}
		//target.setId(          source.getId());
		target.setMidasId(     source.getMidasId());
		target.setFinnCode(    source.getFinnCode());
		target.setOrderNumber( source.getOrderNumber());
		target.setStatus(      source.getStatus());
		target.setTitle(       source.getTitle());
		target.setAddress(     source.getAddress());
		target.setPostCode(    source.getPostCode());
		target.setPostCity(    source.getPostCity());
		target.setGnr(         source.getGnr());
		target.setBnr(         source.getBnr());
		//WE ARE NOT MAPPING THE BROKER AND VIEWINGS entities
		//target.setBroker(      source.getBroker()==null?null:BrokerMapper.toDTO(source.getBroker()));
		//target.setEstateViewings(EstateViewingMapper.toDTOs(source.getEstateViewings()));
		return target;
		
		
	}
	
	
}
