package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.core.entities.Broker;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;

public class BrokerMapper {

	public static BrokerDTO toDTO(Broker source){
		if(source == null) return null;

		BrokerDTO target = new BrokerDTO();

		target.setId(       source.getId());
		target.setMidasId(  source.getMidasId());
		target.setUserId(   source.getUserId());
		target.setName(     source.getName());
		target.setSurname(  source.getSurname());
		target.setEmail(    source.getEmail());
		target.setPhone(    source.getPhone());
		target.setCellPhone(source.getCellPhone());
		target.setAvco(     source.getAvco());
		target.setBrokerOffice( source.getBrokerOffice()==null?null:BrokerOfficeMapper.toDTO(source.getBrokerOffice()));
		return target;
	}

	public static ArrayList<BrokerDTO> toDTOs(List<Broker> entities){
		if(entities == null) return null;
		ArrayList<BrokerDTO> retVal = new ArrayList<BrokerDTO>(entities.size());

		for(Broker entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}

	public static ArrayList<ListBoxDTO> toShortDTOs(List<Broker> entities) {
		if(entities == null) return null;
		ArrayList<ListBoxDTO> retVal = new ArrayList<ListBoxDTO>(entities.size());
		for(Broker entity : entities){
			ListBoxDTO dto = new ListBoxDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			retVal.add(dto);
		}
		return retVal;
	}

	public static Broker mapToEntity(BrokerDTO source, Broker target){
		if(target==null){
			target = new Broker();
		}
		//target.setId(      source.getId());
		target.setMidasId(   source.getMidasId());
		target.setUserId(    source.getUserId());
		target.setName(      source.getName());
		target.setSurname(   source.getSurname());
		target.setEmail(     source.getEmail());
		target.setPhone(     source.getPhone());
		target.setCellPhone( source.getCellPhone());
		target.setAvco(      source.getAvco());
		//WE ARE NOT MAPPING THE OFFICE entity
		return target;
	}


}
