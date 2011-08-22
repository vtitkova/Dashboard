package com.dmma.dashboard.gwt.core.shared.entities;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;


public class EstateViewingDTO implements IsSerializable{
	private Integer id;
	private Integer estateId;
	private Date    dateFrom;
	private Date    dateTo;
	
	public EstateViewingDTO() {
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

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Date getDateTo() {
		return dateTo;
	}
}