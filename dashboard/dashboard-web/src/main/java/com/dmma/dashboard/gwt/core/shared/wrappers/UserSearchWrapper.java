package com.dmma.dashboard.gwt.core.shared.wrappers;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserSearchWrapper implements IsSerializable{
	private String partOfEmail;
	private Long midasId;
	private Long externalId;
	private Integer roleTypeId;
	private Integer statusTypeId;
	
	public UserSearchWrapper() {
	}

	public String getPartOfEmail() {
		return partOfEmail;
	}

	public void setPartOfEmail(String partOfEmail) {
		this.partOfEmail = partOfEmail;
	}

	public Long getMidasId() {
		return midasId;
	}

	public void setMidasId(Long midasId) {
		this.midasId = midasId;
	}

	public Long getExternalId() {
		return externalId;
	}

	public void setExternalId(Long externalId) {
		this.externalId = externalId;
	}

	public Integer getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(Integer roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public Integer getStatusTypeId() {
		return statusTypeId;
	}

	public void setStatusTypeId(Integer statusTypeId) {
		this.statusTypeId = statusTypeId;
	}
}
