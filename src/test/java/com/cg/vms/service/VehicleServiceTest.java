package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vms.entities.Vehicle;

@SpringBootTest
class VehicleServiceTest {
	@Autowired
	IVehicleService vehService;
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CustomerServiceTest.class);

	/**
	 * Test case for the method getting all the Vehicle in the form of list
	 */
	@Test
	// @Disabled
	void testFindAllVehicle() {
		List<Vehicle> vehicle = vehService.findAllVehicle();
		logger.info(vehicle);
		assertEquals(4, vehicle.size());
	}

	/**
	 * Test case for the method Create Vehicle to the database
	 */
	@Test
	// @Disabled
	void testCreateVehicle() {
		Vehicle vehicle = new Vehicle(204, "TN 02 CV 0101", "Car", "A/C", "Good", "Ambattur", "6", 2.0, 2.0);
		Vehicle persistedVeh = vehService.addVehicle(vehicle);
		logger.info(persistedVeh);
		assertEquals(204, persistedVeh.getVehicleId());
		assertEquals("TN 02 CV 0101", persistedVeh.getVehicleNumber());
		assertEquals("Car", persistedVeh.getType());
		assertEquals("A/C", persistedVeh.getCategory());
		assertEquals("Good", persistedVeh.getDescription());
		assertEquals("Ambattur", persistedVeh.getLocation());
		assertEquals("6", persistedVeh.getCapacity());
		assertEquals(2.0, persistedVeh.getChargesPerKM());
		assertEquals(2.0, persistedVeh.getFixedCharges());
	}

	/**
	 * Test case for the method deleting the Vehicle by using VehicleId.
	 */
	@Test
	@Disabled
	void testDeleteVehicle() {
		Vehicle persistedVeh = vehService.deleteVehicleById(204);
		logger.info(persistedVeh);
		assertEquals(204, persistedVeh.getVehicleId());
		assertEquals("TN 02 CV 0101", persistedVeh.getVehicleNumber());
		assertEquals("Car", persistedVeh.getType());
		assertEquals("A/C", persistedVeh.getCategory());
		assertEquals("Good", persistedVeh.getDescription());
		assertEquals("Ambattur", persistedVeh.getLocation());
		assertEquals("6", persistedVeh.getCapacity());
		assertEquals(2.0, persistedVeh.getChargesPerKM());
		assertEquals(2.0, persistedVeh.getFixedCharges());

	}

	/**
	 * Test case for the method getting the Vehicle by using VehicleId
	 */
	@Test
	// @Disabled
	void testFindVehicleById() {
		Vehicle vehicle = vehService.findByVehId(204);
		logger.info(vehicle);
		assertEquals("TN 02 CV 0101", vehicle.getVehicleNumber());
		assertEquals("Car", vehicle.getType());
		assertEquals("A/C", vehicle.getCategory());
		assertEquals("Good", vehicle.getDescription());
		assertEquals("Ambattur", vehicle.getLocation());
		assertEquals("6", vehicle.getCapacity());
		assertEquals(2.0, vehicle.getChargesPerKM());
		assertEquals(2.0, vehicle.getFixedCharges());

	}

	/**
	 * Test case for the method updating the Vehicle details
	 */
	@Test
	// @Disabled
	void testUpdateVehicle() {
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleId(204);
		vehicle1.setVehicleNumber("TN 02 CV 0101");
		vehicle1.setType("Car");
		vehicle1.setCategory("A/C");
		vehicle1.setDescription("Good");
		vehicle1.setLocation("Ambattur");
		vehicle1.setCapacity("6");
		vehicle1.setChargesPerKM(2.0);
		vehicle1.setFixedCharges(2.0);
		Vehicle veh2 = vehService.update(204, vehicle1);
		logger.info(vehicle1);
		assertEquals("A/C", veh2.getCategory());
	}

	/**
	 * Test case for the method updating the VehicleNumber of the Vehicle
	 */
	@Test
	// @Disabled
	void testUpdateVehicleNumber() {
		Vehicle veh = new Vehicle();
		veh.setVehicleId(201);
		veh.setVehicleNumber("KA 22 CV 0101");
		Vehicle veh3 = vehService.updateVehicleNumber(veh);
		logger.info(veh);
		assertEquals("KA 22 CV 0101", veh3.getVehicleNumber());

	}

}
