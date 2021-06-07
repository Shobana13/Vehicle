package com.cg.vms.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Address {

	// fields
	@Id
	private int addressId;
	@NotEmpty
	@Size(min = 2, message = "first name should have atleast 2 char")
	private String streetName;
	@NotEmpty
	@Size(min = 2, message = "first name should have atleast 2 char")
	private String city;

	// Constructor
	public Address(int addressId, String streetName, String city) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.city = city;
	}
}
