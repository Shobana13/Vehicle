package com.cg.vms.entities;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Address {
	@Id
	private int addressId;
	private String streetName;
	private String city;
	
	
	//Constructor
	public Address() {}
    public Address(int addressId, String streetName, String city) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.city = city;
	}
    
  
	//getters n setters
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	//toString
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetName=" + streetName + ", city=" + city + "]";
	}
}
