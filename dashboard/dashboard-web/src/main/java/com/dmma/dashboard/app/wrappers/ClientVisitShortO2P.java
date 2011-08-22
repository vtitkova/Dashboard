package com.dmma.dashboard.app.wrappers;

import java.util.Date;

import com.dmma.base.app.o2xml.annotations.O2XElement;
import com.google.gwt.user.client.rpc.IsSerializable;

@O2XElement
public class ClientVisitShortO2P implements IsSerializable{
	private Integer nr;
	private String  client;
	private String  comments;
	private String  status;
	private Date    created;
	
	
	public ClientVisitShortO2P() {
	}

	public ClientVisitShortO2P(Integer nr) {
		setNr(nr);
		client = "";
		comments = "";
		status = "";
		created = null;
	}

	public Integer getNr() {
		return nr;
	}


	public void setNr(Integer nr) {
		this.nr = nr;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
