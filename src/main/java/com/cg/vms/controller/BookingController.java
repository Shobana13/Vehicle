package com.cg.vms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.vms.entities.Booking;
import com.cg.vms.exceptions.BookingNotFoundException;
import com.cg.vms.service.IBookingService;

public class BookingController {

	@Autowired
	IBookingService bokService;

	@PostMapping("/booking")
	public Booking AddBooking(@RequestBody Booking booking) {
		return bokService.addBooking(booking);
	}

	@DeleteMapping("/booking/{id}")
	public Booking CancelBooking(@PathVariable("id") Booking bok) {
		if (bokService.cancelBooking(bok) == null) {
			throw new BookingNotFoundException("Booking Not Found with this Id" + bok.getBookingId());
		}
		return bokService.cancelBooking(bok);
	}

	@PatchMapping("/booking/{id}")
	public Booking UpdateBookingDate(@PathVariable("id") int bookingId, @RequestBody Booking booking) {
		if (bokService.updateBookingDate(bookingId, booking) == null) {
			throw new BookingNotFoundException("Customer not found with this id:" + bookingId);
		}
		return bokService.updateBookingDate(bookingId, booking);
	}

	@GetMapping("/booking/id/{id}")
	public Booking ViewBooking(@PathVariable("id") Booking booking) {
		return bokService.viewBooking(booking);
	}

	@GetMapping("/booking/{id}")
	public List<Booking> viewAllBookingByCustomer(@PathVariable("id") int customerId) {
		return bokService.viewAllBookingByCustomer(customerId);
	}

	@GetMapping("/booking/bookingDate/{bookingDate}")
	public List<Booking> viewAllBookingByBookingDate(@PathVariable("bookingDate") LocalDate bookingDate) {
		return bokService.viewAllBookingByBookingDate(bookingDate);
	}

	@GetMapping("/booking/vehicle/{id}")
	public List<Booking> viewAllBookingByVehicleId(@PathVariable("id") int vehicleId) {
		return bokService.viewAllBookingByVehicleId(vehicleId);
	}


}
