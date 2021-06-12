package com.cg.vms.service;


import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.exceptions.CustomerNotFoundException;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.CustomerLogin;
import com.cg.vms.repository.ICustomerLoginRepository;
import com.cg.vms.repository.ICustomerRepository;
@Service
public class CustomerLoginServiceImplementation implements ICustomerLoginService {
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerLoginServiceImplementation.class);
	
	@Autowired
	ICustomerLoginRepository loginRepo;
	@Autowired
	ICustomerRepository registerRepo;
	
	@Override
	public Customer login(CustomerLogin user) {  
		logger.info("Customer login");
		Optional<Customer> customer = Optional.ofNullable(registerRepo.findCustomerByEmailId(user.getEmailId()));
		Customer cust = null;
		if(customer.isPresent()) {
			Optional<CustomerLogin> dbUsr = loginRepo.findById(user.getEmailId());

			if ( !dbUsr.isPresent() || !dbUsr.get().isLoggedIn()) {
				user.setLoggedIn(true);
				loginRepo.save(user);
				cust=registerRepo.findCustomerByEmailId(user.getEmailId());
				return cust;
			} 
		}
		

		return cust;
	}

	@Override
	public String logout(String emailId) {
		logger.info("Customer logout");
		Optional<CustomerLogin> userfield = loginRepo.findById(emailId);
		logger.info(userfield.get());
		CustomerLogin dbUsr = null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if (dbUsr != null && dbUsr.getEmailId().equals(emailId) && dbUsr.isLoggedIn()) {

			dbUsr.setLoggedIn(false);
			loginRepo.save(dbUsr);
			return "logged out";
		}
		throw new CustomerNotFoundException("User not logged in");
	}

	public Customer getUser(String emailId) {
		Optional<CustomerLogin> userfield = loginRepo.findById(emailId);
		logger.info(userfield.get());
		CustomerLogin dbUsr = null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if (dbUsr != null && dbUsr.getEmailId().equals(emailId) && dbUsr.isLoggedIn()) {
			Optional<Customer> customer = Optional.ofNullable(registerRepo.findCustomerByEmailId(emailId));
			Customer cust=customer.get();
			Customer obj=new Customer();
			obj.setCustomerId(cust.getCustomerId());
			obj.setAddress(cust.getAddress());
			obj.setFirstName(cust.getFirstName());
			obj.setEmailId(cust.getEmailId());
			obj.setMobileNumber(cust.getMobileNumber());
			
			return obj;
		}
		
		return null;
		
	}

}