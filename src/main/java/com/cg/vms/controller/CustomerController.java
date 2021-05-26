package com.cg.vms.controller;

import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class CustomerController {

	@Autowired
	ICustomerService custService;

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerController.class);

	// addCustomer
	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		logger.info("Adding Customer in database");
		return custService.addCustomer(customer);
	}

	// delete Customer by id
	@DeleteMapping("/customer/id/{id}")
	public Customer deleteCustomerbyId(@PathVariable("id") int customerId) {
		logger.info("Deleting Customer in database by id");
		if (custService.deleteCustomerbyId(customerId) == null) {
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		return custService.deleteCustomerbyId(customerId);
	}

	// View all customer
	@GetMapping("/customer")
	public List<Customer> findAllCustomer() {
		logger.info("Getting all customer details");
		return custService.findAllCustomer();
	}

	// View customer by id
	@GetMapping("/customer/{id}")
	public Customer viewCustomerbyId(@PathVariable("id") int customerId) {
		logger.info("Getting customer details by id ");
		if (custService.viewCustomerbyId(customerId) == null) {
			//if customer not found by the given id then it will throw an exception
			throw new CustomerNotFoundException("Customer not found with this id" + customerId);
		}
		return custService.viewCustomerbyId(customerId);

	}

	// Update Customer
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		logger.info("Updating customer details");
		if (custService.updateCustomer(customer) == null) {
			//if customer not found by the given id then it will throw an error
			throw new CustomerNotFoundException("Customer Not Found:" + customer.getCustomerId());
		}
		return custService.updateCustomer(customer);
	}

	// Update Customer firstName
	@PatchMapping("/customer/{id}")
	public Customer updateFirstName(@PathVariable("id") int customerId, @Valid @RequestBody Customer customer) {
		logger.info("Updating firstname of customer");
		if (custService.updateFirstName(customerId, customer) == null) {
			//if customer not found by the given id then it will throw an exception
			throw new CustomerNotFoundException("Customer not found with this id:" + customerId);
		}
		return custService.updateFirstName(customerId, customer);
	}

	// view customer by vehicle type
	@GetMapping("/customer/type/{type}")
	public List<Customer> findbyType(@PathVariable("type") String type) {
		logger.info("Getting customer  by vehicle type");
		return custService.findbyType(type);

	}

	// view customer by vehicle location
	@GetMapping("/customer/location/{location}")
	public List<Customer> findbyVehicleLocation(@PathVariable("location") String location) {
		logger.info("Getting customer  by vehicle location");
		return custService.findbyVehicleLocation(location);

	}

}
