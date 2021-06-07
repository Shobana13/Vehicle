package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vms.entities.Driver;
import com.cg.vms.entities.Vehicle;

@SpringBootTest
class DriverServiceTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DriverServiceTest.class);
	@Autowired
	IDriverService driService;

	/**
	 * Test case for the method getting all the Driver in the form of list
	 */
	@Test
	// @Disabled
	void testFindAllDriver() {
		List<Driver> driver = driService.findAllDriver();
		logger.info(driver);
		assertEquals(4, driver.size());
	}

	/**
	 * Test case for the method Create Driver to the database
	 */
	@Test
	// @Disabled
	void testCreateDriver() {
		Driver driver = new Driver(104, "Ram", "Bala", "9876543235", "ram23@gmail.com", "T.nagar", 500.0,
				"TN23 23435678112");
		Driver persistedDri = driService.addDriver(driver);
		logger.info(driver);
		assertEquals(104, persistedDri.getDriverId());
		assertEquals("Ram", persistedDri.getFirstName());
		assertEquals("Bala", persistedDri.getLastName());
		assertEquals("ram23@gmail.com", persistedDri.getEmail());
		assertEquals("9876543235", persistedDri.getContactNumber());
		assertEquals("T.nagar", persistedDri.getAddress());
		assertEquals(500.0, persistedDri.getChargesPerDay());
		assertEquals("TN23 23435678112", persistedDri.getLicenseNo());
	}

	/**
	 * Test case for the method deleting the Driver by using DriverId.
	 */
	@Test
	@Disabled
	void testDeleteDriver() {
		Driver persistedDri = driService.deleteDriverById(104);
		logger.info(persistedDri);
		assertEquals(104, persistedDri.getDriverId());
		assertEquals("Ram", persistedDri.getFirstName());
		assertEquals("Bala", persistedDri.getLastName());
		assertEquals("ram23@gmail.com", persistedDri.getEmail());
		assertEquals("9876543235", persistedDri.getContactNumber());
		assertEquals("T.nagar", persistedDri.getAddress());
		assertEquals(500.0, persistedDri.getChargesPerDay());
		assertEquals("TN23 23435678112", persistedDri.getLicenseNo());

	}

	/**
	 * Test case for the method getting the Driver by using DriverId
	 */
	@Test
	// @Disabled
	void testFindDriverById() {
		Driver driver = driService.viewDriver(102);
		logger.info(driver);
		assertEquals("Vigneshan", driver.getFirstName());
		assertEquals("Krish", driver.getLastName());
		assertEquals("samvx23@gmail.com", driver.getEmail());
		assertEquals("9876222213", driver.getContactNumber());
		assertEquals("Madurai", driver.getAddress());
		assertEquals(800.0, driver.getChargesPerDay());
		assertEquals("TN23 43215543212", driver.getLicenseNo());
	}

	/**
	 * Test case for the method updating the Driver details
	 */
	@Test
	// @Disabled
	void testUpdateDriver() {
		Driver driver1 = new Driver();
		driver1.setDriverId(102);
		driver1.setFirstName("Vigneshan");
		driver1.setLastName("Krish");
		driver1.setEmail("samvx23@gmail.com");
		driver1.setContactNumber("9876222213");
		driver1.setAddress("Madurai");
		driver1.setChargesPerDay(800.0);
		driver1.setLicenseNo("TN23 43215543212");
		Driver dri2 = driService.update(102, driver1);
		logger.info(driver1);
		assertEquals("Vigneshan", dri2.getFirstName());
	}

	/**
	 * Test case for the method updating the FirstName of the driver
	 */
	@Test
	// @Disabled
	void testUpdateFirstName() {
		Driver dri = new Driver();
		dri.setDriverId(101);
		dri.setFirstName("Sanjay");
		Driver dri3 = driService.updateFirstName(dri);
		logger.info(dri);
		assertEquals("Sanjay", dri3.getFirstName());

	}

}
