package com.cg.vms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	@Pattern(regexp = "^[A-Z]{2}\s[0-9]{2}\s[A-Z]{2}\s[0-9]{4}$")
	private String vehicleNumber;

	private String type;

	private String category;

	private String description;

	@NotEmpty
	@Size(min = 3, message = "location should have minimum 3 char")
	private String location;

	@NotEmpty
	@Size(min = 1, message = "capacity should have 6 or 4 for car same in bus 40")
	private String capacity;

	@Range(min = (long) 1.0, max = (long) 20.0)
	private double chargesPerKM;

	@Range(min = (long) 1.0, max = (long) 20.0)
	private double fixedCharges;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private Booking booking;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "vehicle_driver", joinColumns = { @JoinColumn(name = "vehicleId") }, inverseJoinColumns = {
			@JoinColumn(name = "driverId") })
	private List<Driver> driver = new ArrayList<>();

	// Fileds
	// constructors
	public Vehicle() {
	}

	public Vehicle(int vehicleId, String vehicleNumber, String type, String category, String description,
			String location, String capacity, double chargesPerKM, double fixedCharges) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
 	}  

	// Getters and Setters
	// @JsonManagedReference
	public List<Driver> getDriver() {
		return driver;
	}

	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}
}
