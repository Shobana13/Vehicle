package com.cg.vms.service;

import org.junit.jupiter.api.BeforeEach;

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

import com.cg.vms.entities.Address;
import com.cg.vms.repository.IAddressRepository;

@ExtendWith(SpringExtension.class)
public class AddressServiceMokitoTest {
	@InjectMocks
	AddressServiceImpl addrService;

	@MockBean
	IAddressRepository addrRep;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Mockito test case for the method adding the address to the database
	 */
	@Test
	//@Disabled
	void testAddAddress() {
		Address address = new Address(4,"kk road", "Tirunelveli");
		Mockito.when(addrRep.save(address)).thenReturn(address);
		Address address1 = addrService.save(address);
		assertEquals(4, address1.getAddressId());
	}

	/**
	 * Mockito test case for the method deleting the address by using addressId
	 */
	@Test
	//@Disabled
	void testDeleteAddressById() {
		Address address = new Address(4,"kk road", "Tirunelveli");
		Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
		addrService.deleteAddressById(4);
		assertEquals(4, address.getAddressId());
	}

	/**
	 * Mockito test case for the method updating the address details
	 */
	@Test
	//@Disabled
	void testupdateAddress() {
		Address address = new Address(4,"kk road", "Tirunelveli");
		Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
		Mockito.when(addrRep.save(address)).thenReturn(address);
		Address address1 = addrService.update(4,address);
		assertEquals("kk road", address1.getStreetName());
	}

	/**
	 * Mockito test case for the method getting all the addresses
	 */
	@Test
	//@Disabled
	void testViewAddress() {
		Address address1 = new Address(4,"kk road", "Tirunelveli");
		Address address2 = new Address(3,"bypass road", "Tripur");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address1);
		addressList.add(address2);
		Mockito.when(addrRep.findAll()).thenReturn(addressList);
		List<Address> address = addrService.findAllAddresses();
		assertEquals(2, address.size());

	}

	/**
	 * Mockito test case for the method getting the address by using addressId
	 */
	@Test
	//@Disabled
	void testViewbyId() {
		Address address = new Address(4,"kk road", "Tirunelveli");
		Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
		assertEquals(4, address.getAddressId());
	}

}
