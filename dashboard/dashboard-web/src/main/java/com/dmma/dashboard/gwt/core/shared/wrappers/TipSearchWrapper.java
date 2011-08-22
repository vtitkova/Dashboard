package com.dmma.dashboard.gwt.core.shared.wrappers;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TipSearchWrapper implements IsSerializable{
	private Integer tipDirectionSearchTypeId;
	private Integer tipTypeSearchTypeId;
	private Integer tipStatusSearchTypeId;
	private Integer bankOfficeId;
	private Integer bankerId;
	private Integer brokerOfficeId;
	private Integer brokerId;
	private Date    dateFrom;
	private Date    dateTo;
	
	public TipSearchWrapper() {
	}

	public Integer getTipDirectionSearchTypeId() {
		return tipDirectionSearchTypeId;
	}

	public void setTipDirectionSearchTypeId(Integer tipDirectionSearchTypeId) {
		if(tipDirectionSearchTypeId!=null&&tipDirectionSearchTypeId>0)
			this.tipDirectionSearchTypeId = tipDirectionSearchTypeId;
	}

	public Integer getTipTypeSearchTypeId() {
		return tipTypeSearchTypeId;
	}

	public void setTipTypeSearchTypeId(Integer tipTypeSearchTypeId) {
		if(tipTypeSearchTypeId!=null&&tipTypeSearchTypeId>0)
			this.tipTypeSearchTypeId = tipTypeSearchTypeId;
	}

	public Integer getTipStatusSearchTypeId() {
		return tipStatusSearchTypeId;
	}

	public void setTipStatusSearchTypeId(Integer tipStatusSearchTypeId) {
		if(tipStatusSearchTypeId!=null&&tipStatusSearchTypeId>0)
			this.tipStatusSearchTypeId = tipStatusSearchTypeId;
	}

	public Integer getBankOfficeId() {
		return bankOfficeId;
	}

	public void setBankOfficeId(Integer bankOfficeId) {
		if(bankOfficeId!=null&&bankOfficeId>0)
			this.bankOfficeId = bankOfficeId;
	}

	public Integer getBankerId() {
		return bankerId;
	}

	public void setBankerId(Integer bankerId) {
		if(bankerId!=null&&bankerId>0)
			this.bankerId = bankerId;
	}

	public Integer getBrokerOfficeId() {
		return brokerOfficeId;
	}

	public void setBrokerOfficeId(Integer brokerOfficeId) {
		if(brokerOfficeId!=null&&brokerOfficeId>0)
			this.brokerOfficeId = brokerOfficeId;
	}

	public Integer getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		if(brokerId!=null&&brokerId>0)
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
