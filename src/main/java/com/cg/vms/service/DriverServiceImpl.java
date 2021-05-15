package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Driver;
import com.cg.vms.repository.IDriverRepository;

@Service
public class DriverServiceImpl implements IDriverService{
	
	@Autowired
	IDriverRepository driRep;

	@Override
	public Driver addDriver(Driver driver) {
		return driRep.save(driver);
	}

	@Override
	public Driver updateFirstName(Driver driver) {
		Driver dri = driRep.findById(driver.getDriverId()).get();
		dri.setFirstName(driver.getFirstName());
		dri.setLastName(driver.getLastName());
		dri.setContactNumber(driver.getContactNumber());
		dri.setEmail(driver.getEmail());
		dri.setAddress(driver.getAddress());
		dri.setChargesPerDay(driver.getChargesPerDay());
		dri.setLicenseNo(driver.getLicenseNo());
		return driRep.save(dri);
	}
	@Override
	public List<Driver> findAllDriver() {
		return driRep.findAll();

	}
	@Override
	public Driver deleteDriverById(int driverId) {
		Optional<Driver>dri=driRep.findById(driverId);
		if(!dri.isPresent()) {
			return null;
		}
		driRep.deleteById(driverId);
		return dri.get();
		
	}

	@Override
	public Driver findByDriId(int id) {
		Optional<Driver> dri = driRep.findById(id);
		if(!dri.isPresent()) {
			return null;
		}
		return dri.get();

	}

	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> dri = driRep.findById(driverId);
		if(!dri.isPresent()) {
			return null;
		}
		return dri.get();

	}

	@Override
	public Driver updateFirstName(int driverId) {
		Optional<Driver> dri = driRep.findById(driverId);
		if (!dri.isPresent()) {
          return null;
	  }
		return dri.get();
	}


	




	

	}

	

