package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;

@SpringBootTest
class PaymentServiceTest {

	@Autowired
	IPaymentService PayService;
	
	@Test
	@Disabled
	void testCancelPayment() {
		Payment persistedPa = PayService.cancelPayment(10001);
		assertEquals(10001, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	@Test
	//@Disabled
	void testAddPayment() {
		Payment payment = new Payment(10001, "Online", LocalDate.of(2021, 05, 06), "Success");
		Booking booking = new Booking(101, LocalDate.of(2020, 12, 20), LocalDate.of(2020, 12, 30), "Better", 900.0,
				10000.6);
		Vehicle vehicle = new Vehicle(4003, "KA 89 0999", "car", "non a/c", "Ultra Fast", "Ambattur", "6", 2.0,2.0);
		payment.setBooking(booking);
		booking.setVehicle(vehicle);
		Payment persistedPa = PayService.addPayment(payment);
		assertEquals(10001, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	@Test
	//@Disabled
	void testViewPayment() {
		Payment persistedPa = PayService.viewPayment(10001);
		System.out.println(persistedPa);
		assertEquals(10001, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	@Test
	//@Disabled
	void testFindAllPayments() {
		List<Payment> payment = PayService.viewAllPayments();
		System.out.println(payment);
		assertEquals(1, payment.size());
	}

	@Test
	//@Disabled
	void testFindAllPaymentsByVehicle() {
		Vehicle vehicle = new Vehicle();
		List<Payment> payment = PayService.viewAllPayments(vehicle);
		System.out.println(payment);
		assertEquals(1, payment.size());
	}

	@Test
	//@Disabled
	void testUpdatePaymentStatus() {
		Payment payment = new Payment();
		payment.setPaymentId(10001);
		payment.setPaymentStatus("Success");
		Payment persistedPa = PayService.updatePaymentStatus(10001, payment);
		System.out.println(persistedPa);
		assertEquals("Success", persistedPa.getPaymentStatus());

	}

	@Test
	//@Disabled
	void testCalculateMonthlyRevenue() {
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setBookingDate(LocalDate.of(2020, 12, 20));
		booking2.setBookingDate(LocalDate.of(2020, 12, 20));
		double persistedPa = PayService.calculateMonthlyRevenue(LocalDate.of(2020, 12, 20), LocalDate.of(2020, 12, 20));
		System.out.println(persistedPa);
		assertEquals(900.0, persistedPa);
	}

	@Test
	@Disabled
	void testCalculateTotalPayment() {
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setBookingId(101);
		booking2.setBookingId(101);
		double persistedPa = PayService.calculateTotalPayment(101, 101);
		System.out.println(persistedPa);
		assertEquals(900.0,persistedPa);
	}

	@Test
	//@Disabled
	void testCalculateTotalBookingCost() {
		Vehicle vehicle = new Vehicle();
		vehicle.setFixedCharges(2.0);
		vehicle.setChargesPerKM(2.0);
		Booking persistedPa = PayService.calculateTotalBookingCost(10001, 7.0, vehicle);
		System.out.println(persistedPa);
		assertEquals(16.0, persistedPa.getTotalCost());
	}

}
