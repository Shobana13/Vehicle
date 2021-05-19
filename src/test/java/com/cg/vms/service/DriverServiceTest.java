package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vms.entities.Driver;
import com.cg.vms.entities.Vehicle;
@SpringBootTest
class DriverServiceTest {
	@Autowired
	IDriverService driService;

	@Test
	@Disabled
	void testFindAllDriver() {
		List <Driver> driver= driService.findAllDriver();
		assertEquals(4,driver.size());
	}
	@Test
	@Disabled
	void testCreateDriver() {
		Vehicle vehicle=new Vehicle(4004,"Tn 02 0101","Car", "non a/c","Fast","Ambattur","4",12.0,8.0);
		Driver driver=new Driver(304,"Ram", "Bala","9876543235","ram23@gmail.com","T.nagar",500.0,"8076");
		vehicle.setDriver(driver);
		driver.setVehicle(vehicle);
		Driver persistedDri= driService.addDriver(driver);
		assertEquals(304,persistedDri.getDriverId());
		assertEquals("Ram",persistedDri.getFirstName());
		assertEquals("Bala",persistedDri.getLastName());
		assertEquals("ram23@gmail.com",persistedDri.getEmail());
		assertEquals("9876543235",persistedDri.getContactNumber());
		assertEquals("T.nagar",persistedDri.getAddress());
		assertEquals(500.0,persistedDri.getChargesPerDay());
		assertEquals("8076",persistedDri.getLicenseNo());
	}
	@Test
	@Disabled
	void testDeleteDriver() {
		Driver persistedDri= driService.deleteDriverById(304);
		assertEquals(304,persistedDri.getDriverId());
		assertEquals("Ram",persistedDri.getFirstName());
		assertEquals("Bala",persistedDri.getLastName());
		assertEquals("ram23@gmail.com",persistedDri.getEmail());
		assertEquals("9876543235",persistedDri.getContactNumber());
		assertEquals("T.nagar",persistedDri.getAddress());
		assertEquals(500.0,persistedDri.getChargesPerDay());
		assertEquals("8076",persistedDri.getLicenseNo());
		
	}
	@Test
	@Disabled
	void testFindDriverById() {
		Driver driver= driService.viewDriver(304);
		assertEquals("Vigneshan",driver.getFirstName());
		assertEquals("Kumar",driver.getLastName());
		assertEquals("vignesh11@gmail.com",driver.getEmail());
		assertEquals("9876543212",driver.getContactNumber());
		assertEquals("Krishnagiri",driver.getAddress());
		assertEquals(700.0,driver.getChargesPerDay());
		assertEquals("8989",driver.getLicenseNo());
	}
	
	@Test
	@Disabled
	void testUpdateDriver() {
		Driver driver1=new Driver();
		driver1.setDriverId(304);
		driver1.setFirstName("Vigneshan");
		driver1.setLastName("Kumar");
		driver1.setEmail("vignesh11@gmail.com");
		driver1.setContactNumber("9876543212");
		driver1.setAddress("Krishnagiri");
		driver1.setChargesPerDay(700.0);
		driver1.setLicenseNo("8989");
		Driver dri2=driService.update(driver1);
		assertEquals("Vigneshan",dri2.getFirstName());
	}	
	
	@Test
	@Disabled
	void testUpdateFirstName() {
		Driver dri=new Driver();
		dri.setDriverId(303);
		dri.setFirstName("Sanjay");
		Driver dri3=driService.updateFirstName(dri);
		assertEquals("Sanjay",dri3.getFirstName());
		
	}

}
