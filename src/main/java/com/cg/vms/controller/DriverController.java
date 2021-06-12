package com.cg.vms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Driver;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.exceptions.DriverNotFoundException;
import com.cg.vms.service.IDriverService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DriverController {

	/** 
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DriverController.class);

	/**
	 * We are autowiring the driver service layer to this controller layer of driver
	 * 
	 * @param driverServiceImpl
	 */
	@Autowired
	IDriverService driService;

	/**
	 * This controller is used to create a new or add new driver and redirects it to
	 * the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/driver")
	public ResponseEntity<Driver> addDriver(@Valid @RequestBody Driver driver) {
		logger.info("Adding new Driver");
		driService.addDriver(driver);
		return ResponseEntity.ok(driver);
	}

	/**
	 * This controller is used to return and list all the driver found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/driver")
	public ResponseEntity<List<Driver>> findAllDriver() {
		logger.info("Finding All Driver");
		return ResponseEntity.ok(driService.findAllDriver());
	}

	/**
	 * This function is used to update a specific driver firstName on basis of given
	 * 
	 * @param id
	 * @return
	 */
	@PatchMapping("/driver/{id}")
	public ResponseEntity<Driver> updateFirstName(@PathVariable("id") int id, @Valid @RequestBody Driver driver) {
		logger.info("Updating driver First Name");
		return ResponseEntity.ok().body(driService.updateFirstName(driver));
	}

	/**
	 * This controller is used to return and list all the driver found in the
	 * database and request to the service to perform the action
	 * 
	 * @param driverid
	 * @return
	 * @throws driverNotFoundException
	 */
	@GetMapping("/driver/{id}")
	public ResponseEntity<Driver> viewDriver(@PathVariable("id") int driverId) throws DriverNotFoundException {
		logger.info("Getting driver details by id ");
		if (driService.viewDriver(driverId) == null) {
			throw new DriverNotFoundException("Driver not found with this id:" + driverId);
		}
		Driver driver = driService.viewDriver(driverId);
		return ResponseEntity.ok().body(driver);
	}

	/**
	 * 
	 * this controller function perform deletion of a specific given driver and
	 * request the service to perform the action and returns the message as deleted
	 * else throw exception
	 * 
	 * @param driverid
	 * @return
	 * @throws driverNotFoundException
	 */
	@DeleteMapping("/driver/{id}")
	public ResponseEntity<Driver> deleteDriverById(@PathVariable("id") int driverId) throws DriverNotFoundException {
		logger.info("Delete driver details by id ");
		if (driService.deleteDriverById(driverId) == null) {
			throw new DriverNotFoundException("Driver not found with this id:" + driverId);
		}
		return ResponseEntity.ok().body(driService.deleteDriverById(driverId));
	}

	/**
	 * This function is used to update a specific driver on basis of given customer
	 * id and returns exception if given driver id is not found.
	 * 
	 * @param driverid
	 * @return
	 * @throws CustomerNotFoundException
	 */
	@PutMapping("/driver/update/{id}")
	public ResponseEntity<Driver> update(@PathVariable("id") int driverId, @Valid @RequestBody Driver driver)
			throws DriverNotFoundException {
		logger.info("Updating driver details");
		if (driService.update(driverId, driver) == null) {
			throw new DriverNotFoundException("Driver Not Found:" + driver.getDriverId());
		}
		return ResponseEntity.ok().body(driService.update(driverId, driver));
	}
  
	/**
	 * This function is used to update a specific driver on basis of given customer
	 * 
	 * @param firstName
	 * @return
	 */
	@GetMapping("/driver/firstname/{firstname}")
	public ResponseEntity<List<Driver>> findAllByFirstName(@PathVariable("firstname") String firstName) {
		List<Driver> driver = driService.findAllByFirstName(firstName);
		return ResponseEntity.ok(driver);
	}

}