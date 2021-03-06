package com.cg.vms.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.exceptions.CustomerNotFoundException;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.CustomerLogin;
import com.cg.vms.service.ICustomerLoginService;
import com.cg.vms.service.ICustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerLoginController {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerLoginController.class);

	@Autowired  
	ICustomerService custService;
	@Autowired
	ICustomerLoginService loginService;

	@PostMapping("/customer/login")
	// login service
	public ResponseEntity<Customer> Login(@Valid @RequestBody CustomerLogin loginentity) {
		logger.info("Login by the customer");
		Customer cust = null;
		if (loginentity.getEmailId() == null || loginentity.getPassword() == null || loginentity.getEmailId().equals("")
				|| loginentity.getPassword().equals("")) {
			throw new CustomerNotFoundException("Userid or Password is invalid");
		}
		Customer userfield = custService.findCustomerByEmailId(loginentity.getEmailId());
		if (userfield != null && userfield.getCustomerPassword().equals(loginentity.getPassword())) {
			cust = loginService.login(loginentity);
		} else if (userfield != null) {
			throw new CustomerNotFoundException("Userid or Password is invalid");
		} else {
			throw new CustomerNotFoundException("User Not Registered");
		}
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}

	// logout service  
	@PostMapping("customer/logout/{emailId}")
	public String Logout(@Email @PathVariable("emailId") String emailId) {
		logger.info("Logout by the customer");
		return loginService.logout(emailId);
	}

	// get user auth service
	@GetMapping("customer/getuser/{emailId}")
	public Customer getUser(@Email @PathVariable("emailId") String emailId) {
		logger.info("getting customer");
		return loginService.getUser(emailId);
	}
}
