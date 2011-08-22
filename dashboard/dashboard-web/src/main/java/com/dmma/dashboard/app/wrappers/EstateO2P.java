package com.dmma.dashboard.app.wrappers;


import com.dmma.base.app.o2xml.annotations.O2XElement;
import com.dmma.dashboard.core.entities.Estate;

@O2XElement
public class EstateO2P{
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

	private BrokerO2P broker;
	//private ArrayList<EstateViewingDTO> estateViewings;

	public EstateO2P() {
	}

	public EstateO2P(Estate estate) {
		if(estate !=null ){
			this.setId(          estate.getId());
			this.setMidasId(     estate.getMidasId());
			this.setFinnCode(    estate.getFinnCode());
			this.setOrderNumber( estate.getOrderNumber());
			this.setStatus(      estate.getStatus());
			this.setTitle(       estate.getTitle());
			this.setAddress(     estate.getAddress());
			this.setPostCode(    estate.getPostCode());
			this.setPostCity(    estate.getPostCity());
			this.setGnr(         estate.getGnr());
			this.setBnr(         estate.getBnr());
			this.setBroker(new BrokerO2P(estate.getBroker()));
		}
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


	public BrokerO2P getBroker() {
		return broker;
	}


	public void setBroker(BrokerO2P broker) {
		this.broker = broker;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getStatus() {
		return status;
	}




}
