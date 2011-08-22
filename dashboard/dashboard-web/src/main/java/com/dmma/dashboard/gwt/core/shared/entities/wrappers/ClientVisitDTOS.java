package com.dmma.dashboard.gwt.core.shared.entities.wrappers;

import java.util.Date;

import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.user.client.rpc.IsSerializable;


public class ClientVisitDTOS implements IsSerializable{

	private Integer          id;
	private ClientDTO        client;
	private Date             created;
	private Integer          estateId;
	private Integer          estateViewingId;
	private Integer          status;
	private String           comments;
	
	
	public ClientVisitDTOS() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public ClientDTO getClient() {
		return client;
	}


	public void setClient(ClientDTO client) {
		this.client = client;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Integer getEstateId() {
		return estateId;
	}


	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}


	public Integer getEstateViewingId() {
		return estateViewingId;
	}


	public void setEstateViewingId(Integer estateViewingId) {
		this.estateViewingId = estateViewingId;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
