package com.cg.vms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vms.entities.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{
	
    @Query(value="select * from  customer inner join vehicle on customer.vehicle_id=vehicle.vehicle_id where vehicle.type=:t",nativeQuery=true)
	public List<Customer> findbyType(@Param("t") String type);

	@Query(value="select * from  customer inner join vehicle on customer.vehicle_id=vehicle.vehicle_id where vehicle.location=:l",nativeQuery=true)
	public List<Customer> findbyVehicleLocation(@Param("l") String location);
	
}