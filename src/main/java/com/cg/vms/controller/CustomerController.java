package com.cg.vms.controller;
import java.util.List;
import javax.validation.Valid;
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
	
	//addCustomer
	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return custService.addCustomer(customer);
	}
	
	//delete Customer by id
	@DeleteMapping("/customer/id/{id}")
	public Customer deleteCustomerbyId(@PathVariable("id") int customerId) {
	if(custService.deleteCustomerbyId(customerId)==null) {
			throw new CustomerNotFoundException("Customer not found with this id" +customerId);
		}
		return custService.deleteCustomerbyId(customerId);
	}
	
	//View all customer
	@GetMapping("/customer")
	public List<Customer> findAllCustomer() {
	return custService.findAllCustomer();
	}
	
	//View customer by id
	@GetMapping("/customer/{id}")
	public Customer viewCustomerbyId(@PathVariable("id") int customerId){
		if(custService.viewCustomerbyId(customerId)==null) {
			throw new CustomerNotFoundException("Customer not found with this id" +customerId);
		}
		return custService.viewCustomerbyId(customerId);
		
	}
	
	//Update Customer 
	@PutMapping("/customer") 
	public Customer updateCustomer( @RequestBody Customer customer) {
		if(custService.updateCustomer(customer)==null) {
			throw new CustomerNotFoundException("Customer Not Found:" +customer.getCustomerId());
		}
		return custService.updateCustomer(customer);
	}
	
	//Update Customer firstName
	@PatchMapping("/customer/{id}")
	public Customer updateFirstName(@PathVariable("id") int customerId,@Valid @RequestBody Customer customer) {
		if(custService.updateFirstName(customerId, customer)==null) {
			throw new CustomerNotFoundException("Customer not found with this id:" + customerId);
		}	
	return custService.updateFirstName(customerId,customer);
	}
	
	//view customer by vehicle type
	@GetMapping("/customer/type/{type}")
	public List<Customer> findbyType(@PathVariable("type") String type){
		return custService.findbyType(type);
		
	}
	
	//view customer by vehicle location
	@GetMapping("/customer/location/{location}")
	public List<Customer> findbyVehicleLocation(@PathVariable("location") String location){
		return custService.findbyVehicleLocation(location);
		
	}

}
