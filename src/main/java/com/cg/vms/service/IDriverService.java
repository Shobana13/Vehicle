package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Driver;

public interface IDriverService {
	/**
	 * Method to be override by the implementing class
	 */
	Driver addDriver(Driver driver);

	/**
	 * Method to be override by the implementing class
	 */
	Driver deleteDriverById(int driverId);

	/**
	 * Method to be override by the implementing class
	 */
	Driver update(int driverId, Driver driver);

	/**
	 * Method to be override by the implementing class
	 */
	List<Driver> findAllDriver();

	/**
	 * Method to be override by the implementing class
	 */
	Driver findByDriId(int id);

	/**
	 * Method to be override by the implementing class
	 */  
	Driver viewDriver(int driverId);

	/**
	 * Method to be override by the implementing class
	 */
	Driver updateFirstName(Driver driver);

	/**
	 * Method to be override by the implementing class
	 */

	List<Driver> findAllByFirstName(String firstName);

}
