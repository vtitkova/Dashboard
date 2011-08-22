package com.dmma.dashboard.app.wrappers;

import com.dmma.base.app.o2xml.annotations.O2XElement;
import com.dmma.dashboard.core.entities.Broker;

@O2XElement
public class BrokerO2P{
	private Integer id;
	private Integer userId;
	private Long    midasId;
	private String  name;
	private String  surname;
	private String  email;
	private String  phone;
	private String  cellPhone;
	private Integer avco;

	//private BrokerOfficeDTO brokerOffice;
	public BrokerO2P() {

	}

	public BrokerO2P(Broker source) {
		if(source!=null){
			this.setId(       source.getId());
			this.setMidasId(  source.getMidasId());
			this.setUserId(   source.getUserId());
			this.setName(     source.getName());
			this.setSurname(  source.getSurname());
			this.setEmail(    source.getEmail());
			this.setPhone(    source.getPhone());
			this.setCellPhone(source.getCellPhone());
			this.setAvco(     source.getAvco());
		}
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

	

	public void setAvco(Integer avco) {
		this.avco = avco;
	}

	public Integer getAvco() {
		return avco;
	}

}
