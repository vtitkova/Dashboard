package com.dmma.dashboard.gwt.core.shared.entities.wrappers;

import java.util.ArrayList;

import com.dmma.dashboard.gwt.core.shared.entities.EstateViewingDTO;
import com.google.gwt.user.client.rpc.IsSerializable;


public class ViewingAndVisitsDTOW implements IsSerializable{

	private EstateViewingDTO           estateViewing;
	private ArrayList<ClientVisitDTOS> clientVisits;
	
	public ViewingAndVisitsDTOW() {
	}

	public EstateViewingDTO getEstateViewing() {
		return estateViewing;
	}

	public void setEstateViewing(EstateViewingDTO estateViewing) {
		this.estateViewing = estateViewing;
	}

	public ArrayList<ClientVisitDTOS> getClientVisits() {
		return clientVisits;
	}

	public void setClientVisits(ArrayList<ClientVisitDTOS> clientVisits) {
		this.clientVisits = clientVisits;
	}
	
	
	
}
