package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.dashboard.core.entities.BankOffice;
import com.dmma.dashboard.gwt.core.shared.entities.BankOfficeDTO;

public class BankOfficeMapper {

	public static BankOfficeDTO toDTO(BankOffice source){
		if(source == null) return null;
		BankOfficeDTO target = new BankOfficeDTO();
		target.setId(        source.getId());
		target.setExternalId(source.getExternalId());
		target.setName(      source.getName());
		target.setAddress(   source.getAddress());
		target.setZip(       source.getZip());
		target.setCity(      source.getCity());
		target.setPhone(     source.getPhone());
		target.setEmail(     source.getEmail());
		return target;
	}
	
	public static ArrayList<BankOfficeDTO> toDTOs(List<BankOffice> entities){
		if(entities == null) return null;
		ArrayList<BankOfficeDTO> retVal = new ArrayList<BankOfficeDTO>(entities.size());
		
		for(BankOffice entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static BankOffice mapToEntity(BankOfficeDTO source, BankOffice target){
		if(target==null){
			target = new BankOffice();
		}
		target.setExternalId(source.getExternalId());
		target.setName(      source.getName());
		target.setAddress(   source.getAddress());
		target.setZip(       source.getZip());
		target.setCity(      source.getCity());
		target.setPhone(     source.getPhone());
		target.setEmail(     source.getEmail());
		return target;
	}
	
}
