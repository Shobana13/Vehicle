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
import com.cg.vms.exceptions.VehicleNotFoundException;
import com.cg.vms.service.IVehicleService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VehicleController {
	/** 
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(VehicleController.class);

	/**
	 * We are autowiring the vehicle service layer to this controller layer of
	 * vehicle
	 * 
	 * @param vehicleServiceImpl
	 */
	@Autowired
	IVehicleService vehService;

	/**
	 * This controller is used to create a new or add new vehicle and redirects it
	 * to the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/vehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		logger.info("Adding Vehicle in database");
		vehService.addVehicle(vehicle);
		return ResponseEntity.ok(vehicle);
	}

	/**
	 * This controller is used to return and list all the vehicle found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicle>> findAllVehicle() {
		logger.info("Finding Vehicle in database");
		return ResponseEntity.ok(vehService.findAllVehicle());
	}

	/**
	 * This function is used to update a specific vehicle vehiclenumber on basis of
	 * given
	 * 
	 * @param id
	 * @return
	 */
	@PatchMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicleNumber(@PathVariable("id") int id,
			@Valid @RequestBody Vehicle vehicle) {
		logger.info("Update VehicleNumber by id");
		return ResponseEntity.ok().body(vehService.updateVehicleNumber(vehicle));
	}

	/**
	 * This controller is used to return and list all the vehicle found in the
	 * database and request to the service to perform the action
	 * 
	 * @param vehicleid
	 * @return
	 * @throws vehicleNotFoundException
	 */
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> viewVehicle(@PathVariable("id") int vehicleId) throws VehicleNotFoundException {
		logger.info("View Vehicle by id");
		if (vehService.viewVehicle(vehicleId) == null) {
			throw new VehicleNotFoundException("Vehicle not found with this id:" + vehicleId);
		}
		Vehicle vehicle = vehService.viewVehicle(vehicleId);
		return ResponseEntity.ok().body(vehicle);

	}

	/**
	 * This function is used to update a specific vehicle on basis of given customer
	 * id and returns exception if given vehicle id is not found.
	 * 
	 * @param vehicleid
	 * @return
	 * @throws vehicleNotFoundException
	 */

	@PutMapping("/vehicle/update/{id}")
	public ResponseEntity<Vehicle> update(@PathVariable("id") int vehicleId, @RequestBody Vehicle vehicle)
			throws VehicleNotFoundException {
		logger.info("Update Vehicle by id");
		if (vehService.update(vehicleId, vehicle) == null) {
			throw new VehicleNotFoundException("Vehicle not Found:" + vehicle.getVehicleId());
		}
		return ResponseEntity.ok().body(vehService.update(vehicleId, vehicle));
	}

	/**
	 * 
	 * this controller function perform deletion of a specific given vehicle and
	 * request the service to perform the action and returns the message as deleted
	 * else throw exception
	 * 
	 * @param vehicleid
	 * @return
	 * @throws vehicleNotFoundException
	 */
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> deleteVehicleById(@PathVariable("id") int vehicleId)
			throws VehicleNotFoundException {
		logger.info("Delete Vehicle by id");
		if (vehService.deleteVehicleById(vehicleId) == null) {
			throw new VehicleNotFoundException("Vehicle not found with this id:" + vehicleId);
		}
		return ResponseEntity.ok().body(vehService.deleteVehicleById(vehicleId));
	}
  
	/**
	 * this controller function perform finding of a specific given vehicle and
	 * request the service to perform the action and returns the message
	 * 
	 * @param location
	 * @return
	 */

	@GetMapping("/vehicle/location/{location}")
	public ResponseEntity<List<Vehicle>> findAllByLocation(@PathVariable("location") String location) {
		List<Vehicle> vehicle = vehService.findAllByLocation(location);
		return ResponseEntity.ok(vehicle);
	}

}