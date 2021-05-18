package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;

public interface IPaymentService {
	public Payment addPayment(Payment payment);
	public Payment cancelPayment(int p);
	public Payment viewPayment(int b);
	public Payment updatePaymentStatus(int paymentId, Payment payment);
	public List<Payment> viewAllPayments(Vehicle vehicle);
	public List<Payment> viewAllPayments();
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2);
	public Booking calculateTotalBookingCost(int paymentId, double distance, Vehicle vehicle);
	public double calculateTotalPayment(int bookingStartId, int bookingEndId);
}
