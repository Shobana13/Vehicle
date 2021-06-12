package com.cg.vms.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
public class Customer {
 
	/**
	 * Creating Instance variables for Customer class
	 */
	@Id
	@GeneratedValue
	private int customerId;

	@NotEmpty
	@Size(min = 2, message = "first name should have atleast 2 char")
	private String firstName;

	@NotEmpty
	@Size(min = 2, message = "last name should have atleast 2 char")
	private String lastName;

	@NotEmpty
	@Pattern(regexp = "\\+?\\d[\\d -]{8,12}\\d")
	private String mobileNumber;

	@NotEmpty
	@Email(message = "enter a valid mailId")
	private String emailId;

	@NotEmpty
	@Size(min = 5, max = 15, message = "Minimum characters in password")
	private String customerPassword;

	/**
	 * Mapping
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Vehicle> vehicle;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Address> address;

	/**
	 * creating constructors
	 */

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String emailId,
			String customerPassword) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.customerPassword = customerPassword;

	}

}
