package com.cg.vms.service;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vms.entities.Address;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.Vehicle;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	ICustomerService custService;
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerServiceTest.class);

	/**
	 * Test case for the method getting all the customer in the form of list
	 */
	@Test
	@Disabled
	void testFindAllCustomer() {
		List<Customer> customer = custService.findAllCustomer();
		logger.info(customer);
		assertEquals(1, customer.size());
	}

	/**
	 * Test case for the method getting the customer by using customerId
	 */
	@Test
	 @Disabled
	void testViewCustomerbyId() {
		Customer cust1 = custService.viewCustomerbyId(2);
		logger.info(cust1);
		assertEquals("ram", cust1.getFirstName());
	}

	/**
	 * Test case for the method updating the customer details
	 */
	@Test
	@Disabled
	void testUpdateCustomer() {
		Customer customer1 = new Customer();
		customer1.setCustomerId(2);
		customer1.setFirstName("rosey");
		customer1.setLastName("kumar");
		customer1.setEmailId("ram@gmail.com");
		customer1.setMobileNumber("951688111");
		List<Address> addr= new ArrayList<>();
		Address a1=new Address(102, "Pondi", "Nehru Street");
		addr.add(a1);
		customer1.setAddress(addr);
		Customer cust2 = custService.updateCustomer(2, customer1);
		logger.info(cust2);
		assertEquals("rosey", cust2.getFirstName());
	}

	/**
	 * Test case for the method updating the FirstName of the customer
	 */
	@Test
	@Disabled
	void testUpdateFirstName() {
		Customer cust = new Customer();
		cust.setCustomerId(2);
		cust.setFirstName("rosey");
		Customer cust3 = custService.updateFirstName(2, cust);
		logger.info(cust3);
		assertEquals("rosey", cust3.getFirstName());

	}

	/**
	 * Test case for the method adding the customer to the database
	 */
	@Test
	//@Disabled
	void testAddCustomer() {
		Customer customer = new Customer(3, "rosey", "kumar", "951688111", "ram@gmail.com","sanam");
		Vehicle vehicle = new Vehicle(207, "TN02J0666", "bus", "A/C", "prime", "goa", "4", 600.0, 8000.0);
		List<Vehicle> vehicleList =new ArrayList<>();
		vehicleList.add(vehicle);
		Address address = new Address(106, "Pondi", "Nehru Street");
		List<Address> addr = new ArrayList<>();
		addr.add(address);
		customer.setAddress(addr);
		customer.setVehicle(vehicleList);
		Customer persistedCust = custService.addCustomer(customer);
		logger.info(customer);
		assertEquals("ram@gmail.com", persistedCust.getEmailId());

	}

	/**
	 * Test case for the method deleting the customer by using customerId.
	 */
	@Test
	@Disabled
	void testDeleteCustomerId() {
		Customer cust2 = custService.deleteCustomerbyId(2);
		logger.info(cust2);
		assertEquals("rosey", cust2.getFirstName());
	}

	/**
	 * Test case for the method getting the customer list based on the vehicle type
	 */
	@Test
	@Disabled
	void testFindByVehicleType() {
		List<Customer> cust3 = custService.findbyType("bus");
		logger.info(cust3);
		assertEquals(1, cust3.size());

	}

	/**
	 * Test case for the method getting the customer list based on the vehicle
	 * location
	 */
	@Test
	@Disabled
	void testFindByVehicleLocation() {
		List<Customer> cust4 = custService.findbyVehicleLocation("goa");
		logger.info(cust4);
		assertEquals(1, cust4.size());

	}
}