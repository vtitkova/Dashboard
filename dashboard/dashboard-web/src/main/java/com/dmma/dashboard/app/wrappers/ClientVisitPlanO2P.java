package com.dmma.dashboard.app.wrappers;

import java.util.ArrayList;

import com.dmma.base.app.o2xml.annotations.O2XAttribute;
import com.dmma.base.app.o2xml.annotations.O2XElement;

@O2XElement(nameInXml="clientVisitPlan")
public class ClientVisitPlanO2P{
	private String                     header;
	private String                     footer;
	private ClientVisitPlanHeaderO2P   clientVisitPlanHeader;
	private Boolean                    isFuture;
	//private EstateViewingO2P           estateViewing;
	//private EstateO2P                  estate;
	@O2XAttribute(listChildNameInXML="clientVisit")
	private ArrayList<ClientVisitShortO2P> clientVisits;

	public ClientVisitPlanO2P() {
	}
	
	public Boolean getIsFuture() {
		return isFuture;
	}

	public void setIsFuture(Boolean isFuture) {
		this.isFuture = isFuture;
	}

	public ArrayList<ClientVisitShortO2P> getClientVisits() {
		return clientVisits;
	}

	public void setClientVisits(ArrayList<ClientVisitShortO2P> clientVisits) {
		this.clientVisits = clientVisits;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public ClientVisitPlanHeaderO2P getClientVisitPlanHeader() {
		return clientVisitPlanHeader;
	}

	public void setClientVisitPlanHeader(ClientVisitPlanHeaderO2P clientVisitPlanHeader) {
		this.clientVisitPlanHeader = clientVisitPlanHeader;
	}
}
