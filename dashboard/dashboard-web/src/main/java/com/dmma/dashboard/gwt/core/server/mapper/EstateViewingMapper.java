package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dmma.dashboard.core.entities.EstateViewing;
import com.dmma.dashboard.gwt.core.shared.entities.EstateViewingDTO;

public class EstateViewingMapper {

	public static EstateViewingDTO toDTO(EstateViewing source){
		if(source == null) return null;
		EstateViewingDTO target = new EstateViewingDTO();
		target.setId(       source.getId());
		target.setEstateId( source.getEstateId());
		target.setDateFrom( source.getDateFrom());
		target.setDateTo(   source.getDateTo());
		return target;
	}

	public static ArrayList<EstateViewingDTO> toDTOs(List<EstateViewing> entities){
		if(entities == null) return null;
		ArrayList<EstateViewingDTO> retVal = new ArrayList<EstateViewingDTO>(entities.size());
		
		for(EstateViewing entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static EstateViewing mapToEntity(EstateViewingDTO source, EstateViewing target){
		if(target==null){
			target = new EstateViewing();
		}
		//target.setId(       source.getId());
		target.setEstateId( source.getEstateId());
		target.setDateFrom( source.getDateFrom());
		target.setDateTo(   source.getDateTo());
		return target;
	}
	
	public static List<EstateViewing> mapToNewEntities(List<EstateViewingDTO> dtos){
		if(dtos == null) return null;
		ArrayList<EstateViewing> retVal = new ArrayList<EstateViewing>(dtos.size());
		
		for(EstateViewingDTO dto:dtos){
			retVal.add(mapToEntity(dto, null));
		}
		return retVal;
	}
	
	
	public static List<EstateViewing> extendExistingViewings(List<EstateViewing> existing, List<EstateViewing> newViewings){
		if(newViewings != null && !newViewings.isEmpty()){
			if(existing==null) existing = new ArrayList<EstateViewing>(newViewings.size());
			for(EstateViewing newViewing : newViewings){
				if(!alreadyExist(newViewing, existing)){
					existing.add(newViewing);
				}
			}
		}
		return existing;
	}


	
	
	private static boolean alreadyExist(EstateViewing value, List<EstateViewing> existing){
		for(EstateViewing current : existing){
			if(isEquals(value, current))
				return true;
		}
		return false;
	}
	
	
	private static boolean isEquals(EstateViewing a, EstateViewing b){
		Date df = a.getDateFrom();
		Date dt = a.getDateTo();
		//FIXME proveritj na null
		if( !df.equals(b.getDateFrom()))
			return false;
		
		if( ! dt.equals(b.getDateTo()))
			return false;
		
		
		return true;
	}





	
	
}
