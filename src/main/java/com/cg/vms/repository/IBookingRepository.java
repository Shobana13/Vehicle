package com.cg.vms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Vehicle;

public interface IBookingRepository extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b where b.bookingdate=:n")
	public List<Booking> viewAllBookingbyBookingDate(@Param("n") LocalDate bookingDate);

	List<Booking> viewAllBookingByDate(LocalDate bookingDate);

	List<Booking> viewAllBookingByVehicle(Vehicle vehicle);

}
