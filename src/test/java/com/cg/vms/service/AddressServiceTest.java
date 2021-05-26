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

	// add address
	@Test
	//@Disabled
	void testAddAddress() {
		Address address = new Address(103, "kk road", "Tirunelveli");
		Address persistedCust = addrService.save(address);
		logger.info(persistedCust);
		assertEquals("kk road", persistedCust.getStreetName());
	}

	// delete address
	@Test
	@Disabled
	void testDeleteAddressId() {
		Address addr = addrService.deleteAddressById(103);
		logger.info(addr);
		assertEquals(103, addr.getAddressId());
	}

	// find all address
	@Test
	@Disabled
	void testFindAllAddress() {
		List<Address> addr = addrService.findAllAddresses();
		logger.info(addr);
		assertEquals(5, addr.size());
	}

	// view address by id
	@Test
	@Disabled
	void testViewAddressbyId() {
		Address addr = addrService.findAddressById(101);
		logger.info(addr);
		assertEquals("rasi street", addr.getStreetName());
	}

	// update address
	@Test
	@Disabled
	void testUpdateAddress() {
		Address address = new Address();
		address.setAddressId(102);
		address.setStreetName("raja street");
		address.setCity("Pondi");
		Address addr = addrService.update(address);
		logger.info(addr);
		assertEquals("Pondi", addr.getCity());
	}

}
