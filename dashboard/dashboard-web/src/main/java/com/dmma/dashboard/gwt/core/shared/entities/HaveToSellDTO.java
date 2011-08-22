package com.dmma.dashboard.gwt.core.shared.entities;


import java.util.Date;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;

public class HaveToSellDTO implements GwtEntityInterface{
	private Integer   id;
	private Integer   parrentId;
	private Date      created;
	private Date      activeFrom;
	
	private ClientDTO client;
	private Integer   clientVisitId;
	
	private BrokerDTO defaultBroker;
	
	
	private Date      processedDate;
	private BrokerDTO processedBy;
	private String    processedComments;
	private Boolean   wantsToSell;
	
	public HaveToSellDTO() {
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

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public Integer getClientVisitId() {
		return clientVisitId;
	}

	public void setClientVisitId(Integer clientVisitId) {
		this.clientVisitId = clientVisitId;
	}

	public BrokerDTO getDefaultBroker() {
		return defaultBroker;
	}

	public void setDefaultBroker(BrokerDTO defaultBroker) {
		this.defaultBroker = defaultBroker;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}

	public BrokerDTO getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(BrokerDTO processedBy) {
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

	@Override
	public Object getValueAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(int index, Object value) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
