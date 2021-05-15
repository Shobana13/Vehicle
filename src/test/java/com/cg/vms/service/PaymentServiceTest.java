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
	void testFindAllPayments() {
		List<Payment> payment = PayService.viewAllPayments();
		System.out.println(payment);
		assertEquals(6, payment.size());
	}

	@Test
	@Disabled
	void testAddPayment() {
		Payment payment = new Payment(10006, "Online", LocalDate.of(2021, 05, 06), "Success");
		Booking booking = new Booking(106, LocalDate.of(2021, 05, 06), LocalDate.of(2021, 05, 07), "Success", 400.0,
				2.0);
		Vehicle vehicle = new Vehicle(1006, "TN4E32", "car", "non ac", "small", "Chennai", "4seater", 60.0, 50.0);
		payment.setBooking(booking);
		payment.setVehicle(vehicle);
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

}
