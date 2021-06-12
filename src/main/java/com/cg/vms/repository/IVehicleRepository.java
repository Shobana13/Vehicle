package com.cg.vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.entities.Driver;
import com.cg.vms.entities.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	/**
	 * Implementing the method getting the Vehicle  list based on vehicle location
	 */
	
	List<Vehicle> findAllByLocation(String location);

}  