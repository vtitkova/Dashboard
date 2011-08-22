package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.core.entities.Banker;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;

public class BankerMapper {

	public static BankerDTO toDTO(Banker source){
		if(source == null) return null;
		BankerDTO target = new BankerDTO();
		target.setId(         source.getId());
		target.setExternalId( source.getExternalId());
		target.setUserId(     source.getUserId());
		target.setName(       source.getName());
		target.setSurname(    source.getSurname());
		target.setEmail(      source.getEmail());
		target.setPhone(      source.getPhone());
		target.setCellPhone(  source.getCellPhone());
		target.setAvco(       source.getAvco());
		target.setBankOffice( source.getBankOffice()==null?null:BankOfficeMapper.toDTO(source.getBankOffice()));
		return target;
	}
	
	public static ArrayList<BankerDTO> toDTOs(List<Banker> entities){
		if(entities == null) return null;
		ArrayList<BankerDTO> retVal = new ArrayList<BankerDTO>(entities.size());
		
		for(Banker entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static ArrayList<ListBoxDTO> toShortDTOs(List<Banker> entities) {
		if(entities == null) return null;
		ArrayList<ListBoxDTO> retVal = new ArrayList<ListBoxDTO>(entities.size());
		for(Banker entity : entities){
			ListBoxDTO dto = new ListBoxDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			retVal.add(dto);
		}
		return retVal;
	}

	
	public static Banker mapToEntity(BankerDTO source, Banker target){
		if(target==null){
			target = new Banker();
		}
		//target.setId(         source.getId());
		target.setExternalId( source.getExternalId());
		target.setUserId(     source.getUserId());
		target.setName(       source.getName());
		target.setSurname(    source.getSurname());
		target.setEmail(      source.getEmail());
		target.setPhone(      source.getPhone());
		target.setCellPhone(  source.getCellPhone());
		target.setAvco(       source.getAvco());
		//WE ARE NOT MAPPING THE OFFICE entity
		return target;
	}
}
