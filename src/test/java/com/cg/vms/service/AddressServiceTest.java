package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vms.entities.Address;


@SpringBootTest
public class AddressServiceTest {

	@Autowired
	IAddressService addrService;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressServiceTest.class);

	/**
	 * Test case for the method adding the address to the database
	 */
	@Test
	//@Disabled
	void testAddAddress() {
		Address address = new Address(101,"LL street", "Trichy");
		Address persistedCust = addrService.save(address);
		logger.info(persistedCust);
		assertEquals("LL street", persistedCust.getStreetName());
	}

	/**
	 * Test case for the method deleting the address by using addressId.
	 */
	@Test
	@Disabled
	void testDeleteAddressId() {
		Address addr = addrService.deleteAddressById(103);
		logger.info(addr);
		assertEquals(103, addr.getAddressId());
	}

	/**
	 * Test case for the method getting all the address in the form of list
	 */
	@Test
	//@Disabled
	void testFindAllAddress() {
		List<Address> addr = addrService.findAllAddresses();
		logger.info(addr);
		assertEquals(5, addr.size());
	}

	/**
	 * Test case for the method getting the address by using addressId
	 */
	@Test
	//@Disabled
	void testViewAddressbyId() {
		Address addr = addrService.findAddressById(101);
		logger.info(addr);
		assertEquals("KK street", addr.getStreetName());
	}

	/**
	 * Test case for the method updating the address details
	 */
	@Test
	//@Disabled
	void testUpdateAddress() {
		Address address = new Address();
		address.setAddressId(102);
		address.setStreetName("Nehru street");
		address.setCity("Pondi");
		Address addr = addrService.update(102,address);
		logger.info(addr);
		assertEquals("Pondi", addr.getCity());
	}

}
