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

import com.cg.vms.entities.Driver;
import com.cg.vms.repository.IDriverRepository;

@ExtendWith(SpringExtension.class)
public class DriverServiceMockitoTest {
	@InjectMocks
	DriverServiceImpl driService;

	@MockBean
	IDriverRepository driRep;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Mockito test case for the method Create the Driver to the database
	 */
	@Test
	// @Disabled
	void testCreateDriver() {
		Driver driver = new Driver(1, "Punitha", "Bala", "9822543235", "punitha23@gmail.com", "T.nagar", 500.0, "TN99 99180761212");
		Mockito.when(driRep.save(driver)).thenReturn(driver);
		Driver persisteddri = driService.addDriver(driver);
		assertEquals(1, persisteddri.getDriverId());
	}

	/**
	 * Mockito test case for the method getting all the Driver
	 */
	@Test
	// @Disabled
	void testViewAllDriver() {
		Driver driver1 = new Driver(1, "Punitha", "Bala", "9822543235", "punitha23@gmail.com", "T.nagar", 500.0,
				"TN9999180761212");
		Driver driver2 = new Driver(2, "Deepak", "Roy", "9876543235", "roydeepak23@gmail.com", "Avadi", 500.0, "TN99 99180761212");
		List<Driver> driverList = new ArrayList<>();
		driverList.add(driver1);
		driverList.add(driver2);
		Mockito.when(driRep.findAll()).thenReturn(driverList);
		List<Driver> driver = driService.findAllDriver();
		assertEquals(2, driver.size());
	}

	/**
	 * Mockito test case for the method deleting the Driver by using DriverId
	 */
	@Test
	// @Disabled
	void testDeleteDriver() {
		Driver driver1 = new Driver(1, "Punitha", "Bala", "9822543235", "punitha23@gmail.com", "T.nagar", 500.0,
				"TN9999180761212");
		Mockito.when(driRep.findById(1)).thenReturn(Optional.of(driver1));
		driRep.deleteById(1);
		Driver persisteddri = driService.deleteDriverById(1);
		assertEquals(1, persisteddri.getDriverId());
		assertEquals("Punitha", persisteddri.getFirstName());

	}

	/**
	 * Mockito test case for the method updating Firstname of the Driver
	 */
	@Test
	// @Disabled
	void testUpdateDriverFirstname() {
		Driver driver = new Driver(1, "Nithya", "shree", "9822543235", "nithya23@gmail.com", "Avadi", 500.0, "TN9999180761212");
		Mockito.when(driRep.findById(1)).thenReturn(Optional.of(driver));
		Mockito.when(driRep.save(driver)).thenReturn(driver);
		Driver persistedDri = driService.updateFirstName(driver);
		assertEquals(1, persistedDri.getDriverId());
		assertEquals("Nithya", persistedDri.getFirstName());
	}

	/**
	 * Mockito test case for the method getting the Driver by using DriverId
	 */
	@Test
	// @Disabled
	void testViewDriverbyId() {
		Driver driver = new Driver(1, "Nithya", "shree", "9822543235", "nithya23@gmail.com", "Avadi", 500.0, "TN99 99180761212");
		Mockito.when(driRep.findById(1)).thenReturn(Optional.of(driver));
		Driver persistedDri = driService.viewDriver(1);
		assertEquals("Nithya", persistedDri.getFirstName());
	}

	// UpdateDriver
	@Test
	// @Disabled
	void testUpdateDriver() {
		Driver driver1 = new Driver(1, "Nithya", "shree", "9822543235", "nithya23@gmail.com", "Avadi", 500.0, "TN99991807612");
		Mockito.when(driRep.findById(1)).thenReturn(Optional.of(driver1));
		Mockito.when(driRep.save(driver1)).thenReturn(driver1);
		Driver persisteddri = driService.update(1, driver1);
		assertEquals(1, persisteddri.getDriverId());
	}

}