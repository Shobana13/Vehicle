package com.cg.vms.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private String streetName;
	private String city;

	// Constructor
	public Address(int addressId, String streetName, String city) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.city = city;
	}
}
