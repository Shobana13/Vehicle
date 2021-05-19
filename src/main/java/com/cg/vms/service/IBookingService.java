package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.vms.entities.Booking;

public interface IBookingService {

	public Booking addBooking(Booking booking);

	public Booking cancelBooking(Booking book);

	public Booking updateBookingDate(int bookingId,Booking book);

	public Booking viewBooking(Booking book);

	public List<Booking> viewAllBookingByCustomer(int customerId);

	public List<Booking> viewAllBookingByBookingDate(LocalDate bookingDate);

	public List<Booking> viewAllBookingByVehicleId(int vehicleId);
}
