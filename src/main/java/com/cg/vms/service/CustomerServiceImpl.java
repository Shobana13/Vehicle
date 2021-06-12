package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vms.entities.Customer;
import com.cg.vms.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository custRep;

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

	/**
	 * Used to store the customer details passed from the controller
	 * 
	 * @return
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		logger.info("Adding the customer details to the database");
		return custRep.save(customer);
	}

	/**
	 * This function will update the FirstName of customer
	 * 
	 * @return
	 */
	@Override
	public Customer updateFirstName(int CustomerId, Customer customer) {
		logger.info("Updating the  firstName of the customer");
		Optional<Customer> cust = custRep.findById(CustomerId);
		if (cust.isPresent()) {
			cust.get().setFirstName(customer.getFirstName());
			return custRep.save(cust.get());
		}
		return null;
	}

	/**
	 * This function will update the customer details
	 * 
	 * @return  
	 */
	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		logger.info("Updating the customer details");
		Optional<Customer> cust = custRep.findById(customerId);
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

	/**
	 * Get the list of all the customer
	 * 
	 * @return
	 */
	@Override
	public List<Customer> findAllCustomer() {
		logger.info("Getting all the customer details");
		return custRep.findAll();

	}

	/**
	 * This function will retrieve the customer on basis of given Id
	 * 
	 * @return
	 */
	@Override
	public Customer viewCustomerbyId(int customerId) {
		logger.info("Getting the customer detail by Id");
		Optional<Customer> cust = custRep.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		return cust.get();
	}

	/**
	 * This function will delete the customer on basis of given Id
	 * 
	 * @return
	 */
	@Override
	public Customer deleteCustomerbyId(int customerId) {
		logger.info("Deleting the customer detail by Id");
		Optional<Customer> cust = custRep.findById(customerId);
		if (!cust.isPresent()) {
			return null;
		}
		custRep.deleteById(customerId);
		return cust.get();
	}

	/**
	 * Get all the customer by using vehicle location
	 * 
	 * @return
	 */
	@Override
	public List<Customer> findbyVehicleLocation(String location) {
		logger.info("Getting the list of customer by using vehicle location");
		return custRep.findbyVehicleLocation(location);

	}

	/**
	 * Get all the customer by using vehicle type
	 * 
	 * @return
	 */
	@Override
	public List<Customer> findbyType(String type) {
		logger.info("Getting the list of customer by using vehicle type");
		return custRep.findbyType(type);

	}

	/**
	 * Get the customer by using EmailId
	 * 
	 * @return
	 */
	@Override
	public Customer findCustomerByEmailId(String emailId) {
		return custRep.findCustomerByEmailId(emailId);
	}

}
