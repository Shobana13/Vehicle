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
	//@Disabled
	void testFindAllDriver() {
		List <Driver> driver= driService.findAllDriver();
		assertEquals(5,driver.size());
	}
	@Test
	//@Disabled
	void testCreateDriver() {
		Vehicle vehicle=new Vehicle(2005,"Tn 02 0101","Car", "non a/c","Fast","Ambattur","4",12.0,8.0);
		Driver driver=new Driver(115,"Ram", "Bala","9876543235","ram23@gmail.com","T.nagar",500.0,"8076");
		vehicle.setDriver(driver);
		driver.setVehicle(vehicle);
		Driver persistedDri= driService.addDriver(driver);
		assertEquals(115,persistedDri.getDriverId());
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
		Driver persistedDri= driService.deleteDriverById(114);
		assertEquals(114,persistedDri.getDriverId());
		assertEquals("Tony",persistedDri.getFirstName());
		assertEquals("Johnn",persistedDri.getLastName());
		assertEquals("johntony@gmail.com",persistedDri.getEmail());
		assertEquals("9876543212",persistedDri.getContactNumber());
		assertEquals("Avadi",persistedDri.getAddress());
		assertEquals(500.0,persistedDri.getChargesPerDay());
		assertEquals("1126",persistedDri.getLicenseNo());
		
	}
	@Test
	//@Disabled
	void testFindDriverById() {
		Driver driver= driService.viewDriver(112);
		assertEquals("Sam",driver.getFirstName());
		assertEquals("Antony",driver.getLastName());
		assertEquals("samantony21@gmail.com",driver.getEmail());
		assertEquals("9787843235",driver.getContactNumber());
		assertEquals("Madurai",driver.getAddress());
		assertEquals(500.0,driver.getChargesPerDay());
		assertEquals("1276",driver.getLicenseNo());
	}
	
	@Test
	//@Disabled
	void testUpdateDriver() {
		Driver driver1=new Driver();
		driver1.setDriverId(112);
		driver1.setFirstName("Rose");
		driver1.setLastName("catherine");
		driver1.setEmail("rose@gmail.com");
		driver1.setContactNumber("998899888");
		driver1.setAddress("T.nagar");
		driver1.setChargesPerDay(500.0);
		driver1.setLicenseNo("8076");
		Driver dri2=driService.update(driver1);
		assertEquals("Rose",dri2.getFirstName());
	}	
	
	@Test
	//@Disabled
	void testUpdateFirstName() {
		Driver dri=new Driver();
		dri.setDriverId(111);
		dri.setFirstName("Sanjana");
		Driver dri3=driService.updateFirstName(dri);
		assertEquals("Sanjana",dri3.getFirstName());
		
	}
	
	

}
