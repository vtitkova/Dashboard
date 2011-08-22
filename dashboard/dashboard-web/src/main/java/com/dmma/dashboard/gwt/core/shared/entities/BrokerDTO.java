package com.dmma.dashboard.gwt.core.shared.entities;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;
import com.dmma.base.gwt.shared.interfaces.ContactInfoBig;
import com.dmma.base.gwt.shared.interfaces.ContactInfoSmall;



public class BrokerDTO implements GwtEntityInterface, ContactInfoBig, ContactInfoSmall{
	private Integer id;
	private Integer userId;
	private Long    midasId;
	private String  name;
	private String  surname;
	private String  email;
	private String  phone;
	private String  cellPhone;
	private Integer avco;
	
	private BrokerOfficeDTO brokerOffice;
	
	
	public BrokerDTO() {
	}

	public BrokerDTO(Integer id) {
		setId(id);
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

	public void setBrokerOffice(BrokerOfficeDTO brokerOffice) {
		this.brokerOffice = brokerOffice;
	}

	public BrokerOfficeDTO getBrokerOffice() {
		return brokerOffice;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	@Override
	public Object getValueAt(int index) {
		switch(index){
		case 0: return id;
		case 1: return userId;
		case 2: return midasId;
		case 3: return name;
		case 4: return surname;
		case 5: return email;
		case 6: return phone;
		case 7: return cellPhone;
		case 8: return avco;
		case 9: return brokerOffice;
		}
		return null;
	}

	@Override
	public void setValueAt(int index, Object value) {
		switch(index){
		case 0: return;
		case 1: userId    = (Integer) value; return;
		case 2: midasId   = (Long)    value; return;
		case 3: name      = (String)  value; return; 
		case 4: surname   = (String)  value; return; 
		case 5: email     = (String)  value; return; 
		case 6: phone     = (String)  value; return; 
		case 7: cellPhone = (String)  value; return; 
		case 8: avco      = (Integer) value; return; 
		case 9: brokerOffice = (BrokerOfficeDTO) value; return;
		}
	}

	@Override
	public String toString(){
		return this.name +" "+this.surname;
	}

	public void setAvco(Integer avco) {
		this.avco = avco;
	}

	public Integer getAvco() {
		return avco;
	}

	@Override
	public String getBigImageUrl() {
		return null;
	}

	@Override
	public String getFullName() {
		return name+ " "+surname;
	}

	@Override
	public String[] getInfoList() {
		String office = null;
		if(brokerOffice!=null)
			office = "@"+brokerOffice.getName();
		return new String[]{email, phone, cellPhone, office};
	}
	
	@Override
	public String getSmallImageUrl() {
		return null;
	}

	@Override
	public String getInfo() {
		String office = null;
		if(brokerOffice!=null)
			office = "@"+brokerOffice.getName();
		return office + ", " + cellPhone;
	}
	
}
