package com.dmma.dashboard.app.wrappers;

import com.dmma.base.app.clazz.DateTime;
import com.dmma.base.app.clazz.Time;
import com.dmma.base.app.o2xml.annotations.O2XElement;
import com.dmma.dashboard.core.entities.EstateViewing;

//@O2XElement(nameInXml="estateViewing")
@O2XElement()
public class EstateViewingO2P{
	private Integer id;
	private Integer  estateId;
	private DateTime dateFrom;
	private Time     dateTo;
	
	public EstateViewingO2P() {
	}

	public EstateViewingO2P(EstateViewing viewing) {
		if(viewing!=null){
			id = viewing.getId();
			estateId = viewing.getEstateId();
			dateFrom = new DateTime(viewing.getDateFrom());
			dateTo = new Time(viewing.getDateTo());
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public void setDateFrom(DateTime dateFrom) {
		this.dateFrom = dateFrom;
	}

	public DateTime getDateFrom() {
		return dateFrom;
	}

	public void setDateTo(Time dateTo) {
		this.dateTo = dateTo;
	}

	public Time getDateTo() {
		return dateTo;
	}
}