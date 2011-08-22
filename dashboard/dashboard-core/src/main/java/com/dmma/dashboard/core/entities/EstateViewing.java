package com.dmma.dashboard.core.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estateviewing")
public class EstateViewing {
	@Id()
	@GeneratedValue
	@Column private Integer id;
	@Column private Integer estateId;
	@Column private Date    dateFrom;
	@Column private Date    dateTo;
	
	public EstateViewing() {
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
