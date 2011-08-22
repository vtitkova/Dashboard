package com.dmma.dashboard.app.wrappers;

import java.util.Date;

import com.dmma.base.app.o2xml.annotations.O2XElement;
import com.dmma.dashboard.core.entities.ClientVisit;
import com.google.gwt.user.client.rpc.IsSerializable;

@O2XElement
public class ClientVisitO2P implements IsSerializable{

	private Integer          id;
	private ClientO2P        client;
	private Date             created;
	private Integer          estateId;
	private Integer          estateViewingId;
	private Integer          status;
	private String           comments;
	
	
	public ClientVisitO2P() {
	}
	
	public ClientVisitO2P(ClientVisit entity) {
		if(entity!=null){
			this.setId(entity.getId());
			this.setId(entity.getId());
			this.setClient( new ClientO2P(entity.getClient()));
			this.setCreated(entity.getCreated());
			this.setEstateId(entity.getEstate().getId());
			this.setEstateViewingId(entity.getEstateViewing().getId());
			this.setStatus(entity.getStatus());
			this.setComments(entity.getComments());
		}
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public ClientO2P getClient() {
		return client;
	}


	public void setClient(ClientO2P client) {
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
