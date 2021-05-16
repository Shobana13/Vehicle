package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Payment;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IPaymentRepository;

@Service
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	IPaymentRepository payRepo;

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

}
