package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Driver;

public interface IDriverService {
	Driver addDriver(Driver driver);
	Driver deleteDriverById(int driverId);
	Driver update(Driver driver);
	List<Driver> findAllDriver();
	Driver findByDriId(int id);
	Driver viewDriver(int driverId);
	Driver updateFirstName(Driver driver);

}
