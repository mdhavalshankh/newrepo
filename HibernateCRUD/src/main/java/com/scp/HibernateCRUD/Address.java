package com.scp.HibernateCRUD;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Address {

	@Id
	int pinCode;
	String city;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int pinCode, String city) {
		super();
		this.pinCode = pinCode;
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [pinCode=" + pinCode + ", city=" + city + "]";
	}

}

