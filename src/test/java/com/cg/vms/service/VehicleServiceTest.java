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
class VehicleServiceTest {
	@Autowired
	IVehicleService vehService;

	@Test
	@Disabled
	void testFindAllVehicle() {
		List <Vehicle> vehicle= vehService.findAllVehicle();
		System.out.println(vehicle);
		assertEquals(4,vehicle.size());
	}
	@Test
	@Disabled
	void testCreateVehicle() {
		Vehicle vehicle=new Vehicle(4004,"TN 02 0101","Car", "non a/c","Fast","Ambattur","4",12.0,8.0);
		Driver driver=new Driver(304,"Ram", "Bala","9876543235","ram23@gmail.com","T.nagar",500.0,"8076");
		vehicle.setDriver(driver);
		driver.setVehicle(vehicle);
		Vehicle persistedVeh= vehService.addVehicle(vehicle);
		assertEquals(4004,persistedVeh.getVehicleId());
		assertEquals("TN 02 0101",persistedVeh.getVehicleNumber());
		assertEquals("Car",persistedVeh.getType());
		assertEquals("non a/c",persistedVeh.getCategory());
		assertEquals("Fast",persistedVeh.getDescription());
		assertEquals("Ambattur",persistedVeh.getLocation());
		assertEquals("4",persistedVeh.getCapacity());
		assertEquals(12.0,persistedVeh.getChargesPerKM());
		assertEquals(8.0,persistedVeh.getFixedCharges());
	}
	@Test
	@Disabled
	void testDeleteVehicle() {
		Vehicle persistedVeh= vehService.deleteVehicleById(4004);
		assertEquals(4004,persistedVeh.getVehicleId());
		assertEquals("TN 02 0101",persistedVeh.getVehicleNumber());
		assertEquals("Car",persistedVeh.getType());
		assertEquals("non a/c",persistedVeh.getCategory());
		assertEquals("Fast",persistedVeh.getDescription());
		assertEquals("Ambattur",persistedVeh.getLocation());
		assertEquals("4",persistedVeh.getCapacity());
		assertEquals(12.0,persistedVeh.getChargesPerKM());
		assertEquals(8.0,persistedVeh.getFixedCharges());
	}
	@Test
	@Disabled
	void testFindVehicleById() {
		Vehicle vehicle= vehService.findByVehId(4004);
		assertEquals("TN 02 0101",vehicle.getVehicleNumber());
		assertEquals("Car",vehicle.getType());
		assertEquals("a/c",vehicle.getCategory());
		assertEquals("Fast",vehicle.getDescription());
		assertEquals("Ambattur",vehicle.getLocation());
		assertEquals("4",vehicle.getCapacity());
		assertEquals(12.0,vehicle.getChargesPerKM());
		assertEquals(8.0,vehicle.getFixedCharges());
	}
	@Test
	@Disabled
	void testUpdateVehicle() {
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleId(4004);
		vehicle1.setVehicleNumber("TN 02 0101");
		vehicle1.setType("Car");
		vehicle1.setCategory("a/c");
		vehicle1.setDescription("Fast");
		vehicle1.setLocation("Ambattur");
		vehicle1.setCapacity("4");
		vehicle1.setChargesPerKM(12.0);
		vehicle1.setFixedCharges(8.0);
		Vehicle veh2=vehService.update(vehicle1);
		assertEquals("a/c",veh2.getCategory());
	}
	
	@Test
	@Disabled
	void testUpdateVehicleNumber() {
		Vehicle veh=new Vehicle();
		veh.setVehicleId(4003);
		veh.setVehicleNumber("KA 09 9999");
		Vehicle veh3=vehService.updateVehicleNumber(veh);
		assertEquals("KA 09 9999",veh3.getVehicleNumber());
		
	}

}
