package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vms.entities.Vehicle;
@SpringBootTest
class VehicleServiceTest {
	@Autowired
	IVehicleService vehService;

	@Test
	//@Disabled
	void testFindAllVehicle() {
		List <Vehicle> vehicle= vehService.findAllVehicle();
		System.out.println(vehicle);
		assertEquals(6,vehicle.size());
	}
	@Test
	//@Disabled
	void testCreateVehicle() {
		Vehicle vehicle=new Vehicle(2009,"Tn 02 0101","Car", "non a/c","Fast","Ambattur","4",12.0,8.0);
		Vehicle persistedVeh= vehService.addVehicle(vehicle);
		assertEquals(2009,persistedVeh.getVehicleId());
		assertEquals("Tn 02 0101",persistedVeh.getVehicleNumber());
		assertEquals("Car",persistedVeh.getType());
		assertEquals("non a/c",persistedVeh.getCategory());
		assertEquals("Fast",persistedVeh.getDescription());
		assertEquals("Ambattur",persistedVeh.getLocation());
		assertEquals("4",persistedVeh.getCapacity());
		assertEquals(12.0,persistedVeh.getChargesPerKM());
		assertEquals(8.0,persistedVeh.getFixedCharges());
	}
	@Test
	//@Disabled
	void testDeleteVehicle() {
		Vehicle persistedVeh= vehService.deleteVehicleById(2009);
		assertEquals(2009,persistedVeh.getVehicleId());
		assertEquals("Tn 02 0101",persistedVeh.getVehicleNumber());
		assertEquals("Car",persistedVeh.getType());
		assertEquals("non a/c",persistedVeh.getCategory());
		assertEquals("Fast",persistedVeh.getDescription());
		assertEquals("Ambattur",persistedVeh.getLocation());
		assertEquals("4",persistedVeh.getCapacity());
		assertEquals(12.0,persistedVeh.getChargesPerKM());
		assertEquals(8.0,persistedVeh.getFixedCharges());
	}
	@Test
	//@Disabled
	void testFindVehicleById() {
		Vehicle vehicle= vehService.findByVehId(2009);
		assertEquals("Tn 02 0101",vehicle.getVehicleNumber());
		assertEquals("Car",vehicle.getType());
		assertEquals("non a/c",vehicle.getCategory());
		assertEquals("Fast",vehicle.getDescription());
		assertEquals("Ambattur",vehicle.getLocation());
		assertEquals("4",vehicle.getCapacity());
		assertEquals(12.0,vehicle.getChargesPerKM());
		assertEquals(8.0,vehicle.getFixedCharges());
	}

}
