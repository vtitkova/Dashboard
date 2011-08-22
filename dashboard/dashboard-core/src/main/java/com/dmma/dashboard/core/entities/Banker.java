package com.dmma.dashboard.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "banker")
public class Banker {
	@Id()
	@GeneratedValue
	@Column private Integer id;
	@Column private Integer userId;
	@Column private Long    externalId;
	@Column private String  name;
	@Column private String  surname;
	@Column private String  email;
	@Column private String  phone;
	@Column private String  cellPhone;
	@Column private Integer avco;
	
	@ManyToOne( targetEntity=BankOffice.class )
	@JoinColumn(name="bankofficeid")
	private BankOffice bankOffice;
	
	
	public Banker() {
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


	public void setExternalId(Long externalId) {
		this.externalId = externalId;
	}

	public Long getExternalId() {
		return externalId;
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

	public void setBankOffice(BankOffice bankOffice) {
		this.bankOffice = bankOffice;
	}

	public BankOffice getBankOffice() {
		return bankOffice;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setAvco(Integer avco) {
		this.avco = avco;
	}

	public Integer getAvco() {
		return avco;
	}

}
