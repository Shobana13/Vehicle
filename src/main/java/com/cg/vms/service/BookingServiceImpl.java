package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.repository.IBookingRepository;


@Service
public class BookingServiceImpl implements IBookingService {

	
	@Autowired
	IBookingRepository bokRep;

	@Override
	public Booking save(Booking booking) {
		return bokRep.save(booking);
	}

		
	@Override
	public Booking cancelBooking(Booking b) {
		Booking book=bokRep.findById(b.getBookingId()).get();
		bokRep.deleteById(b.getBookingId());
		return b;
		
	}
	

	@Override
	public Booking updateBookingDate(int bookingId, Booking booking) {
		Optional<Booking> bok=bokRep.findById(bookingId);
		if(bok.isPresent()) {
			bok.get().setBookingDate(booking.getBookingDate());
		}
		
		return bokRep.save(bok.get());
	}

	@Override
	public Booking viewBooking(int bok) {
		Booking pa = bokRep.findById(bok).get();
		return pa;
	}


	@Override
	public List<Booking> viewAllBooking( Customer customer) {
		
		return bokRep.findAll();
	}

	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) {
		
		return bokRep.viewAllBookingByDate(bookingDate);
	}

	@Override
	public List<Booking> viewAllBookingByVehicle(Vehicle vehicle) {
		
		return bokRep.viewAllBookingByVehicle(vehicle);
	}




	
}

		


