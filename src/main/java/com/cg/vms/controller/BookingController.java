package com.cg.vms.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Booking;
import com.cg.vms.exceptions.BookingNotFoundException;
import com.cg.vms.service.IBookingService;

@RestController
public class BookingController {

	@Autowired
	IBookingService bokService;
	
	//Add Booking
	@PostMapping("/booking")
	public Booking addBooking(@RequestBody Booking booking) {
		return bokService.addBooking(booking);
	}

	//Delete Booking
	@DeleteMapping("/booking/{id}")
	public Booking cancelBooking(@PathVariable("id") Booking bok) {
		if (bokService.cancelBooking(bok) == null) {
			throw new BookingNotFoundException("Booking Not Found with this Id" + bok.getBookingId());
		}
		return bokService.cancelBooking(bok);
	}

	//Update Booking
	@PatchMapping("/booking/{id}")
	public Booking updateBookingDate(@PathVariable("id") int bookingId, @RequestBody Booking booking) {
		if (bokService.updateBookingDate(bookingId, booking) == null) {
			throw new BookingNotFoundException("Customer not found with this id:" + bookingId);
		}
		return bokService.updateBookingDate(bookingId, booking);
	}
	
	//View Booking By Id
	@GetMapping("/booking/id/{id}")
	public Booking viewBooking(@PathVariable("id") Booking booking) {
		return bokService.viewBooking(booking);
	}

	//View Booking by CustomerId
	@GetMapping("/booking/{id}")
	public List<Booking> viewAllBookingByCustomer(@PathVariable("id") int customerId) {
		return bokService.viewAllBookingByCustomer(customerId);
	}

	//View Booking By booking Date
	@GetMapping("/booking/bookingDate/{bookingDate}")
	public List<Booking> viewAllBookingByBookingDate(@PathVariable("bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate bookingDate) {		
		return bokService.viewAllBookingByBookingDate(bookingDate);
	}
	
	//View Booking by VehicleId
	@GetMapping("/booking/vehicle/{id}")
	public List<Booking> viewAllBookingByVehicleId(@PathVariable("id") int vehicleId) {
		return bokService.viewAllBookingByVehicleId(vehicleId);
	}
}
