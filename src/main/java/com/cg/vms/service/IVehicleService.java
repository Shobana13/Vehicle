package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Vehicle;

public interface IVehicleService {
	/**
	 * Method to be override by the implementing class
	 */
	Vehicle addVehicle(Vehicle vehicle);

	/**
	 * Method to be override by the implementing class
	 */
	List<Vehicle> findAllVehicle();

	/**
	 * Method to be override by the implementing class
	 */
	Vehicle findByVehId(int id); 

	/**
	 * Method to be override by the implementing class
	 */
	Vehicle viewVehicle(int vehicleId);
  
	/**
	 * Method to be override by the implementing class
	 */
	Vehicle deleteVehicleById(int vehicleId);

	/**
	 * Method to be override by the implementing class
	 */
	Vehicle update(int vehicleId, Vehicle vehicle);

	/**
	 * Method to be override by the implementing class
	 */
	Vehicle updateVehicleNumber(Vehicle vehicle);

	/**
	 * Method to be override by the implementing class
	 */

	List<Vehicle> findAllByLocation(String location);

}