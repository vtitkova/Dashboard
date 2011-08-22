package com.dmma.dashboard.gwt.core.server.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dmma.dashboard.core.entities.Tip;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;

public class TipMapper {

	public static TipDTO toDTO(Tip source){
		if(source == null) return null;
		TipDTO target = new TipDTO();
		target.setId(               source.getId());
		target.setTipDirectionType( source.getTipDirectionType());
		target.setBroker(           source.getBroker()==null ? null : BrokerMapper.toDTO(source.getBroker()));
		target.setBanker(           source.getBanker()==null ? null : BankerMapper.toDTO(source.getBanker()));
		target.setClient(           source.getClient()==null ? null : ClientMapper.toDTO(source.getClient()));
		target.setEstate(           source.getEstate()==null ? null : EstateMapper.toDTO(source.getEstate()));
		target.setTipType(          source.getTipType());
		target.setComments(         source.getComments());
		target.setCreated(          source.getCreated());
		target.setTipStatusType(    source.getTipStatusType());
		target.setModified(         source.getModified());
		target.setStatusComments(   source.getStatusComments());
		return target;
	}
	
	public static ArrayList<TipDTO> toDTOs(List<Tip> entities){
		if(entities == null) return null;
		ArrayList<TipDTO> retVal = new ArrayList<TipDTO>(entities.size());
		
		for(Tip entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static Tip mapToEntity(TipDTO source, Tip target){
		if(target==null){
			target = new Tip();
		}
		//target.setId(         source.getId());
		target.setTipDirectionType( source.getTipDirectionType());
		target.setTipType(          source.getTipType());
		target.setComments(         source.getComments());
		target.setCreated(          source.getCreated());
		target.setTipStatusType(    source.getTipStatusType());
		target.setModified(         source.getModified());
		target.setStatusComments(   source.getStatusComments());
		//WE ARE NOT MAPPING THE DTO entity
		return target;
	}
}
