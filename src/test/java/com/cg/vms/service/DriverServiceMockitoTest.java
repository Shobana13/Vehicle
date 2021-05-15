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

	@Test
	void testCreateDriver() {
		Driver driver = new Driver(1,"Punitha", "Bala","9822543235","punitha23@gmail.com","T.nagar",500.0,"8076");
		Mockito.when(driRep.save(driver)).thenReturn(driver);
		Driver persisteddri = driService.addDriver(driver);
		assertEquals(1, persisteddri.getDriverId());
	}

	@Test
	void testViewAllDriver() {
		Driver driver1 = new Driver(1,"Punitha", "Bala","9822543235","punitha23@gmail.com","T.nagar",500.0,"8076");
		Driver driver2 = new Driver(2,"Deepak", "Roy","9876543235","roydeepak23@gmail.com","Avadi",500.0,"8076");
		List<Driver> driverList = new ArrayList<>();
		driverList.add(driver1);
		driverList.add(driver2);
		Mockito.when(driRep.findAll()).thenReturn(driverList);
		List<Driver> driver = driService.findAllDriver();
		assertEquals(2, driver.size());
	}

	@Test
	void testDeleteDriver() {
		Driver driver1 =new Driver(1,"Punitha", "Bala","9822543235","punitha23@gmail.com","T.nagar",500.0,"8076");
		Mockito.when(driRep.findById(1)).thenReturn(Optional.of(driver1));
		driRep.deleteById(1);
		Driver persisteddri = driService.deleteDriverById(1);
		assertEquals(1, persisteddri.getDriverId());
		assertEquals("Punitha", persisteddri.getFirstName());

	}

	@Test
	void testUpdateDriverFirstname() {
		Driver driver = new Driver(1,"Nithya", "shree","9822543235","nithya23@gmail.com","Avadi",500.0,"5676");
		Mockito.when(driRep.findById(1)).thenReturn(Optional.of(driver));
		Mockito.when(driRep.save(driver)).thenReturn(driver);
		Driver persistedDri = driService.updateFirstName(driver);
		assertEquals(1, persistedDri.getDriverId());
		assertEquals("Nithya", persistedDri.getFirstName());
	}

	@Test
	void testViewDriverbyId() {
		Driver driver =new Driver(1,"Nithya", "shree","9822543235","nithya23@gmail.com","Avadi",500.0,"5676");
		Mockito.when(driRep.findById(1)).thenReturn(Optional.of(driver));
		Driver persistedDri = driService.viewDriver(1);
		assertEquals("Nithya", persistedDri.getFirstName());
	}

}