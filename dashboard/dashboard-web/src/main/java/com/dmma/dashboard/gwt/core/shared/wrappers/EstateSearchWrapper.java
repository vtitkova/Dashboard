package com.dmma.dashboard.gwt.core.shared.wrappers;

import com.google.gwt.user.client.rpc.IsSerializable;

public class EstateSearchWrapper implements IsSerializable{
	private Integer statusSearchTypeId;
	private Integer officeId;
	private Integer brokerId;
	
	public EstateSearchWrapper() {
	}

	public void setStatusSearchTypeId(Integer statusSearchTypeId) {
		this.statusSearchTypeId = statusSearchTypeId;
	}

	public Integer getStatusSearchTypeId() {
		return statusSearchTypeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public Integer getOfficeId() {
		return officeId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	public Integer getBrokerId() {
		return brokerId;
	}
	
	

}
