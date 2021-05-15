package com.cg.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.exceptions.PaymentNotFoundException;
import com.cg.vms.service.IPaymentService;

@RestController
public class PaymentController {

	@Autowired
	IPaymentService payService;

	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment payment) {
		return payService.addPayment(payment);
	}

	@GetMapping("/payment/id/{id}")
	public Payment viewPayment(@PathVariable("id") int paymentId) {
		if (payService.viewPayment(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: " + paymentId);
		}
		return payService.viewPayment(paymentId);
	}

	@DeleteMapping("/payment/{id}")
	public Payment cancelPaymet(@PathVariable("id") int paymentId) {
		if (payService.cancelPayment(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: " + paymentId);
		}
		return payService.cancelPayment(paymentId);
	}

	@GetMapping("/vehicle")
	public List<Payment> viewAllPayments(Vehicle vehicle) {
		return payService.viewAllPayments(vehicle);
	}

}
