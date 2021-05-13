package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Customer;
import com.cg.vms.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository custRep;

	@Override
	public Customer addCustomer(Customer customer) {
		return custRep.save(customer);
	}

	@Override
	public Customer updateFirstName(int CustomerId, Customer customer) {

		Optional<Customer> cust = custRep.findById(CustomerId);
		if (cust.isPresent()) {
			cust.get().setFirstName(customer.getFirstName());
			return custRep.save(cust.get());
		}
		return null;
	}

	@Override
	public Customer update(Customer customer) {
		Optional<Customer> cust = custRep.findById(customer.getCustomerId());
		if (!cust.isPresent()) {
			return null;
		}
		cust.get().setFirstName(customer.getFirstName());
		cust.get().setLastName(customer.getLastName());
		cust.get().setMobileNumber(customer.getMobileNumber());
		cust.get().setEmailId(customer.getEmailId());
		cust.get().setAddress(customer.getAddress());
		return custRep.save(cust.get());
	}

	@Override
	public List<Customer> findAllCustomer() {
		return custRep.findAll();

	}

	@Override
	public Customer viewCustomerbyId(int customerId) {
		Optional<Customer> cust = custRep.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		return cust.get();
	}

	@Override
	public Customer deleteCustomerbyId(int customerId) {
		Optional<Customer> cust = custRep.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		custRep.deleteById(customerId);
		return cust.get();
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		Customer cust = custRep.findById(customer.getCustomerId()).get();
		return cust;
	}

	@Override
	public List<Customer> findbyType(String type) {
		return custRep.findbyType(type);
	}

	@Override
	public List<Customer> findbyVehicleLocation(String location) {
		return custRep. findbyVehicleLocation(location);
		
	}

	
}
