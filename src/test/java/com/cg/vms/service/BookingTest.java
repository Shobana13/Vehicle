package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.Vehicle;
import com.cg.vms.service.BookingServiceImpl;
import com.cg.vms.service.IBookingService;

@SpringBootTest
class BookingTest {

	@Autowired
	IBookingService bokService;

	@Test
	@Disabled
	void testShouldAddBooking() {
		IBookingService bokService = new BookingServiceImpl();
		Booking bok = new Booking();
		bok.setBookingId(234);
		LocalDate bd1 = LocalDate.of(2021, 10, 11);
		bok.setBookingDate(bd1);
		LocalDate bd2 = LocalDate.of(2021, 10, 22);
		bok.setBookedTillDate(bd2);
		bok.setBookingDescription("Great");
		bok.setTotalCost(2000.6);
		bok.setDistance(200.00);

		Booking persistedBok = bokService.save(bok);
		System.out.println(persistedBok);
		assertEquals(234, persistedBok.getBookingId());
		assertEquals(bd1, persistedBok.getBookingDate());
		assertEquals(bd2, persistedBok.getBookedTillDate());
		assertEquals("Great", persistedBok.getBookingDescription());
		assertEquals(2000.6, persistedBok.getTotalCost());
		assertEquals(200.00, persistedBok.getDistance());

	}

	@Test
	@Disabled
	void testShouldCancelBooking() {
		IBookingService bokService = new BookingServiceImpl();
		Booking bok = new Booking();
		bok.setBookingId(1);
		LocalDate bd1 = LocalDate.of(2020, 10, 07);
		bok.setBookingDate(bd1);
		LocalDate bd2 = null;
		bok.setBookedTillDate(bd2);
		bok.setBookingDescription(null);
		bok.setTotalCost(0);
		bok.setDistance(0);

		Booking bok1 = bokService.cancelBooking(bok);
		assertEquals(1, bok1.getBookingId());

	}

	@Test
	// @Disabled
	void testShouldUpdateBooking() {
		IBookingService bokService = new BookingServiceImpl();
		Booking bok = new Booking();
		bok.getBookingId();
		LocalDate bd1 = LocalDate.of(2020, 10, 10);
		bok.setBookingDate(bd1);
		LocalDate bd2 = LocalDate.of(2020, 10, 20);
		bok.setBookedTillDate(bd2);
		bok.setBookingDescription("Good");
		bok.setTotalCost(1000.6);
		bok.setDistance(200.00);
		Booking updatedBok = bokService.updateBookingDate(0, bok);
		System.out.println(updatedBok);
		assertEquals(200.00, updatedBok.getDistance());
	}

	@Test
	@Disabled
	void testShouldViewBooking() {
		IBookingService bokService = new BookingServiceImpl();
		Booking bok = new Booking();
		bok.setBookingId(1);
		LocalDate bd1 = LocalDate.of(2020, 10, 10);
		bok.setBookingDate(bd1);
		LocalDate bd2 = LocalDate.of(2020, 10, 20);
		bok.setBookedTillDate(bd2);
		bok.setBookingDescription("Good");
		bok.setTotalCost(1000.6);
		bok.setDistance(200.00);
		System.out.println(bok);
		Booking bok1 = bokService.viewBooking(101);
		assertEquals(200, bok1.getDistance());
	}

	@Test
	@Disabled
	void testShouldGetAllBooking() {
		IBookingService bokService = new BookingServiceImpl();
		LocalDate bd1 = LocalDate.of(2020, 12, 20);
		LocalDate bd2 = LocalDate.of(2020, 12, 30);

		Customer cust = new Customer(12, "Nimbo", "Ramani", "nimbo@gmail.com", "9514555555");
		Booking b1 = new Booking(206, bd1, bd2, "Better", 900.00, 10000.60);
		cust.setBooking(b1);
		b1.setCustomer(cust);
		// Booking bok=bokService.addBooking(b1);
		// System.out.println(bok);
		List<Booking> booking = bokService.viewAllBooking(cust);

		assertEquals(1, booking.size());

	}

	@Test
	@Disabled
	void testShouldGetAllBooking1() {
		IBookingService bokService = new BookingServiceImpl();

		Booking bok = new Booking();
		LocalDate bd1 = LocalDate.of(2020, 10, 10);
		bok.setBookingDate(bd1);

		List<Booking> b1 = bokService.viewAllBookingByDate(bd1);
		for (Booking b : b1) {
			System.out.println(b);
		}
		assertEquals(1, b1.size());

	}

	@Test
	// @Disabled
	void testShouldGetAllBooking2() {
		IBookingService bokService = new BookingServiceImpl();
		LocalDate bd1 = LocalDate.of(2020, 11, 10);
		LocalDate bd2 = LocalDate.of(2020, 11, 20);
		Booking booking = new Booking(204, bd1, bd2, "Good", 900.00, 10000.60);
		Vehicle vehicle = new Vehicle(310, "TN 02 0903", "car", "Non A/C", "deluxe", "Tambaram", "40", 110.0, 90.0);
		vehicle.setBooking(booking);
		booking.setVehicle(vehicle);
		List<Booking> b1 = bokService.viewAllBookingByVehicle(vehicle);
		for (Booking b : b1) {
			System.out.println(b);
		}
		assertEquals(1, b1.size());
	}

}
