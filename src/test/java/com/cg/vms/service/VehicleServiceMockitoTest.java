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

import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IVehicleRepository;

@ExtendWith(SpringExtension.class)
public class VehicleServiceMockitoTest {
	@InjectMocks
	VehicleServiceImpl vehService;

	@MockBean
	IVehicleRepository vehRep;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Mockito test case for the method Create the Vehicle to the database
	 */
	@Test
	// @Disabled
	void testCreateVehicle() {
		Vehicle vehicle = new Vehicle(1, "TN 02 JD 0666", "bus", "A/C", "Deluxe", "goa", "13", 6.0, 8.0);
		Mockito.when(vehRep.save(vehicle)).thenReturn(vehicle);
		Vehicle persistedveh = vehService.addVehicle(vehicle);
		assertEquals(1, persistedveh.getVehicleId());
	}

	/**
	 * Mockito test case for the method getting all the Vehicle
	 */
	@Test
	// @Disabled
	void testViewAllVehicle() {
		Vehicle vehicle1 = new Vehicle(1, "TN0 2J DS 0666", "bus", "A/C", "Deluxe", "goa", "13", 6.0, 8.0);
		Vehicle vehicle2 = new Vehicle(102, " TN 23 DS 0266", "car", "non A/C", "Deluxe", "Chennai", "13", 6.0, 8.0);
		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(vehicle1);
		vehicleList.add(vehicle2);
		Mockito.when(vehRep.findAll()).thenReturn(vehicleList);
		List<Vehicle> driver = vehService.findAllVehicle();
		assertEquals(2, driver.size());
	}

	/**
	 * Mockito test case for the method deleting the Vehicle by using vehicleId
	 */
	@Test
	// @Disabled
	void testDeleteVehicle() {
		Vehicle vehicle1 = new Vehicle(1, "TN 02 ER 0666", "bus", "A/C", "Deluxe", "goa", "13", 6.0, 8.0);
		Mockito.when(vehRep.findById(1)).thenReturn(Optional.of(vehicle1));
		vehRep.deleteById(1);
		Vehicle persistedveh = vehService.deleteVehicleById(1);
		assertEquals(1, persistedveh.getVehicleId());
		assertEquals("TN 02 ER 0666", persistedveh.getVehicleNumber());

	}

	/**
	 * Mockito test case for the method updating VehicleNumber of the Vehicle
	 */
	@Test
	// @Disabled
	void testUpdateVehicleNumber() {
		Vehicle vehicle = new Vehicle(1, "TN 23 ER 0266", "car", "Non A/C", "Deluxe", "Chennai", "13", 6.0, 8.0);
		Mockito.when(vehRep.findById(1)).thenReturn(Optional.of(vehicle));
		Mockito.when(vehRep.save(vehicle)).thenReturn(vehicle);
		Vehicle persistedVeh = vehService.updateVehicleNumber(vehicle);
		assertEquals("TN 23 ER 0266", persistedVeh.getVehicleNumber());
		assertEquals("TN 23 ER 0266", persistedVeh.getVehicleNumber());
	}

	/**
	 * Mockito test case for the method getting the Vehicle by using VehicleId
	 */
	@Test
	// @Disabled
	void testViewVehiclebyId() {
		Vehicle vehicle = new Vehicle(1, "KA 23 DS 0266", "car", "non A/C", "Deluxe", "Chennai", "13", 6.0, 8.0);
		Mockito.when(vehRep.findById(1)).thenReturn(Optional.of(vehicle));
		Vehicle persistedveh = vehService.viewVehicle(1);
		assertEquals("car", persistedveh.getType());
	}

	/**
	 * Mockito test case for the method updating the Vehicle details
	 */
	@Test
	// @Disabled
	void testUpdateVehicle() {
		Vehicle vehicle = new Vehicle(1, "KA 23 AS 0266", "car", "non A/C", "Deluxe", "Chennai", "13", 6.0, 8.0);
		Mockito.when(vehRep.findById(1)).thenReturn(Optional.of(vehicle));
		Mockito.when(vehRep.save(vehicle)).thenReturn(vehicle);
		Vehicle persistedveh = vehService.update(1, vehicle);
		assertEquals(1, persistedveh.getVehicleId());
	}

}