package com.dmma.base.app.o2xml.test.entity;

import java.util.List;

import com.dmma.base.app.clazz.Currency;
import com.dmma.base.app.clazz.DateTime;
import com.dmma.base.app.clazz.Time;
import com.dmma.base.app.o2xml.annotations.O2XAttribute;
import com.dmma.base.app.o2xml.annotations.O2XElement;


@O2XElement()
public class CarStock {
	@O2XAttribute(listChildNameInXML="avtomobilj")
	private List<Car>    cars;
	@O2XAttribute(nameInXML="owners", listChildNameInXML="owner")
	private List<String> owners;
	private Currency  totalAmount;
	private Time      delery;
	private DateTime  created;
	
	public CarStock() {
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<String> getOwners() {
		return owners;
	}

	public void setOwners(List<String> owners) {
		this.owners = owners;
	}

	public Currency getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Currency totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Time getDelery() {
		return delery;
	}

	public void setDelery(Time delery) {
		this.delery = delery;
	}

	public DateTime getCreated() {
		return created;
	}

	public void setCreated(DateTime created) {
		this.created = created;
	}

	
}
