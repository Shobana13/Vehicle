package com.cg.vms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vms.entities.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

	 /** 
	 * Implementing the method getting the customer list based on vehicle type
	 */
    @Query(value="select * from  customer inner join vehicle_dto on customer.vehicle_id=vehicle_dto.vehicle_id where vehicle_dto.type=:t",nativeQuery=true)
	public List<Customer> findbyType(@Param("t") String type);

    /**
	 * Implementing the method getting the customer list based on vehicle location
	 */ 
	@Query(value="select * from  customer inner join vehicle_dto on customer.vehicle_id=vehicle_dto.vehicle_id where vehicle_dto.location=:l",nativeQuery=true)
	public List<Customer> findbyVehicleLocation(@Param("l") String location);

	Customer findCustomerByEmailId(String emailId);
}