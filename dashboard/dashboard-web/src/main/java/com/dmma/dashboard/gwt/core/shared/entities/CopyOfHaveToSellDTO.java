package com.dmma.dashboard.gwt.core.shared.entities;


import java.util.Date;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;

public class CopyOfHaveToSellDTO implements GwtEntityInterface{
	private Integer   id;
	private ClientDTO client;
	
	private Date      created;
	private Integer   createdAtClientVisitId;
	private BrokerDTO createdBy;
	
	private Date      askedDate;
	private BrokerDTO askedBy;
	private String    askComments;
	private Boolean   wantsToSell;
	/** if client do not want to sell, we can ask him again */
	private Boolean   remind;
	private Date      remindDate;
	private Date      remindedDate;
	private BrokerDTO remindedBy;
	private String    remindComments;
	
	public CopyOfHaveToSellDTO() {
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
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

	public BrokerDTO getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BrokerDTO createdBy) {
		this.createdBy = createdBy;
	}

	public Date getAskedDate() {
		return askedDate;
	}

	public void setAskedDate(Date askedDate) {
		this.askedDate = askedDate;
	}

	public BrokerDTO getAskedBy() {
		return askedBy;
	}

	public void setAskedBy(BrokerDTO askedBy) {
		this.askedBy = askedBy;
	}

	public String getAskComments() {
		return askComments;
	}

	public void setAskComments(String askComments) {
		this.askComments = askComments;
	}

	public Boolean getWantsToSell() {
		return wantsToSell;
	}

	public void setWantsToSell(Boolean wantsToSell) {
		this.wantsToSell = wantsToSell;
	}

	public Boolean getRemind() {
		return remind;
	}

	public void setRemind(Boolean remind) {
		this.remind = remind;
	}

	public Date getRemindDate() {
		return remindDate;
	}

	public void setRemindDate(Date remindDate) {
		this.remindDate = remindDate;
	}

	public BrokerDTO getRemindedBy() {
		return remindedBy;
	}

	public void setRemindedBy(BrokerDTO remindedBy) {
		this.remindedBy = remindedBy;
	}

	public String getRemindComments() {
		return remindComments;
	}

	public void setRemindComments(String remindComments) {
		this.remindComments = remindComments;
	}

	
	@Override
	public Object getValueAt(int index) {
		switch(index){
		case  0: return id;
		case  1: return client;
		case  2: return created;
		case  3: return createdBy;
		case  4: return askedDate;
		case  5: return askedBy;
		case  6: return askComments;
		case  7: return wantsToSell;
		case  8: return remind;
		case  9: return remindDate;
		case 10: return remindedDate;
		case 11: return remindedBy;
		case 12: return remindComments;
		}
		return null;
	}

	@Override
	public void setValueAt(int index, Object value) {
		switch(index){
		case  0: return;
		case  1: client         = (ClientDTO) value; return;
		case  2: created        = (Date)      value; return; 
		case  3: createdBy      = (BrokerDTO) value; return; 
		case  4: askedDate      = (Date)      value; return; 
		case  5: askedBy        = (BrokerDTO) value; return; 
		case  6: askComments    = (String)    value; return;
		case  7: wantsToSell    = (Boolean)   value; return;
		case  8: remind         = (Boolean)   value; return;
		case  9: remindDate     = (Date)      value; return;
		case 10: remindedDate   = (Date)      value; return;
		case 11: remindedBy     = (BrokerDTO) value; return;
		case 12: remindComments = (String)    value; return;
		}
	}

	public void setRemindedDate(Date remindedDate) {
		this.remindedDate = remindedDate;
	}

	public Date getRemindedDate() {
		return remindedDate;
	}

	public void setCreatedAtClientVisitId(Integer createdAtClientVisitId) {
		this.createdAtClientVisitId = createdAtClientVisitId;
	}

	public Integer getCreatedAtClientVisitId() {
		return createdAtClientVisitId;
	}
	
}
