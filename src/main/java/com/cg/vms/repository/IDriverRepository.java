package com.cg.vms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.entities.Driver;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer> {
	/**
	 * Implementing the method getting the Driver list based on FirstName 
	 */
	
	List<Driver> findAllByFirstName(String firstName);
}  