package com.dmma.dashboard.gwt.core.shared.entities.wrappers;

import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateViewingDTO;
import com.google.gwt.user.client.rpc.IsSerializable;

public class UnfinalyzedViewingDTOW implements IsSerializable{
	private EstateDTO estate;
	private EstateViewingDTO estateViewing;
	private Integer unknownStatusAmount;
	
	
	public UnfinalyzedViewingDTOW() {
	}


	public EstateDTO getEstate() {
		return estate;
	}


	public void setEstate(EstateDTO estate) {
		this.estate = estate;
	}


	public EstateViewingDTO getEstateViewing() {
		return estateViewing;
	}


	public void setEstateViewing(EstateViewingDTO estateViewing) {
		this.estateViewing = estateViewing;
	}


	public Integer getUnknownStatusAmount() {
		return unknownStatusAmount;
	}


	public void setUnknownStatusAmount(Integer unknownStatusAmount) {
		this.unknownStatusAmount = unknownStatusAmount;
	}
	
	
}
