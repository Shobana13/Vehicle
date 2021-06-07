package com.cg.vms.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Booking;
import com.cg.vms.exceptions.BookingNotFoundException;
import com.cg.vms.service.IBookingService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookingController {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BookingController.class);

	/**
	 * We are overriding the booking service layer of booking
	 */
	@Autowired
	IBookingService bokService;

	/**
	 * This controller is used to add new booking in the booking table.
	 * 
	 * @param booking
	 * @return
	 */
	@PostMapping("/booking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		logger.info("Add new Booking");
				bokService.addBooking(booking);
		return ResponseEntity.ok(booking);
	}

	/**
	 * This controller is used to delete an entity based on booking Id and returns
	 * exception if booking Id is not found
	 * 
	 * @param bok
	 * @return
	 * @throws BookingNotFoundException
	 */
	@DeleteMapping("/booking/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("id") int bookingId) {
		logger.info("Delete Booking");
		if (bokService.cancelBooking(bookingId) == null) {
			throw new BookingNotFoundException("Booking Not Found with this Id: " + bookingId);

		}
		return ResponseEntity.ok().body(bokService.cancelBooking(bookingId));
	}

	/**
	 * This controller is used to update a specific booking date based on booking Id
	 * and returns exception if Booking Id is not found.
	 * 
	 * @param bookingId
	 * @param booking
	 * @return
	 * @throws BookingNotFoundException
	 */
	@PatchMapping("/booking/{id}")
	public ResponseEntity<Booking> updateBookingDate(@PathVariable("id") int bookingId, @RequestBody Booking booking) {
		logger.info("Update Booking Date");

		return ResponseEntity.ok().body(bokService.updateBookingDate(bookingId, booking));
	}

	/**
	 * This function is used to view Booking details based on booking Id and returns
	 * exception if Booking Id is not found.
	 * 
	 * @param booking
	 * @return
	 * @throws BookingNotFoundException
	 */
	@GetMapping("/booking/{id}")
	public ResponseEntity<Booking> viewBooking(@PathVariable("id") Booking booking) {
		logger.info("View Booking by BookingId");

		return ResponseEntity.ok().body(bokService.viewBooking(booking));
	}

	/**
	 * This function is used to view booking details based on customer Id and
	 * returns exception if customer Id is not found.
	 * 
	 * @param customerId
	 * @return
	 * @throws BookingNotFoundException
	 */
	@GetMapping("/booking/id/{id}")
	public ResponseEntity<List<Booking>> viewAllBookingByCustomer(@PathVariable("id") int customerId) {
		logger.info("View Booking by Customer Id");
		if (bokService.viewAllBookingByCustomer(customerId) == null) {
			throw new BookingNotFoundException("Customer not found with this id: " + customerId);
		}
		return ResponseEntity.ok().body(bokService.viewAllBookingByCustomer(customerId));
	}

	/**
	 * This function is used to get the details of booking through booking date and
	 * returns exception if booking date is not found.
	 * 
	 * @param bookingDate
	 * @return
	 * @throws BookingNotFoundException
	 */
	@GetMapping("/booking/bookingDate/{bookingDate}")
	public ResponseEntity<List<Booking>> viewAllBookingByBookingDate(
			@PathVariable("bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate bookingDate) {
		if (bokService.viewAllBookingByBookingDate(bookingDate) == null) {
			throw new BookingNotFoundException("Booking not found with this date:" + bookingDate);
		}
		logger.info("View Booking by booking date");
		return ResponseEntity.ok().body(bokService.viewAllBookingByBookingDate(bookingDate));
	}

	/**
	 * This function is used to get the booking details of booking through vehicle
	 * and returns exception if vehicle Id is not found
	 * 
	 * @param vehicleId
	 * @return
	 * @throws VehicleNotFoundException
	 */
	@GetMapping("/booking/vehicle/{id}")
	public ResponseEntity<List<Booking>> viewAllBookingByVehicleId(@PathVariable("id") int vehicleId) {
		if (bokService.viewAllBookingByVehicleId(vehicleId) == null) {
			throw new BookingNotFoundException("Booking not found with this id" + vehicleId);
		}
		logger.info("View Booking by vehicle Id");
		return ResponseEntity.ok().body(bokService.viewAllBookingByVehicleId(vehicleId));
	}

	/**
	 * This function is used to view all the booking
	 * 
	 * @return
	 */
	@GetMapping("/booking")
	public ResponseEntity<List<Booking>> viewAllBooking() {
		logger.info("Finding Booking in database");
		return ResponseEntity.ok().body(bokService.viewAllBooking());
	}

}
