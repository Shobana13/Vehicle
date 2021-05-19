package com.cg.vms.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.cg.vms.dto.VehicleDto;
import com.cg.vms.entities.Customer;
import com.cg.vms.repository.ICustomerRepository;

@ExtendWith(SpringExtension.class)
public class CustomerServiceMokitoTest {
	@InjectMocks
	CustomerServiceImpl custService;

	@MockBean
	ICustomerRepository custRep;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	//add Customer
	@Test
	//@Disabled
	void testCreateCustomer() {
		Customer customer = new Customer(1, "tom", "son", "951771122", "tom@gmail.com");
		Mockito.when(custRep.save(customer)).thenReturn(customer);
		Customer persistedCust = custService.addCustomer(customer);
		assertEquals(1, persistedCust.getCustomerId());
	}

	//view all the customer
	@Test
	//@Disabled
	void testViewAllCustomer() {
		Customer customer1 = new Customer(1, "tom", "son", "951771122", "tom@gmail.com");
		Customer customer2 = new Customer(2, "jerry", "lee", "951998122", "jerry@gmail.com");
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		Mockito.when(custRep.findAll()).thenReturn(customerList);
		List<Customer> customer = custService.findAllCustomer();
		assertEquals(2, customer.size());
	}

	//update customer
	@Test
	//@Disabled
	void testUpdateCustomer() {
		Customer customer1 = new Customer(1, "tommy", "cruise", "951771122", "tom@gmail.com");
		Mockito.when(custRep.findById(1)).thenReturn(Optional.of(customer1));
		Mockito.when(custRep.save(customer1)).thenReturn(customer1);
		Customer persistedCust = custService.updateCustomer(customer1);
		assertEquals(1, persistedCust.getCustomerId());
	}

	//delete customer
	@Test
	//@Disabled
	void testDeleteCustomer() {
		Customer customer = new Customer(1, "tommy", "cruise", "951771122", "tom@gmail.com");
		Mockito.when(custRep.findById(1)).thenReturn(Optional.of(customer));
		custRep.deleteById(1);
		Customer persistedCust = custService.deleteCustomerbyId(1);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("tommy", persistedCust.getFirstName());

	}

	//update firstName
	@Test
	//@Disabled
	void testUpdateCustomerbyFirstname() {
		Customer customer = new Customer(1, "jen", "cru", "951771122", "tom@gmail.com");
		Mockito.when(custRep.findById(1)).thenReturn(Optional.of(customer));
		Mockito.when(custRep.save(customer)).thenReturn(customer);
		Customer persistedCust = custService.updateFirstName(1, customer);
		assertEquals(1, persistedCust.getCustomerId());
		assertEquals("jen", persistedCust.getFirstName());
	}

	//view customer by id
	@Test
	//@Disabled
	void testViewCustomerbyId() {
		Customer customer = new Customer(1, "jen", "cru", "951771122", "tom@gmail.com");
		Mockito.when(custRep.findById(1)).thenReturn(Optional.of(customer));
		Customer persistedCust = custService.viewCustomerbyId(1);
		assertEquals("jen", persistedCust.getFirstName());
	}

	//view customer by vehicle type
	@Test
	//@Disabled
	void testViewCustomerbyVehicleType() {
		Customer customer1 = new Customer(1, "tommy", "cruise", "951771122", "tom@gmail.com");
		VehicleDto vehicle1 = new VehicleDto(101, "TN02J0666", "car", "A/C", "prime", "goa", "13", 600.0, 8000.0);
		Customer customer2 = new Customer(2, "jerry", "lee", "951998122", "jerry@gmail.com");
		VehicleDto vehicle2 = new VehicleDto(102, "TN02J0666", "car", "A/C", "prime", "goa", "13", 600.0, 8000.0);
		customer1.setVehicledto(vehicle1);
		customer2.setVehicledto(vehicle2);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		Mockito.when(custRep.findbyType("car")).thenReturn(customerList);
		List<Customer> cust3 = custService.findbyType("car");
		assertEquals(2, cust3.size());
	}

	//view customer by location
	@Test
	//@Disabled
	void testViewCustomerbyVehicleLocation() {

		Customer customer1 = new Customer(1, "tommy", "cruise", "951771122", "tom@gmail.com");
		VehicleDto vehicle1 = new VehicleDto(101, "TN02J0666", "bus", "A/C", "prime", "chennai", "13", 600.0, 8000.0);
		Customer customer2 = new Customer(2, "jerry", "lee", "951998122", "jerry@gmail.com");
		VehicleDto vehicle2 = new VehicleDto(102, "TN02J0776", "car", "nonA/C", "prime", "chennai", "13", 600.0, 8000.0);
		customer1.setVehicledto(vehicle1);
		customer2.setVehicledto(vehicle2);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		Mockito.when(custRep.findbyVehicleLocation("chennai")).thenReturn(customerList);
		List<Customer> cust3 = custService.findbyVehicleLocation("chennai");
		assertEquals(2, cust3.size());
	}

}
