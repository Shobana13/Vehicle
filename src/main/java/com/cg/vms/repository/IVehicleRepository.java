package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.entities.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

}