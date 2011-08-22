package com.dmma.dashboard.gwt.core.shared.entities.wrappers;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateViewingDTO;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ClientVisitPlanDTOW implements IsSerializable{
	private EstateViewingDTO           estateViewing;
	private Boolean                    isFuture;
	private EstateDTO                  estate;
	private ArrayList<ClientVisitDTOS> clientVisits;

	public ClientVisitPlanDTOW() {
	}

	public EstateViewingDTO getEstateViewing() {
		return estateViewing;
	}

	public void setEstateViewing(EstateViewingDTO estateViewing) {
		this.estateViewing = estateViewing;
	}

	public Boolean getIsFuture() {
		return isFuture;
	}

	public void setIsFuture(Boolean isFuture) {
		this.isFuture = isFuture;
	}

	public EstateDTO getEstate() {
		return estate;
	}

	public void setEstate(EstateDTO estate) {
		this.estate = estate;
	}

	public ArrayList<ClientVisitDTOS> getClientVisits() {
		return clientVisits;
	}

	public void setClientVisits(ArrayList<ClientVisitDTOS> clientVisits) {
		this.clientVisits = clientVisits;
	}
}
