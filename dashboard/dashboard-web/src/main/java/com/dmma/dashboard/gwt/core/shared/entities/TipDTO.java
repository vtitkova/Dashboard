package com.dmma.dashboard.gwt.core.shared.entities;


import java.util.Date;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;

public class TipDTO implements GwtEntityInterface{
	private Integer   id;
	private Integer   tipDirectionType; // Broker To Banker, Banker toBroker 
	private BrokerDTO broker;
	private BankerDTO banker;
	private ClientDTO client;
	private EstateDTO estate;
	private Integer   tipType;          //Loan, SellEstate, broker inventory
	private String    comments;
	private Date      created;
	private Integer   tipStatusType;    // is New, isInProcess, isAccepted, isRejected
	private Date      modified;         // date status has been modified
	private String    statusComments;
	
	public TipDTO() {
		created = new Date();
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

	public BrokerDTO getBroker() {
		return broker;
	}

	public void setBroker(BrokerDTO broker) {
		this.broker = broker;
	}

	public BankerDTO getBanker() {
		return banker;
	}

	public void setBanker(BankerDTO banker) {
		this.banker = banker;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public EstateDTO getEstate() {
		return estate;
	}

	public void setEstate(EstateDTO estate) {
		this.estate = estate;
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

	@Override
	public Object getValueAt(int index) {
		switch(index){
		case  0: return id;
		case  1: return tipDirectionType;
		case  2: return broker;
		case  3: return banker;
		case  4: return client;
		case  5: return estate;
		case  6: return tipType;
		case  7: return comments;
		case  8: return created;
		case  9: return tipStatusType;
		case 10: return modified;
		case 11: return statusComments;
		}
		return null;
	}

	@Override
	public void setValueAt(int index, Object value) {
		switch(index){
		case  0: return;
		case  1: tipDirectionType  = (Integer)   value; return;
		case  2: broker            = (BrokerDTO) value; return; 
		case  3: banker            = (BankerDTO) value; return; 
		case  4: client            = (ClientDTO) value; return; 
		case  5: estate            = (EstateDTO) value; return; 
		case  6: tipType           = (Integer)   value; return;
		case  7: comments          = (String)    value; return;
		case  8: created           = (Date)      value; return;
		case  9: tipStatusType     = (Integer)   value; return;
		case 10: modified          = (Date)      value; return;
		case 11: statusComments    = (String)    value; return;
		}
	}
	
	@Override
	public String toString(){
		return ""+this.id;
	}

	
}
