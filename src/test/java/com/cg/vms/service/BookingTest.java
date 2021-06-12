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
	//@Disabled
	void testShouldAddBooking() {
		LocalDate bd1 = LocalDate.of(2020, 12, 20);
		LocalDate bd2 = LocalDate.of(2020, 12, 30);
		Customer cust = new Customer(1, "Nimbo", "Ramani", "nimbo@gmail.com", "9514555555","Sanam");
		Booking b1 = new Booking(101, bd1, bd2, "Better", 900.0, 10000.6);
		Vehicle vehicle = new Vehicle(4003, "KA 89 0999", "car", "non a/c", "Ultra Fast", "Ambattur", "6", 2.0,2.0);
		b1.setVehicle(vehicle);
		b1.setCustomer(cust);
		Booking persistedBok = bokService.addBooking(b1);
		System.out.println(persistedBok);
		assertEquals(101, persistedBok.getBookingId());
		assertEquals(bd1, persistedBok.getBookingDate());
		assertEquals(bd2, persistedBok.getBookedTillDate());
		assertEquals("Better", persistedBok.getBookingDescription());
		assertEquals(900.0, persistedBok.getTotalCost());
		assertEquals(10000.6, persistedBok.getDistance());

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
	//@Disabled
	void testShouldUpdateBooking() {
		Booking bok = new Booking();
		bok.setBookingId(101);
		LocalDate bd1 = LocalDate.of(2020, 12, 20);
		bok.setBookingDate(bd1);
		Booking updatedBok = bokService.updateBookingDate(101, bok);
		System.out.println(updatedBok);
		assertEquals(10000.6, updatedBok.getDistance());
	}

	@Test
	//@Disabled
	void testShouldViewBookingById() {
		Booking bok = new Booking();
		bok.setBookingId(101);
		System.out.println(bok);
		Booking bok1 = bokService.viewBooking(bok);
		assertEquals(10000.6, bok1.getDistance());
	}

	@Test
	//@Disabled
	void testShouldGetAllBookingByCusomerId() {
		List<Booking> booking = bokService.viewAllBookingByCustomer(1);
		assertEquals(1, booking.size());

	}

	@Test
	//@Disabled
	void testShouldGetAllBookingByBookingDate() {
		Booking bok = new Booking();
		LocalDate bd1 = LocalDate.of(2020, 12, 20);
		bok.setBookingDate(bd1);
		List<Booking> b1 = bokService.viewAllBookingByBookingDate(bd1);
		for (Booking b : b1) {
			System.out.println(b);
		}
		assertEquals(1, b1.size());

	}

	@Test
	//@Disabled
	void testShouldGetAllBookingByVehicleId() {
		List<Booking> b1 = bokService.viewAllBookingByVehicleId(4003);
		System.out.println(b1);
		assertEquals(1, b1.size());
	}

}
