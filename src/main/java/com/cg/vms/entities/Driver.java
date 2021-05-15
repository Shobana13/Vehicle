package com.cg.vms.entities;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Driver {
	@Id
	private int driverId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String address;
	private double chargesPerDay;
	private String licenseNo;
	
	
	//Constructors
		public Driver() {}
		public Driver(int driverId, String firstName, String lastName, String contactNumber, String email, String address,
				double chargesPerDay, String licenseNo) {
			super();
			this.driverId = driverId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.contactNumber = contactNumber;
			this.email = email;
			this.address = address;
			this.chargesPerDay = chargesPerDay;
			this.licenseNo = licenseNo;
		}
	//Getters Setters	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getChargesPerDay() {
		return chargesPerDay;
	}
	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	//Generate ToString methods
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address + ", chargesPerDay="
				+ chargesPerDay + ", licenseNo=" + licenseNo + "]";
	}
	
}


