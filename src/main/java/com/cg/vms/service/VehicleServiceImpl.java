package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IVehicleRepository;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	IVehicleRepository vehRep;

	// Add Vehicle
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehRep.save(vehicle);
	}

	// Update
	@Override
	public Vehicle update(Vehicle vehicle) {
		Optional<Vehicle> veh = vehRep.findById(vehicle.getVehicleId());
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

	// Find AllVehicle
	@Override
	public List<Vehicle> findAllVehicle() {
		return vehRep.findAll();

	}

	// Delete Vehicle ById
	@Override
	public Vehicle deleteVehicleById(int vehicleId) {
		Optional<Vehicle> veh = vehRep.findById(vehicleId);
		if (!veh.isPresent()) {
			return null;
		}
		vehRep.deleteById(vehicleId);
		return veh.get();

	}

	// Find VehicleById
	@Override
	public Vehicle findByVehId(int id) {
		Optional<Vehicle> veh = vehRep.findById(id);
		if (!veh.isPresent()) {
			return null;
		}
		return veh.get();
	}

	// View Vehicle
	@Override
	public Vehicle viewVehicle(int vehicleId) {
		Optional<Vehicle> veh = vehRep.findById(vehicleId);
		if (!veh.isPresent()) {
			return null;
		}
		return veh.get();

	}

	// Update VehicleNumber
	@Override
	public Vehicle updateVehicleNumber(Vehicle vehicle) {
		Optional<Vehicle> veh = vehRep.findById(vehicle.getVehicleId());
		if (!veh.isPresent()) {
			return null;
		}
		veh.get().setVehicleNumber(vehicle.getVehicleNumber());
		return vehRep.save(veh.get());
	}
}
