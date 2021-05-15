package com.cg.vms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.Vehicle;

public interface IBookingService {

	public Booking save(Booking booking);

	public Booking cancelBooking(Booking b);

	public Booking updateBookingDate(int bookingId, Booking booking);

	public List<Booking> viewBooking(Booking bok);

	public List<Booking> viewAllBookingByCustomer(Customer customer);

	public List<Booking> viewAllBookingByDate(LocalDate bookingDate);

	public List<Booking> viewAllBookingByVehicle(Vehicle vehicle);

}
