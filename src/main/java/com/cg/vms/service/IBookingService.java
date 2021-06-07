package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.vms.entities.Booking;

public interface IBookingService {

	/**
	 *Method to be override by the implementing class
	 */
	public Booking addBooking(Booking booking);

	/**
	 *Method to be override by the implementing class
	 */
	public Booking cancelBooking(int bookingId);

	/**
	 *Method to be override by the implementing class
	 */
	public Booking updateBookingDate(int bookingId,Booking book);

	/**
	 *Method to be override by the implementing class
	 */
	public Booking viewBooking(Booking book);

	/**
	 *Method to be override by the implementing class
	 */
	public List<Booking> viewAllBookingByCustomer(int customerId);

	/**
	 *Method to be override by the implementing class
	 */
	public List<Booking> viewAllBookingByBookingDate(LocalDate bookingDate);

	/**
	 *Method to be override by the implementing class
	 */
	public List<Booking> viewAllBookingByVehicleId(int vehicleId);

	/**
	 *Method to be override by the implementing class
	 */
	public List<Booking> viewAllBooking();

}
