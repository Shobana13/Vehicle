package com.cg.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Vehicle;
import com.cg.vms.exceptions.VehicleNotFoundException;
import com.cg.vms.service.IVehicleService;

@RestController
public class VehicleController {

	@Autowired
	IVehicleService vehService;
	
	

	// Add Vehicle
	@PostMapping("/vehicle")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return vehService.addVehicle(vehicle);
	}

	//Find All Vehicle
	@GetMapping("/vehicle")
	public List<Vehicle> findAllVehicle() {
		return vehService.findAllVehicle();
	}

	//Update VehicleNumber
	@PatchMapping("/vehicle/id/{id}")
	public Vehicle updateVehicleNumber(@PathVariable("id") int id, @RequestBody Vehicle vehicle) {
		return vehService.updateVehicleNumber(vehicle);
	}

	// View vehicle
	@GetMapping("/vehicle/id/{id}")
	public Vehicle viewVehicle(@PathVariable("id") int vehicleId) {
		if (vehService.viewVehicle(vehicleId) == null) {
			throw new VehicleNotFoundException("Vehicle not found with this id:" + vehicleId);
		}
		return vehService.viewVehicle(vehicleId);
	}

	// Update vehicle
	@PutMapping("/vehicle/id/{id}")
	public Vehicle updateVehicleNumber(@PathVariable("id") int vehicleId) {
		if (vehService.updateVehicleNumber(vehicleId) == null) {
			throw new VehicleNotFoundException("Vehicle not Found:" + vehicleId);
		}
		return vehService.updateVehicleNumber(vehicleId);
	}

	// delete by id
	@DeleteMapping("/vehicle/id/{id}")
	public Vehicle deleteVehicleById(@PathVariable("id") int vehicleId) {
		if (vehService.deleteVehicleById(vehicleId) == null) {
			throw new VehicleNotFoundException("Vehicle not found with this id:" + vehicleId);
		}
		return vehService.deleteVehicleById(vehicleId);
	}

}