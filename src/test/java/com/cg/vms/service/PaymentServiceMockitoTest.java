package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IPaymentRepository;

@ExtendWith(SpringExtension.class)
class PaymentServiceMockitoTest {
	@InjectMocks
	PaymentServiceImp payService;

	@MockBean
	IPaymentRepository payRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Mockito Test case for the method adding the payment to the database
	 */
	@Test
	void testAddPayment() {
		Payment payment = new Payment(10007, "Online", LocalDate.of(2021, 05, 07), "Success");
		Booking booking = new Booking(107, LocalDate.of(2021, 05, 07), LocalDate.of(2021, 05, 07), "Success", 800.0,
				7.0);
		Vehicle vehicle = new Vehicle(1007, "TN7D32", "bus", "non ac", "medium", "Chennai", "14seater", 60.0, 50.0);
		payment.setBooking(booking);
		booking.setVehicle(vehicle);
		Mockito.when(payRepo.save(payment)).thenReturn(payment);
		Payment persistedPay = payService.addPayment(payment);
		assertEquals(10007, persistedPay.getPaymentId());
		assertEquals("Online", persistedPay.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 07), persistedPay.getPaymentDate());
		assertEquals("Success", persistedPay.getPaymentStatus());
	}

	/**
	 * Mockito Test case for the method getting the payment by using paymentId
	 */
	@Test
	void testviewPayment() {
		Payment payment = new Payment(10007, "Online", LocalDate.of(2021, 05, 07), "Success");
		Mockito.when(payRepo.findById(10007)).thenReturn(Optional.of(payment));
		Payment persistedPay = payService.viewPayment(10007);
		assertEquals(10007, persistedPay.getPaymentId());
		assertEquals("Online", persistedPay.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 07), persistedPay.getPaymentDate());
		assertEquals("Success", persistedPay.getPaymentStatus());
	}

	/**
	 * Mockito Test case for the method canceling the payment by using paymentId
	 */
	@Test
	void testCancelPayment() {
		Payment payment = new Payment(10007, "Online", LocalDate.of(2021, 05, 07), "Success");
		Mockito.when(payRepo.findById(10007)).thenReturn(Optional.of(payment));
		payRepo.deleteById(10007);
		Payment persistedPay = payService.cancelPayment(10007);
		assertEquals(10007, persistedPay.getPaymentId());
		assertEquals("Online", persistedPay.getPaymentMode());
		assertEquals(LocalDate.of(2021, 05, 07), persistedPay.getPaymentDate());
		assertEquals("Success", persistedPay.getPaymentStatus());
	}

	/**
	 * Mockito Test case for the method getting all the payments in form of list
	 */
	@Test
	void testFindAllPayment() {
		Payment payment1 = new Payment(10007, "Online", LocalDate.of(2021, 05, 07), "Success");
		Payment payment2 = new Payment(10008, "Online", LocalDate.of(2021, 05, 07), "Success");
		List<Payment> payment = new ArrayList<>();
		payment.add(payment1);
		payment.add(payment2);
		Mockito.when(payRepo.findAll()).thenReturn(payment);
		List<Payment> payments = payService.viewAllPayments();
		assertEquals(2, payments.size());
	}

	/**
	 * Mockito Test case for the method getting all the payments in form of list by vehicle
	 */
	@Test
	void testFindAllPaymentsByVehicle() {
		Payment payment1 = new Payment(10007, "Online", LocalDate.of(2021, 05, 07), "Success");
		Booking booking1 = new Booking(107, LocalDate.of(2021, 05, 07), LocalDate.of(2021, 05, 07), "Success", 800.0,
				7.0);
		Vehicle vehicle1 = new Vehicle(1007, "TN08A34", "car", "ac", "small", "Chennai", "4seater", 50.0, 60.0);
		Payment payment2 = new Payment(10008, "Online", LocalDate.of(2021, 05, 06), "Success");
		Booking booking2 = new Booking(108, LocalDate.of(2021, 05, 06), LocalDate.of(2021, 05, 07), "Success", 800.0,
				7.0);
		Vehicle vehicle2 = new Vehicle(1008, "TN08A34", "car", "ac", "small", "Chennai", "4seater", 50.0, 60.0);
		booking1.setVehicle(vehicle1);
		booking2.setVehicle(vehicle2);
		List<Payment> payment = new ArrayList<>();
		payment.add(payment1);
		payment.add(payment2);
		Mockito.when(payRepo.findAll()).thenReturn(payment);
		List<Payment> payments = payService.viewAllPayments();
		System.out.println(payments);
		assertEquals(2, payments.size());
	}

	/**
	 * Mockito Test case for the method updating the payment status of a payment
	 */
	@Test
	void testUpdatePaymentStatus() {
		Payment payment = new Payment(10008, "Online", LocalDate.of(2021, 05, 07), "Pending");
		Mockito.when(payRepo.findById(10008)).thenReturn(Optional.of(payment));
		Mockito.when(payRepo.save(payment)).thenReturn(payment);
		Payment persistedPa = payService.updatePaymentStatus(10008, payment);
		System.out.println(persistedPa);
		assertEquals("Pending", persistedPa.getPaymentStatus());
	}
	
}