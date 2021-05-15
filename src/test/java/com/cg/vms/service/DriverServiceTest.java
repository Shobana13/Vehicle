package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vms.entities.Driver;
@SpringBootTest
class DriverServiceTest {
	@Autowired
	IDriverService driService;

	@Test
	//@Disabled
	void testFindAllDriver() {
		List <Driver> driver= driService.findAllDriver();
		assertEquals(7,driver.size());
	}
	@Test
	//@Disabled
	void testCreateDriver() {
		Driver driver=new Driver(110,"Ram", "Bala","9876543235","ram23@gmail.com","T.nagar",500.0,"8076");
		Driver persistedDri= driService.addDriver(driver);
		assertEquals(110,persistedDri.getDriverId());
		assertEquals("Ram",persistedDri.getFirstName());
		assertEquals("Bala",persistedDri.getLastName());
		assertEquals("ram23@gmail.com",persistedDri.getEmail());
		assertEquals("9876543235",persistedDri.getContactNumber());
		assertEquals("T.nagar",persistedDri.getAddress());
		assertEquals(500.0,persistedDri.getChargesPerDay());
		assertEquals("8076",persistedDri.getLicenseNo());
	}
	@Test
	//@Disabled
	void testDeleteDriver() {
		Driver persistedDri= driService.deleteDriverById(110);
		assertEquals(110,persistedDri.getDriverId());
		assertEquals("Ram",persistedDri.getFirstName());
		assertEquals("Bala",persistedDri.getLastName());
		assertEquals("ram23@gmail.com",persistedDri.getEmail());
		assertEquals("9876543235",persistedDri.getContactNumber());
		assertEquals("T.nagar",persistedDri.getAddress());
		assertEquals(500.0,persistedDri.getChargesPerDay());
		assertEquals("8076",persistedDri.getLicenseNo());
		
	}
	@Test
	//@Disabled
	void testFindDriverById() {
		Driver driver= driService.viewDriver(110);
		assertEquals("Ram",driver.getFirstName());
		assertEquals("Bala",driver.getLastName());
		assertEquals("ram23@gmail.com",driver.getEmail());
		assertEquals("9876543235",driver.getContactNumber());
		assertEquals("T.nagar",driver.getAddress());
		assertEquals(500.0,driver.getChargesPerDay());
		assertEquals("8076",driver.getLicenseNo());
	}
	

}
