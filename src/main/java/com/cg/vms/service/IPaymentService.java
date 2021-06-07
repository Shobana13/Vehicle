package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;

public interface IPaymentService {
	/**
	 * Method to be overridden by implementing class
	 * @param payment
	 * @return
	 */
	public Payment addPayment(Payment payment);
	
	/**
	 * Method to be overridden by implementing class
	 * @param p
	 * @return
	 */
	public Payment cancelPayment(int p);
	
	/**
	 * Method to be overridden by implementing class
	 * @param b
	 * @return
	 */
	public Payment viewPayment(int b);
	
	/**
	 * Method to be overridden by implementing class
	 * @param paymentId
	 * @param payment
	 * @return
	 */
	public Payment updatePaymentStatus(int paymentId, Payment payment);
	
	/**
	 * Method to be overridden by implementing class
	 * @param vehicle
	 * @return
	 */
	public List<Payment> viewAllPayments(Vehicle vehicle);
	
	/**
	 * Method to be overridden by implementing class
	 * @return
	 */
	public List<Payment> viewAllPayments();
	
	/**
	 * Method to be overridden by implementing class
	 * @param d1
	 * @param d2
	 * @return
	 */
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2);
	
	/**
	 * Method to be overridden by implementing class
	 */
	public Booking calculateTotalBookingCost(int paymentId, double distance, Vehicle vehicle);
	
	/**
	 * Method to be overridden by implementing class
	 * @param bookingStartId
	 * @param bookingEndId
	 * @return
	 */
	public double calculateTotalPayment(int bookingStartId, int bookingEndId);
}
