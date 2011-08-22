package com.dmma.dashboard.gwt.core.shared.entities;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ClientVisitDTO implements IsSerializable{

	private Integer          id;
	private ClientDTO        client;
	private Date             created;
	private EstateDTO        estate;
	private EstateViewingDTO estateViewing;
	private Integer          status;
	private String           comments;
	
	
	public ClientVisitDTO() {
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


	public EstateDTO getEstate() {
		return estate;
	}


	public void setEstate(EstateDTO estate) {
		this.estate = estate;
	}


	public EstateViewingDTO getEstateViewing() {
		return estateViewing;
	}


	public void setEstateViewing(EstateViewingDTO estateViewing) {
		this.estateViewing = estateViewing;
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
