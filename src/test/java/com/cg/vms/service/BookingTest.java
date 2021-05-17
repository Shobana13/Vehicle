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

@SpringBootTest
class BookingTest {

	@Autowired
	IBookingService bokService;

	@Test
	@Disabled
	void testShouldAddBooking() {
		LocalDate bd1 = LocalDate.of(2020, 12, 20);
		LocalDate bd2 = LocalDate.of(2020, 12, 30);
		Customer cust = new Customer(12, "Nimbo", "Ramani", "nimbo@gmail.com", "9514555555");
		Booking b1 = new Booking(206, bd1, bd2, "Better", 900.00, 10000.60);
		Vehicle vehicle = new Vehicle(310, "TN 02 0903", "car", "Non A/C", "deluxe", "Tambaram", "40", 110.0, 90.0);
		b1.setVehicle(vehicle);
		b1.setCustomer(cust);
		Booking persistedBok = bokService.addBooking(b1);
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
		Booking bok = new Booking();
		bok.setBookingId(234);
		Booking bok1 = bokService.cancelBooking(bok);
		assertEquals(234, bok1.getBookingId());

	}

	@Test
	@Disabled
	void testShouldUpdateBooking() {
		Booking bok = new Booking();
		bok.setBookingId(101);
		LocalDate bd1 = LocalDate.of(2020, 10, 10);
		bok.setBookingDate(bd1);
		Booking updatedBok = bokService.updateBookingDate(101, bok);
		System.out.println(updatedBok);
		assertEquals(1000.00, updatedBok.getDistance());
	}

	@Test
	@Disabled
	void testShouldViewBookingById() {
		Booking bok = new Booking();
		bok.setBookingId(101);
		System.out.println(bok);
		Booking bok1 = bokService.viewBooking(bok);
		assertEquals(1000.00, bok1.getDistance());
	}

	@Test
	@Disabled
	void testShouldGetAllBookingByCusomerId() {
		List<Booking> booking = bokService.viewAllBookingByCustomer(201);
		assertEquals(1, booking.size());

	}

	@Test
	@Disabled
	void testShouldGetAllBookingByBookingDate() {
		Booking bok = new Booking();
		LocalDate bd1 = LocalDate.of(2020, 10, 10);
		bok.setBookingDate(bd1);
		List<Booking> b1 = bokService.viewAllBookingByBookingDate(bd1);
		for (Booking b : b1) {
			System.out.println(b);
		}
		assertEquals(1, b1.size());

	}

	@Test
	@Disabled
	void testShouldGetAllBookingByVehicleId() {
		List<Booking> b1 = bokService.viewAllBookingByVehicleId(301);
		System.out.println(b1);
		assertEquals(1, b1.size());
	}

}
