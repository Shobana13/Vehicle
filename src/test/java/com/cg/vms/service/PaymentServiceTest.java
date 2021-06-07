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
	void testAddPayment() {
		Payment payment = new Payment(10006, "Online", LocalDate.of(2021, 05, 06), "Success");
		Booking booking = new Booking(106, LocalDate.of(2021, 05, 06), LocalDate.of(2021, 05, 07), "Success", 400.0,
				2.0);
		Vehicle vehicle = new Vehicle(1006, "TN4E32", "car", "non ac", "small", "Chennai", "4seater", 60.0, 50.0);
		payment.setBooking(booking);
		booking.setVehicle(vehicle);
		Payment persistedPa = PayService.addPayment(payment);
		assertEquals(10006, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	@Test
	@Disabled
	void testCancelPayment() {
		Payment persistedPa = PayService.cancelPayment(10006);
		assertEquals(10006, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	@Test
	@Disabled
	void testViewPayment() {
		Payment persistedPa = PayService.viewPayment(10006);
		System.out.println(persistedPa);
		assertEquals(10006, persistedPa.getPaymentId());
		assertEquals("Online", persistedPa.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 06), persistedPa.getPaymentDate());
		assertEquals("Success", persistedPa.getPaymentStatus());
	}

	@Test
	@Disabled
	void testFindAllPayments() {
		List<Payment> payment = PayService.viewAllPayments();
		System.out.println(payment);
		assertEquals(6, payment.size());
	}

	@Test
	@Disabled
	void testFindAllPaymentsByVehicle() {
		Vehicle vehicle = new Vehicle();
		List<Payment> payment = PayService.viewAllPayments(vehicle);
		System.out.println(payment);
		assertEquals(8, payment.size());
	}

	@Test
	@Disabled
	void testUpdatePaymentStatus() {
		Payment payment = new Payment();
		payment.setPaymentId(10006);
		payment.setPaymentStatus("Success");
		Payment persistedPa = PayService.updatePaymentStatus(10006, payment);
		System.out.println(persistedPa);
		assertEquals("Success", persistedPa.getPaymentStatus());

	}

	@Test
	@Disabled
	void testCalculateMonthlyRevenue() {
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setBookingDate(LocalDate.of(2021, 04, 01));
		booking2.setBookingDate(LocalDate.of(2021, 04, 05));
		double persistedPa = PayService.calculateMonthlyRevenue(LocalDate.of(2021, 04, 01), LocalDate.of(2021, 04, 05));
		System.out.println(persistedPa);
		assertEquals(3960.0, persistedPa);
	}

	@Test
	@Disabled
	void testCalculateTotalPayment() {
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setBookingId(101);
		booking2.setBookingId(109);
		double persistedPa = PayService.calculateTotalPayment(101, 109);
		System.out.println(persistedPa);
		assertEquals(7810.0, persistedPa);
	}

	@Test
	@Disabled
	void testCalculateTotalBookingCost() {
		Vehicle vehicle = new Vehicle();
		vehicle.setFixedCharges(70.0);
		vehicle.setChargesPerKM(50.0);
		Booking persistedPa = PayService.calculateTotalBookingCost(10006, 7.0, vehicle);
		System.out.println(persistedPa);
		assertEquals(420.0, persistedPa.getTotalCost());
	}

}
