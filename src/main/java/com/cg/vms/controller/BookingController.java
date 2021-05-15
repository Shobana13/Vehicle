package com.cg.vms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.service.IBookingService;

@RestController
public class BookingController {
	
	@Autowired
	IBookingService bokService;
	

	@PostMapping("/booking")
	public Booking save(@RequestBody Booking booking) {
		return bokService.save(booking);
	}

	@DeleteMapping("/booking/{id}")
	public Booking cancelBooking(@PathVariable("id") Booking bok) {
		return bokService.cancelBooking(bok);
	}

	@PatchMapping("/booking/{id}")
	public Booking updateBookingDate(@PathVariable("id") int id,@RequestBody Booking booking) {
		return bokService.updateBookingDate(id, booking);
	}
	

	@GetMapping("/booking/id/{id}")
	public List<Booking> viewBooking(@PathVariable Booking bok) {
		return bokService.viewBooking(bok);
	}

	@GetMapping("/booking/{id}")
	public List<Booking> viewAllBooking(@PathVariable("id")Customer customer) {
		return bokService.viewAllBookingByCustomer(customer);
	}

	@GetMapping("/booking")
	public List<Booking> viewAllBookingByDate(@RequestBody LocalDate bookingDate) {
		return bokService.viewAllBookingByDate(bookingDate);
	}

		
	@GetMapping("/booking")
	public List<Booking> viewAllBookingByVehicle(@RequestBody Vehicle vehicle) {
		return bokService.viewAllBookingByVehicle(vehicle);
	}
	

	



}
