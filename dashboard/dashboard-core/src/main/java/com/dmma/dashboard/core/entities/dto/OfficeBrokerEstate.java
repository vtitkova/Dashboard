package com.dmma.dashboard.core.entities.dto;

public class OfficeBrokerEstate implements Comparable<OfficeBrokerEstate>{
	private Integer officeId;
	private String  officeName;
	private Long    brokerId;
	private String  brokerDisplayName;
	private String  brokerEmail;
	private Long    estateMidasId;
	private Integer estateStatus;
	private String  estateStatusString;
	private String  estateAddress;
	
	public OfficeBrokerEstate() {
	}

	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerDisplayName() {
		return brokerDisplayName;
	}

	public void setBrokerDisplayName(String brokerDisplayName) {
		this.brokerDisplayName = brokerDisplayName;
	}

	public String getBrokerEmail() {
		return brokerEmail;
	}

	public void setBrokerEmail(String brokerEmail) {
		this.brokerEmail = brokerEmail;
	}

	public Integer getEstateStatus() {
		return estateStatus;
	}

	public void setEstateStatus(Integer estateStatus) {
		this.estateStatus = estateStatus;
	}

	public String getEstateAddress() {
		return estateAddress;
	}

	public void setEstateAddress(String estateAddress) {
		this.estateAddress = estateAddress;
	}

	public void setEstateMidasId(Long estateMidasId) {
		this.estateMidasId = estateMidasId;
	}

	public Long getEstateMidasId() {
		return estateMidasId;
	}

	@Override
	public int compareTo(OfficeBrokerEstate object) {
		if(officeId > object.officeId )
			return 1;
		else if(officeId < object.officeId )
			return -1;
		else{
			if(brokerId > object.brokerId )
				return 1;
			else if(brokerId < object.brokerId )
				return -1;
			else
				return 0;
		} 
	}

	public String getEstateStatusString() {
		return estateStatusString;
	}

	public void setEstateStatusString(String estateStatusString) {
		this.estateStatusString = estateStatusString;
	}
	
	
	
}
