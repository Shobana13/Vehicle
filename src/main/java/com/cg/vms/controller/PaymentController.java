package com.cg.vms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.exceptions.PaymentNotFoundException;
import com.cg.vms.service.IPaymentService;

@RestController
public class PaymentController {

	@Autowired
	IPaymentService payService;

	// add Payment
	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment payment) {
		return payService.addPayment(payment);
	}

	// view Payment
	@GetMapping("/payment/id/{id}")
	public Payment viewPayment(@PathVariable("id") int paymentId) {
		if (payService.viewPayment(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: " + paymentId);
		}
		return payService.viewPayment(paymentId);
	}

	// cancel Payment
	@DeleteMapping("/payment/{id}")
	public Payment cancelPayment(@PathVariable("id") int paymentId) {
		if (payService.cancelPayment(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with id: " + paymentId);
		}
		return payService.cancelPayment(paymentId);
	}

	// view all Payment by Vehicle
	@GetMapping("/vehicle1")
	public List<Payment> viewAllPayments(Vehicle vehicle) {
		return payService.viewAllPayments(vehicle);
	}

	// view all Payment
	@GetMapping("/payment")
	public List<Payment> viewAllPayments() {
		return payService.viewAllPayments();
	}

	// update Payment Status
	@PatchMapping("/payment/{id}")
	public Payment updatePaymentStatus(@PathVariable("id") int paymentId, Payment payment) {
		if (payService.updatePaymentStatus(paymentId, payment) == null) {
			throw new PaymentNotFoundException("Payment not found with this id: " + paymentId);
		}
		return payService.updatePaymentStatus(paymentId, payment);
	}

	// Calculate Monthly Revenue
	@GetMapping("/payment/localdate1/{localdate1}/localdate2/{localdate2}")
	public double calculateMonthlyRevenue(
			@PathVariable("localdate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate d1,
			@PathVariable("localdate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate d2) {
		if (payService.calculateMonthlyRevenue(d1, d2) == 0) {
			throw new PaymentNotFoundException("Payment not found with these Date range: " + d1 + d2);
		}
		return payService.calculateMonthlyRevenue(d1, d2);
	}

	// Calculate Total Booking Cost
	@PatchMapping("/payment/paymentId/{paymentId}/distance/{distance}/vehicle")
	public Booking calculateTotalBookingCost(@PathVariable("paymentId") int paymentId,
			@PathVariable("distance") double distance, Vehicle vehicle) {
		if (payService.calculateTotalBookingCost(paymentId, distance, vehicle) == null) {
			throw new PaymentNotFoundException("Payment not found with this paymentId: " + paymentId);
		}
		return payService.calculateTotalBookingCost(paymentId, distance, vehicle);
	}

	// Calculate Total Payment
	@GetMapping("/booking/id1/{id1}/id2/{id2}")
	public double calculateTotalPayment(@PathVariable("id1") int bookingStartId,
			@PathVariable("id2") int bookingEndId) {
		if (payService.calculateTotalPayment(bookingStartId, bookingEndId) == 0) {
			throw new PaymentNotFoundException(
					"Payment not found with these paymentId: " + bookingStartId + bookingEndId);
		}
		return payService.calculateTotalPayment(bookingStartId, bookingEndId);
	}

}
