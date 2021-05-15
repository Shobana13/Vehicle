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

import com.cg.vms.entities.Driver;
import com.cg.vms.exceptions.DriverNotFoundException;
import com.cg.vms.service.IDriverService;

@RestController
public class DriverController {

	@Autowired
	IDriverService driService;

	// Add Driver
	@PostMapping("/driver")
	public Driver addDriver(@RequestBody Driver driver) {
		return driService.addDriver(driver);
	}

	// Find All Driver
	@GetMapping("/driver")
	public List<Driver> findAllDriver() {
		return driService.findAllDriver();
	}

	// Update Firstname
	@PatchMapping("/driver/id/{id}")
	public Driver updateFirstName(@PathVariable("id") int id, @RequestBody Driver driver) {
		return driService.updateFirstName(driver);
	}

	// View driver
	@GetMapping("/driver/id/{id}")
	public Driver viewDriver(@PathVariable("id") int driverId) {
		if (driService.viewDriver(driverId) == null) {
			throw new DriverNotFoundException("Driver not found with this id" + driverId);
		}
		return driService.viewDriver(driverId);
	}

	// Update Driver
	@PutMapping("/driver/id/{id}")
	public Driver updateFirstName(@PathVariable("id") int driverId) {
		if (driService.updateFirstName(driverId) == null) {
			throw new DriverNotFoundException("Driver not Found with this first name:" + driverId);
		}
		return driService.updateFirstName(driverId);
	}

	// Delete by id
	@DeleteMapping("/driver/id/{id}")
	public Driver deleteDriverById(@PathVariable("id") int driverId) {
		if (driService.deleteDriverById(driverId) == null) {
			throw new DriverNotFoundException("Driver not found with this id:" + driverId);
		}
		return driService.deleteDriverById(driverId);
	}

}