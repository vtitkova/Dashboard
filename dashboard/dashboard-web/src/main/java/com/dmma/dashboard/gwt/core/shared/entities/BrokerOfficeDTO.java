package com.dmma.dashboard.gwt.core.shared.entities;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;

public class BrokerOfficeDTO implements GwtEntityInterface{

	private Integer id;
	private Long    midasId;
	private String  name;
	private String  address;
	private String  zip;
	private String  city;
	private String  phone;
	private String  email;
	
	public BrokerOfficeDTO(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getMidasId() {
		return midasId;
	}

	public void setMidasId(Long midasId) {
		this.midasId = midasId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Object getValueAt(int index) {
		switch(index){
		case 0: return id;
		case 1: return midasId;
		case 2: return name;
		case 3: return address;
		case 4: return zip;
		case 5: return city;
		case 6: return phone;
		case 7: return email;
		}
		return null;
	}

	@Override
	public void setValueAt(int index, Object value) {
		switch(index){
		case 0: return;
		case 1: midasId = (Long)   value; return;
		case 2: name    = (String) value; return; 
		case 3: address = (String) value; return;
		case 4: zip     = (String) value; return;
		case 5: city    = (String) value; return;
		case 6: phone   = (String) value; return;
		case 7: email   = (String) value; return;
		}
	}

	@Override
	public String toString(){
		return this.name;
	}
}
