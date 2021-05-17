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
	
	@Test
	@Disabled
	void testAddAddress(){
		Address address=new Address(4, "kk road", "Tirunelveli");
		Mockito.when(addrRep.save(address)).thenReturn(address);
		Address address1=addrService.save(address);
		assertEquals(4,address1.getAddressId());
	}
	

	@Test
	@Disabled
	void testDeleteAddressById() {
		Address address=new Address(4, "kk road", "Tirunelveli");
		Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
		addrService.deleteAddressById(4);
		assertEquals(4,address.getAddressId());
	}
	
	@Test
	@Disabled
	void testupdateAddress() {
		Address address=new Address(4, "kk road", "Tirunelveli");
		Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
		Mockito.when(addrRep.save(address)).thenReturn(address);
		Address address1=addrService.update(address);
		assertEquals("kk road",address1.getStreetName());
	}
	
	@Test
	@Disabled
	void testViewAddress() {
		Address address1=new Address(4, "kk road", "Tirunelveli");
		Address address2=new Address(5, "bypass road", "Tripur");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address1);
		addressList.add(address2);
		Mockito.when(addrRep.findAll()).thenReturn(addressList);
		List<Address> address = addrService.findAllAddresses();
		assertEquals(2, address.size());
	
	}
	
	@Test
	@Disabled
	void testViewbyId() {
	Address address=new Address(4,"kk road", "Tirunelveli");
	Mockito.when(addrRep.findById(4)).thenReturn(Optional.of(address));
	assertEquals(4,address.getAddressId());
}
	
}


