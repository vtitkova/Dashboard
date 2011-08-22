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
@Table(name = "havetosell")
public class HaveToSell {
	@Id()
	@GeneratedValue
	@Column private Integer   id;
	@Column private Integer   parrentId;
	@Column private Date      created;
	@Column private Date      activeFrom;
	
	
	@ManyToOne( targetEntity=Client.class )
	@JoinColumn(name="clientid")
	private Client    client;
	@Column private Integer   clientVisitId;
	
	
	@ManyToOne( targetEntity=Broker.class )
	@JoinColumn(name="defaultbrokerid")
	private Broker    defaultBroker;
	
	
	@Column private Date    processedDate;
	@ManyToOne( targetEntity=Broker.class )
	@JoinColumn(name="processedbyid")
	private Broker    processedBy;
	@Column private String    processedComments;
	
	@Column private Boolean   wantsToSell;
	/** if client do not want to sell, we can ask him again */
	
	public HaveToSell() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParrentId() {
		return parrentId;
	}
	public void setParrentId(Integer parrentId) {
		this.parrentId = parrentId;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Integer getClientVisitId() {
		return clientVisitId;
	}
	public void setClientVisitId(Integer clientVisitId) {
		this.clientVisitId = clientVisitId;
	}
	public Broker getDefaultBroker() {
		return defaultBroker;
	}
	public void setDefaultBroker(Broker defaultBroker) {
		this.defaultBroker = defaultBroker;
	}
	public Date getProcessedDate() {
		return processedDate;
	}
	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
	public Broker getProcessedBy() {
		return processedBy;
	}
	public void setProcessedBy(Broker processedBy) {
		this.processedBy = processedBy;
	}
	public String getProcessedComments() {
		return processedComments;
	}
	public void setProcessedComments(String processedComments) {
		this.processedComments = processedComments;
	}
	public Boolean getWantsToSell() {
		return wantsToSell;
	}
	public void setWantsToSell(Boolean wantsToSell) {
		this.wantsToSell = wantsToSell;
	}
	
}