package com.dmma.dashboard.gwt.core.shared.entities;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;
import com.dmma.base.gwt.shared.interfaces.ContactInfoBig;
import com.dmma.base.gwt.shared.interfaces.ContactInfoSmall;



public class ClientDTO implements GwtEntityInterface, ContactInfoBig, ContactInfoSmall{
	private Integer id;
	private String  name;
	private String  surname;
	private String  email;
	private String  phone;
	private String  comments;
	
	public ClientDTO() {
	}

	public ClientDTO(Integer id) {
		setId(id);
	}

	@Override
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

	@Override
	public Object getValueAt(int index) {
		switch(index){
		case 0: return id;
		case 1: return name;
		case 2: return surname;
		case 3: return email;
		case 4: return phone;
		case 5: return comments;
		}
		return null;
	}

	@Override
	public void setValueAt(int index, Object value) {
		switch(index){
		case 0: return;
		case 1: name     = (String) value; return;
		case 2: surname  = (String) value; return; 
		case 3: email    = (String) value; return;
		case 4: phone    = (String) value; return;
		case 5: comments = (String) value; return;
		}
	}
	
	@Override
	public String toString(){
		return this.name+ " "+this.getSurname();
	}

	@Override
	public String getBigImageUrl() {
		return null; // not available now
	}

	@Override
	public String getFullName() {
		return name+ " "+surname;
	}

	@Override
	public String[] getInfoList() {
		return new String[]{email, phone, comments};
	}

	@Override
	public String getSmallImageUrl() {
		return null;
	}

	@Override
	public String getInfo() {
		return phone;
	}

	
	
	
	
}
