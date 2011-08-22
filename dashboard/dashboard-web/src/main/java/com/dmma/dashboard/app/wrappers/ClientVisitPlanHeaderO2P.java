package com.dmma.dashboard.app.wrappers;

import java.util.Date;

import com.dmma.base.app.clazz.Time;
import com.dmma.base.app.o2xml.annotations.O2XElement;

@O2XElement(nameInXml="clientVisitPlanHeader")
public class ClientVisitPlanHeaderO2P{
	private String   estate;
	private String   broker;
	private Date     viewingDate;
	private Time     viewingStart;
	private Time     viewingEnd;
	
	public ClientVisitPlanHeaderO2P() {
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public Date getViewingDate() {
		return viewingDate;
	}

	public void setViewingDate(Date viewingDate) {
		this.viewingDate = viewingDate;
	}

	public Time getViewingStart() {
		return viewingStart;
	}

	public void setViewingStart(Time viewingStart) {
		this.viewingStart = viewingStart;
	}

	public Time getViewingEnd() {
		return viewingEnd;
	}

	public void setViewingEnd(Time viewingEnd) {
		this.viewingEnd = viewingEnd;
	}
	
	
}
