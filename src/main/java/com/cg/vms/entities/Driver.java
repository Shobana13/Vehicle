package com.cg.vms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Driver {

	// fields
	@Id
	private int driverId;

	@NotEmpty
	@Size(min = 2, message = "first name should have atleast 2 char")
	private String firstName;

	@NotEmpty
	@Size(min = 2, message = "last name should have atleast 2 char")
	private String lastName;

	private String contactNumber;
	private String email;
	private String address;
	private double chargesPerDay;
	private String licenseNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicleid")
	private Vehicle vehicle;

	// Constructors
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
}
