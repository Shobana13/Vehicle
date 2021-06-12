package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Driver;
import com.cg.vms.repository.IDriverRepository;

@Service
public class DriverServiceImpl implements IDriverService {

	@Autowired
	IDriverRepository driRep;

	/**
	 * This function will add Driver details
	 * 
	 * @return
	 */  
	@Override
	public Driver addDriver(Driver driver) {
		return driRep.save(driver);
	}

	/**
	 * This function will update Driver details
	 * 
	 * @return
	 */
	@Override
	public Driver update(int driverId, Driver driver) {
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

	/**
	 * This function will Find all Drivers
	 * 
	 * @return
	 */
	@Override
	public List<Driver> findAllDriver() {
		return driRep.findAll();

	}

	/**
	 * This function will delete Driver ById
	 * 
	 * @return
	 */
	@Override
	public Driver deleteDriverById(int driverId) {
		Optional<Driver> dri = driRep.findById(driverId);
		if (!dri.isPresent()) {
			return null;
		}
		driRep.deleteById(driverId);
		return dri.get();

	}

	/**
	 * This function will find Driver ById
	 * 
	 * @return
	 */
	@Override
	public Driver findByDriId(int id) {
		Optional<Driver> dri = driRep.findById(id);
		if (!dri.isPresent()) {
			return null;
		}
		return dri.get();

	}

	/**
	 * This function will view Driver ById
	 * 
	 * @return
	 */
	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> dri = driRep.findById(driverId);
		if (!dri.isPresent()) {
			return null;
		}
		return dri.get();

	}

	/**
	 * This function will update FirstName ById
	 * 
	 * @return
	 */
	@Override
	public Driver updateFirstName(Driver driver) {
		Optional<Driver> dri = driRep.findById(driver.getDriverId());
		if (!dri.isPresent()) {
			return null;
		}
		dri.get().setFirstName(driver.getFirstName());
		return driRep.save(dri.get());
	}

	/**
	 * This function will update FirstName ById
	 * 
	 * @return
	 */
	@Override
	public List<Driver> findAllByFirstName(String firstName) {
		List<Driver> driverList = driRep.findAllByFirstName(firstName);
		if (driverList.isEmpty()) {
			return null;
		}

		return driverList;
	}

}
