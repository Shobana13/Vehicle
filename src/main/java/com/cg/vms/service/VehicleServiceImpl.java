package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Driver;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IVehicleRepository;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	IVehicleRepository vehRep;

	/**
	 * This function will Add the Vehicle details
	 * 
	 * @return
	 */
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehRep.save(vehicle);
	}

	/**
	 * This function will Update the Vehicle details
	 * 
	 * @return
	 */
	@Override
	public Vehicle update(int vehicleId, Vehicle vehicle) {
		Optional<Vehicle> veh = vehRep.findById(vehicleId);
		if (!veh.isPresent()) {
			return null;
		}
		veh.get().setVehicleNumber(vehicle.getVehicleNumber());
		veh.get().setType(vehicle.getType());
		veh.get().setCategory(vehicle.getCategory());
		veh.get().setDescription(vehicle.getDescription());
		veh.get().setLocation(vehicle.getLocation());
		veh.get().setCapacity(vehicle.getCapacity());
		veh.get().setChargesPerKM(vehicle.getChargesPerKM());
		veh.get().setFixedCharges(vehicle.getFixedCharges());
		return vehRep.save(veh.get());
	}

	/**
	 * This function will List the Vehicle details
	 * 
	 * @return
	 */
	@Override
	public List<Vehicle> findAllVehicle() {
		return vehRep.findAll();

	}

	/**
	 * This function will delete VehicleById details
	 * 
	 * @return
	 */
	@Override
	public Vehicle deleteVehicleById(int vehicleId) {
		Optional<Vehicle> veh = vehRep.findById(vehicleId);
		if (!veh.isPresent()) {
			return null;
		}
		vehRep.deleteById(vehicleId);
		return veh.get();

	}

	/**
	 * This function will find VehicleById details
	 * 
	 * @return
	 */
	@Override
	public Vehicle findByVehId(int id) {
		Optional<Vehicle> veh = vehRep.findById(id);
		if (!veh.isPresent()) {
			return null;
		}
		return veh.get();
	}

	/**
	 * This function will View Vehicle ById
	 * 
	 * @return
	 */
	@Override
	public Vehicle viewVehicle(int vehicleId) {
		Optional<Vehicle> veh = vehRep.findById(vehicleId);
		if (!veh.isPresent()) {
			return null;
		}
		return veh.get();

	}

	/**
	 * This function will update VehicleNumber ById
	 * 
	 * @return
	 */
	@Override 
	public Vehicle updateVehicleNumber(Vehicle vehicle) {
		Optional<Vehicle> veh = vehRep.findById(vehicle.getVehicleId());
		if (!veh.isPresent()) {
			return null;
		}
		veh.get().setVehicleNumber(vehicle.getVehicleNumber());
		return vehRep.save(veh.get());
	}

	/**
	 * This function will update FirstName ById
	 * 
	 * @return
	 */ 
	@Override
	public List<Vehicle> findAllByLocation(String location) {
		List<Vehicle> vehicleList = vehRep.findAllByLocation(location);
		if (vehicleList.isEmpty()) {
			return null;
		}

		return vehicleList;
	}
}
