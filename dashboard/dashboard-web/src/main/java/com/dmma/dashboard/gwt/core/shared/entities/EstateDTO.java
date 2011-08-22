package com.dmma.dashboard.gwt.core.shared.entities;


import java.util.ArrayList;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;
import com.dmma.base.gwt.shared.interfaces.PlaceInfoBig;
import com.dmma.base.gwt.shared.interfaces.PlaceInfoSmall;


public class EstateDTO implements GwtEntityInterface, PlaceInfoBig, PlaceInfoSmall{
	private Integer id;
	private Long    midasId;
	private Integer finnCode;
	private Integer orderNumber;
	private Integer status;
	private String  title;
	private String  address;
	private String  postCode;
	private String  postCity;
	private String  gnr;
	private String  bnr;
	
	private BrokerDTO broker;
	private ArrayList<EstateViewingDTO> estateViewings;
	
	public EstateDTO() {
	}

	public EstateDTO(Integer id) {
		setId(id);
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


	public Integer getFinnCode() {
		return finnCode;
	}


	public void setFinnCode(Integer finnCode) {
		this.finnCode = finnCode;
	}


	public Integer getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	public String getPostCity() {
		return postCity;
	}


	public void setPostCity(String postCity) {
		this.postCity = postCity;
	}


	public String getGnr() {
		return gnr;
	}


	public void setGnr(String gnr) {
		this.gnr = gnr;
	}


	public String getBnr() {
		return bnr;
	}


	public void setBnr(String bnr) {
		this.bnr = bnr;
	}


	public BrokerDTO getBroker() {
		return broker;
	}


	public void setBroker(BrokerDTO broker) {
		this.broker = broker;
	}

	public void setEstateViewings(ArrayList<EstateViewingDTO> estateViewings) {
		this.estateViewings = estateViewings;
	}


	public ArrayList<EstateViewingDTO> getEstateViewings() {
		return estateViewings;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getStatus() {
		return status;
	}


	@Override
	public Object getValueAt(int index) {
		switch(index){
		case  0: return id;
		case  1: return midasId;
		case  2: return finnCode;
		case  3: return orderNumber;
		case  4: return status;
		case  5: return title;
		case  6: return address;
		case  7: return postCode;
		case  8: return postCity;
		case  9: return gnr;
		case 10: return bnr;
		case 11: return broker;
		case 12: return estateViewings;
		}
		return null;
	}

	@Override
	public void setValueAt(int index, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString(){
		return this.title +" "+this.address;
	}

	@Override
	public String getSmallImageUrl() {
		return null; // not available now
	}

	@Override
	public String getInfo() {
		return address;
	}

	@Override
	public String getBigImageUrl() {
		return null; // not available now
	}

	@Override
	public String getDisplayName() {
		return title;
	}

	@Override
	public String[] getInfoList() {
		return new String[]{address, postCity+" "+postCode};
	}

	
}
