package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Driver;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IVehicleRepository;

@Service
public class VehicleServiceImpl implements IVehicleService{
	
	@Autowired
	IVehicleRepository vehRep;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehRep.save(vehicle);
	}
	@Override
	public Vehicle updateVehicleNumber(Vehicle vehicle) {
		Vehicle veh = vehRep.findById(vehicle.getVehicleId()).get();
		veh.setVehicleNumber(vehicle.getVehicleNumber());
		veh.setType(vehicle.getType());
		veh.setCategory(vehicle.getCategory());
		veh.setDescription(vehicle.getDescription());
		veh.setLocation(vehicle.getLocation());
		veh.setCapacity(vehicle.getCapacity());
		veh.setChargesPerKM(vehicle.getChargesPerKM());
		veh.setFixedCharges(vehicle.getFixedCharges());
		return vehRep.save(veh);
	}
	
	@Override
	public List<Vehicle> findAllVehicle() {
		return vehRep.findAll();

	}
	@Override
	public Vehicle deleteVehicleById(int vehicleId) {
		Optional<Vehicle>veh=vehRep.findById(vehicleId);
		if(!veh.isPresent()) {
			return null;
		}
		vehRep.deleteById(vehicleId);
		return veh.get();
		
	}

	@Override
	public Vehicle findByVehId(int id) {
		Optional<Vehicle> veh = vehRep.findById(id);
		if(!veh.isPresent()) {
			return null;
		}
		return veh.get();
	}
	
	@Override
	public Vehicle viewVehicle(int vehicleId) {
		Optional<Vehicle>veh=vehRep.findById(vehicleId);
		if(!veh.isPresent()) {
			return null;
		}
		return veh.get();
		
	}
	@Override
	public Vehicle updateVehicleNumber(int vehicleId ) {
        Optional<Vehicle> veh = vehRep.findById(vehicleId);
		if (!veh.isPresent()) {
			return null;
		}

		return veh.get();
	}
	/*@Override
	public Vehicle deleteVehicle(int id) {
		Vehicle veh = vehRep.findById(id).get();
		vehRep.deleteById(id);
		return veh;
		
	}*/

}

