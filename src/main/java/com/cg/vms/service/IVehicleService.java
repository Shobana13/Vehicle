package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Vehicle;

public interface IVehicleService {
	Vehicle addVehicle(Vehicle vehicle);
	//Vehicle deleteVehicle(int vehicleId);
	Vehicle updateVehicleNumber(int  vehicleId);
	//Vehicle update(Vehicle vehicle);
	List<Vehicle> findAllVehicle();
	//Vehicle delete(Vehicle vehicle);
	Vehicle findByVehId(int id);
	Vehicle viewVehicle(int vehicleId);
	Vehicle deleteVehicleById(int vehicleId);
	//Vehicle update(Vehicle vehicle);
	//Vehicle updateVehicleNumber(int id, Vehicle vehicle);
	Vehicle updateVehicleNumber(Vehicle vehicle);
	
	
}