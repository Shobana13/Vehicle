package com.cg.vms.service;



import com.cg.vms.entities.Customer;
import com.cg.vms.entities.CustomerLogin;

public interface ICustomerLoginService {
	// Method to be override by the implementing class
	public Customer login(CustomerLogin user);

	// Method to be override by the implementing class
	public String logout(String email);
	
	// Method to be override by the implementing class
	public Customer getUser(String email);
}
  