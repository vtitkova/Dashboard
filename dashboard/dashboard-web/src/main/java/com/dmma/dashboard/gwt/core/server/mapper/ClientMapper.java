package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.dashboard.core.entities.Client;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;

public class ClientMapper {

	public static ClientDTO toDTO(Client entity){
		if(entity == null) return null;
		
		ClientDTO dto = new ClientDTO();
		dto.setId(       entity.getId());
		dto.setName(     entity.getName());
		dto.setSurname(  entity.getSurname());
		dto.setEmail(    entity.getEmail());
		dto.setPhone(    entity.getPhone());
		dto.setComments( entity.getComments());
		return dto;
	}
	
	public static ArrayList<ClientDTO> toDTOs(List<Client> entities){
		if(entities == null) return null;
		ArrayList<ClientDTO> retVal = new ArrayList<ClientDTO>(entities.size());
		
		for(Client entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static Client mapToEntity(ClientDTO dto, Client entity){
		if(entity==null){
			entity = new Client();
		}
		entity.setName(     dto.getName());
		entity.setSurname(  dto.getSurname());
		entity.setEmail(    dto.getEmail());
		entity.setPhone(    dto.getPhone());
		entity.setComments( dto.getComments());
		return entity;
	}
	
	
}
