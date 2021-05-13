package com.cg.vms.service;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vms.entities.Address;


@SpringBootTest
public class AddressServiceTest {

	
	@Autowired
	IAddressService addrService;

	@Test
	@Disabled
	void testAddCustomer() {
		Address address = new Address(4, "kk road", "Tirunelveli");
		Address persistedCust = addrService.save(address);
		assertEquals("kk road",persistedCust.getStreetName());
	}

	@Test
	//@Disabled
	void testDeleteAddressId() {
		Address addr = addrService.deleteAddressById(4);
		assertEquals(4, addr.getAddressId());
	}
	
	@Test
	@Disabled
	void testFindAllAddress() {
		List<Address> addr=addrService.findAllAddresses();
		assertEquals(4, addr.size());
	}
	
	@Test
	@Disabled
	void testViewAddressbyId() {
		Address addr=addrService.findAddressById(1);
		System.out.println(addr);
		assertEquals("M.M road", addr.getStreetName());
	}
	
	@Test
	@Disabled
	void testUpdateAddress() {
		Address address=new Address();
		address.setAddressId(1);
		address.setStreetName("rasi street");
		address.setCity("karur");
		Address addr=addrService.update(address);
		assertEquals("karur",addr.getCity());
	}	
	
}
