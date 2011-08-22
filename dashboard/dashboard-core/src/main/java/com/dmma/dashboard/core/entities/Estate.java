package com.dmma.dashboard.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estate")
public class Estate {
	@Id()
	@GeneratedValue
	@Column private Integer id;
	@Column private Long    midasId;
	@Column private Integer finnCode;
	@Column private Integer orderNumber;
	@Column private Integer status;
	@Column private String  title;
	@Column private String  address;
	@Column private String  postCode;
	@Column private String  postCity;
	@Column private String  gnr;
	@Column private String  bnr;
	
	@ManyToOne( targetEntity=Broker.class )
	@JoinColumn(name="brokerid")
	private Broker broker;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="estateid")
    private List<EstateViewing> estateViewings;
		 
	public Estate() {
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

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public void setEstateViewings(List<EstateViewing> estateViewings) {
		this.estateViewings = estateViewings;
	}

	public List<EstateViewing> getEstateViewings() {
		return estateViewings;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

}
