package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;

@SpringBootTest
public class PaymentServiceTest {	

	@Autowired
	IPaymentService PayService;
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentServiceTest.class);

	/**
	 * Test case for the method canceling the payment by using paymentId
	 */
	@Test
	void testCancelPayment() {
		Payment persistedPa = PayService.cancelPayment(10006);
		logger.info(persistedPa);
		assertEquals(10006, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	/**
	 * Test case for the method adding the payment to the database
	 */
	@Test
	void testAddPayment() {
		Payment payment = new Payment(10006, "Online", LocalDate.of(2021, 05, 06), "Success");
		Booking booking = new Booking(106, LocalDate.of(2021, 05, 06), LocalDate.of(2021, 05, 07), "Success", 470.0,
				2.0);
		Vehicle vehicle = new Vehicle(1006, "TN45J89", "bus", "non ac", "small", "Chennai", "4seater", 160.0, 150.0);
		payment.setBooking(booking);
		booking.setVehicle(vehicle);
		logger.info(payment);
		Payment persistedPa = PayService.addPayment(payment);
		assertEquals(10006, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	/**
	 * Test case for the method getting the payment by using paymentId
	 */
	@Test
	void testViewPayment() {
		Payment persistedPa = PayService.viewPayment(10001);
		logger.info(persistedPa);
		assertEquals(10001, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 01), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	/**
	 * Test case for the method getting all the payments in form of list
	 */
	@Test
	void testFindAllPayments() {
		List<Payment> payment = PayService.viewAllPayments();
		logger.info(payment);
		assertEquals(4, payment.size());
	}

	/**
	 * Test case for the method getting all the payments in form of list by vehicle
	 */
	@Test
	void testFindAllPaymentsByVehicle() {
		Vehicle vehicle = new Vehicle();
		List<Payment> payment = PayService.viewAllPayments(vehicle);
		logger.info(payment);
		assertEquals(4, payment.size());
	}

	/**
	 * Test case for the method updating the payment status of a payment
	 */
	@Test
	void testUpdatePaymentStatus() {
		Payment payment = new Payment();

		payment.setPaymentId(10004);
		payment.setPaymentStatus("Success");
		Payment persistedPa = PayService.updatePaymentStatus(10004, payment);
		logger.info(persistedPa);
		assertEquals("Success", persistedPa.getPaymentStatus());

	}

	/**
	 * Test case for the method to calculate the monthly revenue of a month with date range such 
	 * as the bookingStartDate and bookingEndDate. 
	 */
	@Test
	void testCalculateMonthlyRevenue() {
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setBookingDate(LocalDate.of(2021, 05, 01));
		booking2.setBookingDate(LocalDate.of(2021, 05, 04));
		double persistedPa = PayService.calculateMonthlyRevenue(LocalDate.of(2021, 05, 01), LocalDate.of(2021, 05, 04));
		logger.info(persistedPa);
		assertEquals(2740.0, persistedPa);
	}

	/**
	 * Test case for the method to calculate the total payment between bookingId range such
	 * as the bookingStartId and bookingEndId
	 */
	@Test
	void testCalculateTotalPayment() {
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setBookingId(101);
		booking2.setBookingId(104);
		double persistedPa = PayService.calculateTotalPayment(101, 104);
		logger.info(persistedPa);
		assertEquals(2740.0, persistedPa);
	}

	/**
	 * Test case for the method to calculate total booking cost based on booking distance, fixedCharges and chargesPerKM
	 */
	@Test
	void testCalculateTotalBookingCost() {
		Vehicle vehicle = new Vehicle();
		vehicle.setFixedCharges(160.0);
		vehicle.setChargesPerKM(150.0);
		Booking persistedPa = PayService.calculateTotalBookingCost(10003, 5.0, vehicle);
		logger.info(persistedPa);
		assertEquals(910.0, persistedPa.getTotalCost());
	}
}
