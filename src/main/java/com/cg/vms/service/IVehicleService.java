package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Vehicle;

public interface IVehicleService {
	Vehicle addVehicle(Vehicle vehicle);
	List<Vehicle> findAllVehicle();
	Vehicle findByVehId(int id);
	Vehicle viewVehicle(int vehicleId);
	Vehicle deleteVehicleById(int vehicleId);
	Vehicle update(int vehicleId,Vehicle vehicle);
	Vehicle updateVehicleNumber(Vehicle vehicle);
	
	
}