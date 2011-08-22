package com.dmma.dashboard.core.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tip")
public class Tip {
	@Id()
	@GeneratedValue
	@Column private Integer id;
	@Column private Integer tipDirectionType; // Broker To Banker, Banker toBroker 
	
	@ManyToOne( targetEntity=Broker.class )
	@JoinColumn(name="brokerid")
	private Broker   broker;
	
	@ManyToOne( targetEntity=Banker.class )
	@JoinColumn(name="bankerid")
	private Banker   banker;
	
	@ManyToOne( targetEntity=Client.class )
	@JoinColumn(name="clientid")
	private Client   client;
	
	@ManyToOne( targetEntity=Estate.class )
	@JoinColumn(name="estateid")
	private Estate   estate;
	
	@Column private Integer tipType;          //Loan, SellEstate, broker inventory
	@Column private String  comments;
	@Column private Date    created;
	@Column private Integer tipStatusType;    // is New, isInProcess, isAccepted, isRejected
	@Column private Date    modified;         // date status has been modified
	@Column private String  statusComments;
	
	
	public Tip() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getTipDirectionType() {
		return tipDirectionType;
	}


	public void setTipDirectionType(Integer tipDirectionType) {
		this.tipDirectionType = tipDirectionType;
	}


	public Broker getBroker() {
		return broker;
	}


	public void setBroker(Broker broker) {
		this.broker = broker;
	}


	public Banker getBanker() {
		return banker;
	}


	public void setBanker(Banker banker) {
		this.banker = banker;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Integer getTipType() {
		return tipType;
	}


	public void setTipType(Integer tipType) {
		this.tipType = tipType;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Integer getTipStatusType() {
		return tipStatusType;
	}


	public void setTipStatusType(Integer tipStatusType) {
		this.tipStatusType = tipStatusType;
	}


	public Date getModified() {
		return modified;
	}


	public void setModified(Date modified) {
		this.modified = modified;
	}


	public String getStatusComments() {
		return statusComments;
	}


	public void setStatusComments(String statusComments) {
		this.statusComments = statusComments;
	}


	public void setEstate(Estate estate) {
		this.estate = estate;
	}


	public Estate getEstate() {
		return estate;
	}
}
