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

	/**
	 * This function will add new booking in the list
	 */
	@Override
	public Booking addBooking(Booking booking) {
		return bokRep.save(booking);
	}

	/**
	 * This function will delete a booking from the list
	 */
	@Override
	public Booking cancelBooking(int bookingId) {

		Optional<Booking> bok = bokRep.findById(bookingId);
		if (!bok.isPresent()) {
			return null;
		}
		bokRep.deleteById(bookingId);
		return bok.get();
	}

	/**
	 * This function will update the booking date from the booking table
	 */
	@Override
	public Booking updateBookingDate(int bookingId, Booking booking) {
		Optional<Booking> bok = bokRep.findById(bookingId);
		if (bok.isPresent()) {
			bok.get().setBookingDate(booking.getBookingDate());
			return bokRep.save(bok.get());
		}

		return null;
	}

	/**
	 * This function will display the details of booking based on booking Id
	 */
	@Override
	public Booking viewBooking(Booking booking) {
		Optional<Booking> bok = bokRep.findById(booking.getBookingId());
		if (!bok.isPresent()) {
			return null;
		}
		return bok.get();

	}
	
	
	/**
	 * This function will display the booking details based on customer Id
	 */
	@Override
	public List<Booking> viewAllBookingByCustomer(int customerId) {
		Optional<Booking> bok=bokRep.findById(customerId);
		if(!bok.isPresent()) {
			return null;
		}
		return bokRep.viewAllBookingByCustomer(customerId);
		
	}


	/**
	 * This function will display the bookings done on a particular date
	 */
	@Override
	public List<Booking> viewAllBookingByBookingDate(LocalDate bookingDate) {
		/*
		Optional<Booking> bok=bokRep.viewAllBookingbyBookingDate(bookingDate);
		if(!bok.isPresent()){
			return null;
		}
		*/
		return bokRep.viewAllBookingbyBookingDate(bookingDate);
	}

	/**
	 * This function will display the booking details based on Vehicle Id
	 */
	@Override
	public List<Booking> viewAllBookingByVehicleId(int vehicleId) {
		Optional<Booking> bok=bokRep.findById(vehicleId);
		if(!bok.isPresent()) {
			return null;
		}
		return bokRep.viewAllBookingByVehicle(vehicleId);
	}

	/**
	 * This function will display all the entities present in the booking table
	 */
	@Override
	public List<Booking> viewAllBooking() {
		// TODO Auto-generated method stub
		return bokRep.findAll();
	}

}
