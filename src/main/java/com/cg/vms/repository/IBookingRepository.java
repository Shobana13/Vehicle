package com.cg.vms.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.vms.entities.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Integer> {

	/**
	 * Implementing the method of getting the Booking list based on booking Date
	 */
	@Query("select b from Booking b where b.bookingDate=:n")
	public List<Booking> viewAllBookingbyBookingDate(@Param("n")  LocalDate bookingDate);
	
	/**
	 *Implementing the method of getting the Booking list based on vehicle Id
	 */
	@Query(value="select * from  booking inner join vehicle on booking.vehicle_id=vehicle.vehicle_id where vehicle.vehicle_id=:t",nativeQuery=true)
	public List<Booking> viewAllBookingByVehicle(@Param("t") int vehicleId);

	/**
	 *Implementing the method of getting the Booking list based on customer Id
	 */
	@Query(value="select * from  booking inner join customer on booking.customer_id=customer.customer_id where customer.customer_id=:c",nativeQuery=true)
	public List<Booking> viewAllBookingByCustomer(@Param("c") int customerId);
	

}

