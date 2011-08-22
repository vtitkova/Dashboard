package com.dmma.dashboard.app.wrappers;

import com.dmma.base.app.o2xml.annotations.O2XElement;
import com.dmma.dashboard.core.entities.Client;

@O2XElement 
public class ClientO2P {
	private Integer id;
	private String  name;
	private String  surname;
	private String  email;
	private String  phone;
	private String  comments;

	public ClientO2P() {
	}

	public ClientO2P(Client entity) {
		if(entity!=null){
			this.setId(       entity.getId());
			this.setName(     entity.getName());
			this.setSurname(  entity.getSurname());
			this.setEmail(    entity.getEmail());
			this.setPhone(    entity.getPhone());
			this.setComments( entity.getComments());
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
