package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.dashboard.core.entities.User;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;

public class UserMapper {

	public static UserDTO toDTO(User entity){
		if(entity == null) return null;
		
		UserDTO dto = new UserDTO();
		dto.setId(       entity.getId());
		dto.setBrokerMidasId(entity.getBrokerMidasId());
		dto.setBankerExternalId(entity.getBankerExternalId());
		dto.setEmail(    entity.getEmail());
		dto.setTitle(    entity.getTitle());
		dto.setEnabled( entity.getEnabled());
		dto.setPassword( entity.getPassword());
		return dto;
	}
	
	public static ArrayList<UserDTO> toDTOs(List<User> entities){
		if(entities == null) return null;
		ArrayList<UserDTO> retVal = new ArrayList<UserDTO>(entities.size());
		
		for(User entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static User mapToEntity(UserDTO dto, User entity){
		if(entity==null){
			entity = new User();
		}
		
		entity.setBrokerMidasId(   dto.getBrokerMidasId());
		entity.setBankerExternalId(dto.getBankerExternalId());
		entity.setEmail(    dto.getEmail());
		entity.setTitle(    dto.getTitle());
		entity.setEnabled(  dto.getEnabled());
		entity.setPassword( dto.getPassword());
		return entity;
	}
	
	
}
