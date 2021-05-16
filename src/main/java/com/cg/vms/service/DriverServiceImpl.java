package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Driver;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IDriverRepository;

@Service
public class DriverServiceImpl implements IDriverService {

	@Autowired
	IDriverRepository driRep;

	// Add Driver
	@Override
	public Driver addDriver(Driver driver) {
		return driRep.save(driver);
	}

	// Update
	@Override
	public Driver update(Driver driver) {
		Optional<Driver> dri = driRep.findById(driver.getDriverId());
		if (!dri.isPresent()) {
			return null;
		}
		dri.get().setFirstName(driver.getFirstName());
		dri.get().setLastName(driver.getLastName());
		dri.get().setContactNumber(driver.getContactNumber());
		dri.get().setEmail(driver.getEmail());
		dri.get().setAddress(driver.getAddress());
		dri.get().setChargesPerDay(driver.getChargesPerDay());
		dri.get().setLicenseNo(driver.getLicenseNo());
		return driRep.save(dri.get());
	}

	// Find All Driver
	@Override
	public List<Driver> findAllDriver() {
		return driRep.findAll();

	}

	// Delete Driver ById
	@Override
	public Driver deleteDriverById(int driverId) {
		Optional<Driver> dri = driRep.findById(driverId);
		if (!dri.isPresent()) {
			return null;
		}
		driRep.deleteById(driverId);
		return dri.get();

	}

	// find Driver ById
	@Override
	public Driver findByDriId(int id) {
		Optional<Driver> dri = driRep.findById(id);
		if (!dri.isPresent()) {
			return null;
		}
		return dri.get();

	}

	// View Driver
	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> dri = driRep.findById(driverId);
		if (!dri.isPresent()) {
			return null;
		}
		return dri.get();

	}

	// Update FirstName
	@Override
	public Driver updateFirstName(Driver driver) {
		Optional<Driver> dri = driRep.findById(driver.getDriverId());
		if (!dri.isPresent()) {
			return null;
		}
		dri.get().setFirstName(driver.getFirstName());
		return driRep.save(dri.get());
	}

}
