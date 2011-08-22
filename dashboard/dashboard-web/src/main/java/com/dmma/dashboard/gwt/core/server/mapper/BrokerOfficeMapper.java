package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.dashboard.core.entities.BrokerOffice;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerOfficeDTO;

public class BrokerOfficeMapper {

	public static BrokerOfficeDTO toDTO(BrokerOffice entity){
		if(entity == null) return null;
		BrokerOfficeDTO dto = new BrokerOfficeDTO();
		dto.setId(      entity.getId());
		dto.setMidasId( entity.getMidasId());
		dto.setName(    entity.getName());
		dto.setAddress( entity.getAddress());
		dto.setZip(     entity.getZip());
		dto.setCity(    entity.getCity());
		dto.setPhone(   entity.getPhone());
		dto.setEmail(   entity.getEmail());
		return dto;
	}
	
	public static ArrayList<BrokerOfficeDTO> toDTOs(List<BrokerOffice> entities){
		if(entities == null) return null;
		ArrayList<BrokerOfficeDTO> retVal = new ArrayList<BrokerOfficeDTO>(entities.size());
		
		for(BrokerOffice entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static BrokerOffice mapToEntity(BrokerOfficeDTO dto, BrokerOffice entity){
		if(entity==null){
			entity = new BrokerOffice();
		}
		entity.setMidasId(  dto.getMidasId());
		entity.setName(     dto.getName());
		entity.setAddress(  dto.getAddress());
		entity.setZip(      dto.getZip());
		entity.setCity(     dto.getCity());
		entity.setPhone(    dto.getPhone());
		entity.setEmail(    dto.getEmail());
		return entity;
	}
	
}
