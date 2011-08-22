package com.dmma.dashboard.gwt.core.shared.wrappers;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class HtsSearchWrapper implements IsSerializable{
	private Integer wantsToSellSearchTypeId;
	private Integer htcStatusSearchTypeId;
	private Integer brokerId;
	private Date    dateFrom;
	private Date    dateTo;
	
	public HtsSearchWrapper() {
	}

	public Integer getWantsToSellSearchTypeId() {
		return wantsToSellSearchTypeId;
	}

	public void setWantsToSellSearchTypeId(Integer wantsToSellSearchTypeId) {
		this.wantsToSellSearchTypeId = wantsToSellSearchTypeId;
	}

	public Integer getHtcStatusSearchTypeId() {
		return htcStatusSearchTypeId;
	}

	public void setHtcStatusSearchTypeId(Integer htcStatusSearchTypeId) {
		this.htcStatusSearchTypeId = htcStatusSearchTypeId;
	}

	public Integer getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	
}
