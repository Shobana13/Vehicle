package com.cg.vms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.cg.vms.dto.VehicleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Customer {

	//fields
	@Id
	private int customerId;

	@NotEmpty
	@Size(min = 2, message = "first name should have atleast 2 char")
	private String firstName;

	@NotEmpty
	@Size(min = 2, message = "last name should have atleast 2 char")
	private String lastName;

	private String mobileNumber;
	private String emailId;

	// mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	private VehicleDto vehicledto;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	
	//Constructors
	public Customer(int customerId) {}

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String emailId) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;

	}
}