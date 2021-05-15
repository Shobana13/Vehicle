package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;

public interface IPaymentService {
	public Payment addPayment(Payment payment);

	public Payment cancelPayment(int p);

	public Payment viewPayment(int b);

	public List<Payment> viewAllPayments(Vehicle vehicle);

	public List<Payment> viewAllPayments();

}
