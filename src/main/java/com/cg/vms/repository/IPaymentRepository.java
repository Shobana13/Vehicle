package com.cg.vms.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vms.entities.Payment;

@Repository

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
	
	/**
	 * Implementing the method calculating monthly revenue within a booking date range by giving bookingStartDate d1
	 * and bookingEndDate d2
	 * @param d1
	 * @param d2
	 * @return
	 */
	@Query(value = "select sum(o.total_cost) from booking o where o.booking_date between :beginDate and :endDate", nativeQuery = true)
	public double calculateMonthlyRevenue(@Param("beginDate") LocalDate d1, @Param("endDate") LocalDate d2);

	/**
	 * Implementing the method calculating Total Payment within a booking id range by giving bookingStartId
	 * and bookingEndId
	 * @param bookingStartId
	 * @param bookingEndId
	 * @return
	 */
	@Query(value = "select sum(o.total_cost) from booking o where o.booking_id between :booking_id1 and :booking_id2", nativeQuery = true)
	public double calculateTotalPayment(@Param("booking_id1") int bookingStartId, @Param("booking_id2") int bookingEndId);

}
