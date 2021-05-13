package com.cg.vms.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
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
	
	@Test
	@Disabled
	void testFindAllCustomer() {
		List<Customer> customer=custService.findAllCustomer();
		System.out.println(customer);
		assertEquals(2, customer.size());
	}
	
	@Test
	@Disabled
	void testViewCustomerbyId() {
		Customer cust=new Customer();
		cust.setCustomerId(1);
		Customer cust1=custService.viewCustomerbyId(1);
		System.out.println(cust1);
		assertEquals("shobi",cust1.getFirstName());
	}
	
	@Test
	@Disabled
	void testViewCustomer() {
		Customer customer=new Customer(1);
		Customer cust=custService.viewCustomer(customer);
		assertEquals("tom",cust.getFirstName());
		
	}
	
	
	
	@Test
	@Disabled
	void testUpdateCustomer() {
		Customer customer1=new Customer();
		customer1.setCustomerId(2);
		customer1.setFirstName("Rose");
		customer1.setLastName("catherine");
		customer1.setEmailId("rose@gmail.com");
		customer1.setMobileNumber("998899888");
		Address add=new Address(2,"V.R road","Coimbatore");
		customer1.setAddress(add);
		Customer cust2=custService.update(customer1);
		assertEquals("Rose",cust2.getFirstName());
	}	
	
	@Test
	@Disabled
	void testUpdateFirstName() {
		Customer cust=new Customer();
		cust.setCustomerId(2);
		cust.setFirstName("rosee");
		Customer cust3=custService.updateFirstName(2,cust);
		assertEquals("rosee",cust3.getFirstName());
		
	}
	@Test
	@Disabled
	void testAddCustomer() {
		Customer customer=new Customer(1,"tom","son","951771122","tom@gmail.com");
		Vehicle vehicle=new Vehicle(101,"TN02J0666","bus","A/C","prime","goa","13",600.0,8000.0);
		Address address = new Address(1,"M.M road", "Salem");
		customer.setAddress(address);
		customer.setVehicle(vehicle);
		Customer persistedCust=custService.addCustomer(customer);
		assertEquals("tom@gmail.com", persistedCust.getEmailId());
		
	}
	
    @Test
	@Disabled
	 void testDeleteCustomerId() {
		Customer cust2=custService.deleteCustomerbyId(4);
		assertEquals("Neeluuu",cust2.getFirstName());
	}
    
    @Test
    @Disabled
    void testFindByVehicleType() {
    	List<Customer> cust3=custService.findbyType("bus");
    	assertEquals(2,cust3.size());
    	
    }
    
    @Test
    @Disabled
    void testFindByVehicleLocation() {
    	List<Customer> cust4=custService.findbyVehicleLocation("chennai");
    	assertEquals(2,cust4.size());
    	
    }
    
}
