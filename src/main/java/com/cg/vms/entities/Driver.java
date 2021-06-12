package com.cg.vms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;  
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Driver {

	// Fileds
	@Id
	@GeneratedValue
	private int driverId;

	@NotEmpty
	@Size(min = 2, message = "first name should have atleast 2 char")
	private String firstName;

	@NotEmpty
	@Size(min = 2, message = "last name should have atleast 2 char")
	private String lastName;

	@Pattern(regexp="\\+?\\d[\\d -]{8,12}\\d")
	private String contactNumber;

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 3, message = "address should have atleast 3 char")
	private String address;
	
	@Range(min = (long) 500.0, max = (long) 1000.0)
	private double chargesPerDay;
	
	@Pattern(regexp="^[A-Z]{2}[0-9]{2}\s[0-9]{11}$")
	private String licenseNo;
	
	@JsonIgnore
	@ManyToMany(mappedBy="driver",
			cascade = CascadeType.ALL)
	private List<Vehicle> vehicle;

	// Constructors
	public Driver() {
	}

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
  
	// Getters Setters
	//@JsonBackReference
	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}