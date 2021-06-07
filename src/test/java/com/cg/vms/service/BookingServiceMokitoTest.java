package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.vms.entities.Booking;
import com.cg.vms.repository.IBookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.vms.entities.Customer;
import com.cg.vms.entities.Vehicle;

@ExtendWith(SpringExtension.class)
public class BookingServiceMokitoTest {

	@InjectMocks
	BookingServiceImpl bokService;

	@MockBean
	IBookingRepository bokRep;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Mokito test case for the method, adding new booking in database
	 */
	@Test
//	@Disabled
	void testCreateBooking() {
		Booking booking = new Booking(101, LocalDate.of(2020, 10, 10), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Mockito.when(bokRep.save(booking)).thenReturn(booking);
		Booking persistedbok = bokService.addBooking(booking);
		assertEquals(101, persistedbok.getBookingId());
	}

	/**
	 * Mokito test case for the method, retrieving the booking details through
	 * booking Id
	 */
	@Test
//	@Disabled
	void testViewBooking() {
		Booking booking1 = new Booking(101, LocalDate.of(2020, 10, 10), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);

		Mockito.when(bokRep.findById(101)).thenReturn(Optional.of(booking1));
		Booking booking = bokService.viewBooking(booking1);
		assertEquals(101, booking.getBookingId());

	}

	/**
	 * Mokito test case for the methods retrieving the booking details through
	 * booking date
	 */
	@Test
//	@Disabled
	void testViewAllBookingByDate() {
		Booking booking1 = new Booking(101, LocalDate.of(2020, 10, 10), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Booking booking2 = new Booking(102, LocalDate.of(2021, 10, 11), LocalDate.of(2020, 10, 12), "Good", 200.00,
				2000.00);
		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking1);
		bookingList.add(booking2);
		Mockito.when(bokRep.viewAllBookingbyBookingDate(LocalDate.of(2021, 10, 11))).thenReturn(bookingList);
		List<Booking> booking = bokService.viewAllBookingByBookingDate(LocalDate.of(2021, 10, 11));
		assertEquals(2, booking.size());

	}

	/**
	 * Mokito test case for the method, updating the booking date in the database
	 * through booking Id
	 */
	@Test
//	@Disabled
	void testUpdateBooking() {
		Booking booking = new Booking(101, LocalDate.of(2020, 10, 12), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Mockito.when(bokRep.findById(101)).thenReturn(Optional.of(booking));
		Mockito.when(bokRep.save(booking)).thenReturn(booking);
		Booking persistedBok = bokService.updateBookingDate(101, booking);
		assertEquals(101, persistedBok.getBookingId());
		assertEquals(LocalDate.of(2020, 10, 12), persistedBok.getBookingDate());

	}

	/**
	 * Mokito test case for the method, deleting the booking entity in the database
	 * through booking Id
	 */
	@Test
	@Disabled
	void testCancelBooking() {

		Booking booking = new Booking(101, LocalDate.of(2020, 10, 12), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Mockito.when(bokRep.findById(101)).thenReturn(Optional.of(booking));
		bokRep.deleteById(101);
		Booking persistedBok = bokService.cancelBooking(101);
		assertEquals(LocalDate.of(2020, 10, 12), persistedBok.getBookingDate());

	}

	/**
	 * Mokito test case for the method, getting the booking details by entering the
	 * customerId
	 */
	@Test
//	@Disabled
	void testviewaAllBookingByCustomer() {
		Booking booking1 = new Booking(102, LocalDate.of(2021, 11, 10), LocalDate.of(2020, 10, 12), "Good", 200.00,
				2000.00);
		Customer customer1 = new Customer(1, "tom", "son", "951771122", "tom@gmail.com");
		Booking booking2 = new Booking(103, LocalDate.of(2021, 10, 10), LocalDate.of(2020, 10, 11), "Nice", 300.00,
				3000.00);
		Customer customer2 = new Customer(2, "jerry", "lee", "951998122", "jerry@gmail.com");
		booking1.setCustomer(customer1);
		booking2.setCustomer(customer2);
		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking1);
		bookingList.add(booking2);
		Mockito.when(bokRep.viewAllBookingByCustomer(2)).thenReturn(bookingList);
		List<Booking> bok3 = bokService.viewAllBookingByCustomer(2);
		assertEquals(2, bok3.size());

	}

	/**
	 * Mokito test case for the method, getting the booking details by entering the
	 * Vehicle Id
	 */
	@Test
//	@Disabled
	void testviewAllBookingByVehicle() {
		Booking booking1 = new Booking(103, LocalDate.of(2020, 11, 10), LocalDate.of(2020, 10, 12), "Good", 200.00,
				2000.00);
		Vehicle vehicle1 = new Vehicle(121, "TN02J0666", "bus", "A/C", "prime", "goa", "13", 600.0, 8000.0);
		Booking booking2 = new Booking(104, LocalDate.of(2021, 10, 10), LocalDate.of(2020, 11, 10), "Nice", 300.00,
				3000.00);
		Vehicle vehicle2 = new Vehicle(102, "TN02J0666", "car", "A/C", "prime", "goa", "13", 600.0, 8000.0);
		booking1.setVehicle(vehicle1);
		booking2.setVehicle(vehicle2);
		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking1);
		bookingList.add(booking2);
		Mockito.when(bokRep.viewAllBookingByVehicle(102)).thenReturn(bookingList);
		List<Booking> bok3 = bokService.viewAllBookingByVehicleId(102);
		assertEquals(2, bok3.size());

	}

}
