package com.cg.vms.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vms.dto.VehicleDto;
import com.cg.vms.entities.Address;
import com.cg.vms.entities.Customer;


@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	ICustomerService custService;
	
	//add Customer
	@Test
	@Disabled
	void testFindAllCustomer() {
		List<Customer> customer=custService.findAllCustomer();
		System.out.println(customer);
		assertEquals(4, customer.size());
	}
	
	//view customer by id
	@Test
	//@Disabled
	void testViewCustomerbyId() {
		Customer cust1=custService.viewCustomerbyId(1);
		System.out.println(cust1);
		assertEquals("shobi",cust1.getFirstName());
	}
	
	//update the customer
	@Test
	@Disabled
	void testUpdateCustomer() {
		Customer customer1=new Customer();
		customer1.setCustomerId(2);
		customer1.setFirstName("Rose");
		customer1.setLastName("catherine");
		customer1.setEmailId("rose@gmail.com");
		customer1.setMobileNumber("998899888");
		Address add=new Address(102,"Pondi","Nehru Street");
		customer1.setAddress(add);
		Customer cust2=custService.updateCustomer(customer1);
		assertEquals("Rose",cust2.getFirstName());
	}	
	
	//Update Firstname
	@Test
	//@Disabled
	void testUpdateFirstName() {
		Customer cust=new Customer();
		cust.setCustomerId(2);
		cust.setFirstName("rosey");
		Customer cust3=custService.updateFirstName(2,cust);
		assertEquals("rosey",cust3.getFirstName());
		
	}
	
	// add Customer
	@Test
	@Disabled
	void testAddCustomer() {
		Customer customer=new Customer(5,"ram","kumar","951881122","ram@gmail.com");
		VehicleDto vehicle=new VehicleDto(205,"TN99K9989","car","A/C","prime","Tanjore","4",800.0,8000.0);
		Address address = new Address(105,"Renu road", "Trichy");
		customer.setAddress(address);
		customer.setVehicledto(vehicle);
		Customer persistedCust=custService.addCustomer(customer);
		assertEquals("ram@gmail.com", persistedCust.getEmailId());
		
	}
	
	//Delete customer by id
    @Test
	@Disabled
	 void testDeleteCustomerId() {
		Customer cust2=custService.deleteCustomerbyId(4);
		assertEquals("tom",cust2.getFirstName());
	}
   
    //get customer by type
   @Test
   //@Disabled
    void testFindByVehicleType() {
    	List<Customer> cust3=custService.findbyType("bus");
    	assertEquals(3,cust3.size());
    	
    }
    
   //get customer by location
   @Test
   //@Disabled
    void testFindByVehicleLocation() {
    	List<Customer> cust4=custService.findbyVehicleLocation("chennai");
    	assertEquals(2,cust4.size());
    	
    }
 }
