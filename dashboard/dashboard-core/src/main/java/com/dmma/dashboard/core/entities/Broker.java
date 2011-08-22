package com.dmma.dashboard.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "broker")
public class Broker {
	@Id()
	@GeneratedValue
	@Column private Integer id;
	@Column private Integer userId;
	@Column private Long    midasId;
	@Column private String  name;
	@Column private String  surname;
	@Column private String  email;
	@Column private String  phone;
	@Column private String  cellPhone;
	@Column private Integer avco;
	
	
	@ManyToOne( targetEntity=BrokerOffice.class )
	@JoinColumn(name="brokerofficeid")
	private BrokerOffice    brokerOffice;
	
	
	public Broker() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setMidasId(Long midasId) {
		this.midasId = midasId;
	}

	public Long getMidasId() {
		return midasId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setBrokerOffice(BrokerOffice brokerOffice) {
		this.brokerOffice = brokerOffice;
	}

	public BrokerOffice getBrokerOffice() {
		return brokerOffice;
	}

	public void setAvco(Integer avco) {
		this.avco = avco;
	}

	public Integer getAvco() {
		return avco;
	}

}
