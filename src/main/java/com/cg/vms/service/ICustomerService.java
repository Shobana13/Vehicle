package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Customer;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer deleteCustomerbyId(int customerId);
	Customer updateFirstName(int id,Customer customer);
	Customer update(Customer customer);
	List<Customer> findAllCustomer();
	Customer viewCustomerbyId(int customerId);
	List<Customer> findbyType(String type);
	Customer viewCustomer(Customer customer);
	List<Customer> findbyVehicleLocation(String location);
	
}
