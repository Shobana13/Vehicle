package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Driver;

public interface IDriverService {
	Driver addDriver(Driver driver);
	Driver deleteDriverById(int driverId);
	//Driver updateFirstName(Driver driver);
	//Driver update(Driver driver);
	List<Driver> findAllDriver();
	//Driver delete(Driver driver);
	Driver findByDriId(int id);
	Driver viewDriver(int driverId);
	//Driver updateFirstName(int DriverId);
	//Driver updateFirstName(Driver driver);
	Driver updateFirstName(int driverId);
	//Driver updateFirstName(int driverId, Driver driver);
	Driver updateFirstName(Driver driver);
	

}
