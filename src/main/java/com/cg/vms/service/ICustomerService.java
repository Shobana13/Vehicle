package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Customer;

public interface ICustomerService {
 
	/**
	 * Method to be override by the implementing class
	 */
	Customer addCustomer(Customer customer);

	/**
	 * Method to be override by the implementing class
	 */
	Customer deleteCustomerbyId(int customerId);

	/**
	 * Method to be override by the implementing class
	 */
	Customer updateFirstName(int id, Customer customer);

	/**
	 * Method to be override by the implementing class
	 */
	Customer updateCustomer(int customerId, Customer customer);
  
	/**
	 * Method to be override by the implementing class
	 */
	List<Customer> findAllCustomer();

	/**
	 * Method to be override by the implementing class
	 */
	Customer viewCustomerbyId(int customerId);

	/**
	 * Method to be override by the implementing class
	 */
	List<Customer> findbyType(String type);

	/**
	 * Method to be override by the implementing class
	 */
	List<Customer> findbyVehicleLocation(String location);

	/**
	 * Method to be override by the implementing class
	 */
	Customer findCustomerByEmailId(String emailId);
}
