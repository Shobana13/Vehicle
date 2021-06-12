package com.cg.vms.controller;

import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vms.entities.Customer;
import com.cg.vms.exceptions.CustomerNotFoundException;
import com.cg.vms.service.ICustomerService;

@CrossOrigin
@RestController
public class CustomerController {

	/**
	 * We are autowiring the customer service layer to this controller layer of
	 * customer
	 * 
	 * @param customerServiceImpl
	 */
	@Autowired
	ICustomerService custService;

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerController.class);

	/**
	 * This controller is used to create a new or add new customer and redirects it
	 * to the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		logger.info("Adding customer in database");
		Customer cust = custService.findCustomerByEmailId(customer.getEmailId());
		if (cust == null) {
			custService.addCustomer(customer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			cust = null;
		}
		return new ResponseEntity<>(cust, HttpStatus.ALREADY_REPORTED);
	}

	/**
	 * This controller function perform deletion of a specific given customer and
	 * request the service to perform the action and returns the message as deleted
	 * else throw exception
	 * 
	 * @param customerid
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomerbyId(@PathVariable("id") int customerId)
			throws CustomerNotFoundException {
		logger.info("Deleting Customer in database by id");
		if (custService.deleteCustomerbyId(customerId) == null) {
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		return ResponseEntity.ok().body(custService.deleteCustomerbyId(customerId));
	}

	/**
	 * This controller is used to return and list all the customer found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> findAllCustomer() {
		logger.info("Getting all customer details");
		return ResponseEntity.ok(custService.findAllCustomer());
	}

	/**
	 * This controller is used to get a specific customer on basis of ID
	 * 
	 * @param id
	 * @return
	 * @throws customerNotFoundException
	 */
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> viewCustomerbyId(@PathVariable("id") int customerId)
			throws CustomerNotFoundException {
		logger.info("Getting customer details by id ");
		if (custService.viewCustomerbyId(customerId) == null) {
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		Customer customer = custService.viewCustomerbyId(customerId);
		return ResponseEntity.ok().body(customer);

	}

	/**
	 * This function is used to update a specific customer on basis of given
	 * customer id and returns exception if given customer id is not found.
	 * 
	 * @param id
	 * @param customer
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@PutMapping("/customer/update/{id}")
	public ResponseEntity<Customer> update(@PathVariable("id") int customerId, @RequestBody Customer customer)
			throws CustomerNotFoundException {
		logger.info("Updating customer details");
		if (custService.updateCustomer(customerId, customer) == null) {
			throw new CustomerNotFoundException("Customer Not Found:" + customer.getCustomerId());
		}
		return ResponseEntity.ok().body(custService.updateCustomer(customerId, customer));
	}

	/**
	 * This function is used to update a specific customer firstName on basis of
	 * given customer id and returns exception if given customer id is not found.
	 * 
	 * @param id
	 * @param customer
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@PatchMapping("/customer/{id}")
	public ResponseEntity<Customer> updateFirstName(@PathVariable("id") int customerId,
			@Valid @RequestBody Customer customer) throws CustomerNotFoundException {
		logger.info("Updating firstname of customer");
		if (custService.updateFirstName(customerId, customer) == null) {
			throw new CustomerNotFoundException("Customer not found with this id:" + customerId);
		}
		return ResponseEntity.ok().body(custService.updateFirstName(customerId, customer));
	}

	/**
	 * This controller is used to get all customer on basis of vehicle type
	 * 
	 * @param type of the vehicle
	 * @return
	 */
	@GetMapping("/customer/type/{type}")
	public ResponseEntity<List<Customer>> findbyType(@PathVariable("type") String type) {
		logger.info("Getting customer  by vehicle type");
		return ResponseEntity.ok().body(custService.findbyType(type));

	}

	/**
	 * This controller is used to get all customer on basis of vehicle location
	 * 
	 * @param location of vehicle
	 * @return
	 */
	@GetMapping("/customer/location/{location}")
	public ResponseEntity<List<Customer>> findbyVehicleLocation(@PathVariable("location") String location) {
		logger.info("Getting customer  by vehicle location");
		return ResponseEntity.ok().body(custService.findbyVehicleLocation(location));

	}

}