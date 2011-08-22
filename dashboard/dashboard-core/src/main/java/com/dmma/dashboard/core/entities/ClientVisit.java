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
@Table(name = "clientvisit")
public class ClientVisit{

	@Id()
	@GeneratedValue
	@Column private Integer          id;

	@ManyToOne( targetEntity=Client.class )
	@JoinColumn(name="clientid")
	private Client           client;
	
	@Column private Date             created;
	
	@ManyToOne( targetEntity=Estate.class )
	@JoinColumn(name="estateid")
	private Estate           estate;

	@ManyToOne( targetEntity=EstateViewing.class )
	@JoinColumn(name="estateviewingid")
	private EstateViewing    estateViewing;
	
	@Column private Integer          status;
	@Column private String           comments;
	
	
	public ClientVisit() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Estate getEstate() {
		return estate;
	}


	public void setEstate(Estate estate) {
		this.estate = estate;
	}


	public EstateViewing getEstateViewing() {
		return estateViewing;
	}


	public void setEstateViewing(EstateViewing estateViewing) {
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
