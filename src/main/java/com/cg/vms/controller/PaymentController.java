package com.cg.vms.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.exceptions.PaymentNotFoundException;
import com.cg.vms.service.IPaymentService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PaymentController {
	
	/**
	 * We are Autowiring the payment service layer to this payment controller layer
	 * 
	 * @param paymentServiceImp
	 */
	@Autowired
	IPaymentService payService;
	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentController.class);

	/**
	 * This controller is used to create a new payment or add new payment and redirects it
	 * to the service layer
	 * 
	 * @param 
	 * @return
	 */
	@PostMapping("/payment")
	public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment payment) {
		logger.info("Adding new Payment");
		payService.addPayment(payment);
		return ResponseEntity.ok(payment);
	}

	/**
	 * This controller is used to get a specific payment on basis of ID
	 * 
	 * @param id
	 * @return
	 * @throws PaymentNotFoundException
	 */
	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> viewPayment(@PathVariable("id") int paymentId) {
		logger.info("Viewing Payment");
		if (payService.viewPayment(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: " + paymentId);
		}
		Payment payment = payService.viewPayment(paymentId);
		return ResponseEntity.ok().body(payment);
	}

	/**
	 * 
	 * this controller function perform cancelation of a specific given payment and
	 * request the service to perform the action and returns the message as canceled
	 * else throw exception
	 * 
	 * @param paymentid
	 * @return
	 * @throws PaymentNotFoundException
	 */
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<Payment> cancelPayment(@PathVariable("id") int paymentId) {
		logger.info("Cancel Payment");
		if (payService.cancelPayment(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with id: " + paymentId);
		}
		return ResponseEntity.ok().body(payService.cancelPayment(paymentId));
	}

	/**
	 * This controller is used to return and list all the payments by vehicle found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/vehicle1")
	public ResponseEntity<List<Payment>> viewAllPayments(Vehicle vehicle) {
		logger.info("View all Payments by Vehicle");
		return ResponseEntity.ok().body(payService.viewAllPayments(vehicle));
	}

	/**
	 * This controller is used to return and list all the payments found in the
	 * database and request to the service to perform the action
	 *  
	 * @return
	 */
	@GetMapping("/payment")
	public ResponseEntity<List<Payment>> viewAllPayments() {
		logger.info("View all Payments");
		return ResponseEntity.ok().body(payService.viewAllPayments());
	}

	/**
	 * This function is used to update a specific payment status on basis of given
	 * payment id and returns exception if given payment id is not found.
	 * 
	 * @param id
	 * @param payment
	 * @return
	 * @throws PaymentNotFoundException
	 */
	@PatchMapping("/payment/{id}")
	public ResponseEntity<Payment> updatePaymentStatus(@PathVariable("id") int paymentId, @RequestBody Payment payment) {
		logger.info("Update Payment Status");
		if (payService.updatePaymentStatus(paymentId, payment) == null) {
			throw new PaymentNotFoundException("Payment not found with this id: " + paymentId);
		}
		return ResponseEntity.ok().body(payService.updatePaymentStatus(paymentId, payment));
	}

	/** This function is used to Calculate Monthly Revenue on the basis of given payment date range
	 * and returns exception if payment is not found within the given date range.  
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 * @throws PaymentNotFoundException
	 */
	@GetMapping("/payment/localdate1/{localdate1}/localdate2/{localdate2}")
	public ResponseEntity<Double> calculateMonthlyRevenue(
			@PathVariable("localdate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate d1,
			@PathVariable("localdate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate d2) {
		logger.info("Calculate Monthly Revenue");
		if (payService.calculateMonthlyRevenue(d1, d2) == 0) {
			throw new PaymentNotFoundException("Payment not found with these Date range: " + d1 + d2);
		}
		return ResponseEntity.ok().body(payService.calculateMonthlyRevenue(d1, d2));
	}

	/** This function is used to Calculate Total Booking Cost on the basis of given payment ID, distance and 
	 * vehicle parameters such as charges per km, fixed charges. It returns exception if given payment id is not found.   
	 * 
	 * @param paymentId
	 * @param distance
	 * @param vehicle
	 * @return
	 * @throws PaymentNotFoundException
	 */
	@PatchMapping("/payment/paymentId/{paymentId}/distance/{distance}/vehicle")
	public ResponseEntity<Booking> calculateTotalBookingCost(@PathVariable("paymentId") int paymentId,
			@PathVariable("distance") double distance, Vehicle vehicle) {
		logger.info("Calculate Total Booking Cost");
		if (payService.calculateTotalBookingCost(paymentId, distance, vehicle) == null) {
			throw new PaymentNotFoundException("Payment not found with this paymentId: " + paymentId);
		}
		return ResponseEntity.ok().body(payService.calculateTotalBookingCost(paymentId, distance, vehicle));
	}

	/** This function is used to Calculate Total Payment on the basis of given booking id range
	 * and returns exception if payment is not found within the given booking id range. 
	 * 
	 * @param bookingStartId
	 * @param bookingEndId
	 * @return
	 * @throws PaymentNotFoundException
	 */
	@GetMapping("/booking/id1/{id1}/id2/{id2}")
	public ResponseEntity<Double> calculateTotalPayment(@PathVariable("id1") int bookingStartId,
			@PathVariable("id2") int bookingEndId) {
		logger.info("Calculate Total Payment");
		if (payService.calculateTotalPayment(bookingStartId, bookingEndId) == 0) {
			throw new PaymentNotFoundException(
					"Payment not found with these paymentId: " + bookingStartId + bookingEndId);
		}
		return ResponseEntity.ok().body(payService.calculateTotalPayment(bookingStartId, bookingEndId));
	}

}
