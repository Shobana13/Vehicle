package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IBookingRepository;
import com.cg.vms.repository.IPaymentRepository;

@Service
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	IPaymentRepository payRepo;

	@Autowired
	IBookingRepository bokRepo;

	@Override
	public Payment addPayment(Payment payment) {
		return payRepo.save(payment);
	}

	@Override
	public Payment cancelPayment(int p) {
		Optional<Payment> pa = payRepo.findById(p);
		if (!pa.isPresent()) {
			return null;
		}
		payRepo.deleteById(p);
		return pa.get();
	}

	@Override
	public Payment viewPayment(int b) {
		Optional<Payment> pa = payRepo.findById(b);
		if (!pa.isPresent()) {
			return null;
		}
		return pa.get();
	}

	@Override
	public List<Payment> viewAllPayments(Vehicle vehicle) {
		return payRepo.findAll();
	}

	@Override
	public List<Payment> viewAllPayments() {

		return payRepo.findAll();
	}

	@Override
	public Payment updatePaymentStatus(int paymentId, Payment payment) {
		Optional<Payment> pa = payRepo.findById(paymentId);
		if (pa.isPresent()) {
			pa.get().setPaymentStatus(payment.getPaymentStatus());
			return payRepo.save(pa.get());
		}
		return null;
	}

	@Override
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2) {
		return payRepo.calculateMonthlyRevenue(d1, d2);
	}

	@Override
	public double calculateTotalPayment(int bookingStartId, int bookingEndId) {
		return payRepo.calculateTotalPayment(bookingStartId, bookingEndId);
	}

	@Override
	public Booking calculateTotalBookingCost(int paymentId, double distance, Vehicle vehicle) {

		Optional<Payment> opt = payRepo.findById(paymentId);
		if (opt.isPresent()) {

			Payment payment = opt.get();
			Booking booking = payment.getBooking();
			booking.setDistance(distance);
			bokRepo.save(booking);
		}
		Optional<Payment> opt1 = payRepo.findById(paymentId);
		if (!opt1.isPresent()) {
			return null;
		}
		Payment payment2 = opt1.get();
		Booking booking1 = payment2.getBooking();
		booking1.setDistance(distance);
		double totalCost = (vehicle.getChargesPerKM() * distance) + vehicle.getFixedCharges();
		booking1.setTotalCost(totalCost);
		return bokRepo.save(booking1);
	}

}
