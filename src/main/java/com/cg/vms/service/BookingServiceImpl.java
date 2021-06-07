package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Booking;
import com.cg.vms.repository.IBookingRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	IBookingRepository bokRep;

	@Override
	public Booking addBooking(Booking booking) {
		return bokRep.save(booking);
	}

	@Override
	public Booking cancelBooking(Booking bo) {

		Optional<Booking> bok = bokRep.findById(bo.getBookingId());
		if (!bok.isPresent()) {
			return null;
		}
		bokRep.deleteById(bo.getBookingId());
		return bok.get();
	}

	@Override
	public Booking updateBookingDate(int bookingId, Booking booking) {
		Optional<Booking> bok = bokRep.findById(bookingId);
		if (bok.isPresent()) {
			bok.get().setBookingDate(booking.getBookingDate());
			return bokRep.save(bok.get());
		}

		return null;
	}

	@Override
	public Booking viewBooking(Booking booking) {
		Optional<Booking> bok = bokRep.findById(booking.getBookingId());
		if (!bok.isPresent()) {
			return null;
		}
		return bok.get();

	}

	@Override
	public List<Booking> viewAllBookingByCustomer(int customerId) {
		return bokRep.viewAllBookingByCustomer(customerId);
	}

	@Override
	public List<Booking> viewAllBookingByBookingDate(LocalDate bookingDate) {
		return bokRep.viewAllBookingbyBookingDate(bookingDate);
	}

	@Override
	public List<Booking> viewAllBookingByVehicleId(int vehicleId) {
		return bokRep.viewAllBookingByVehicle(vehicleId);
	}
}
