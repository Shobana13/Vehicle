
package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.vms.controller.BookingController;
import com.cg.vms.entities.Booking;
import com.cg.vms.entities.Customer;
import com.cg.vms.entities.Vehicle;

@SpringBootTest
class BookingTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BookingController.class);

	@Autowired
	IBookingService bokService;

	/**
	 * Test case for the method of adding new bookings in the booking table
	 */

	@Test
//	@Disabled
	void testShouldAddBooking() {
		LocalDate bd1 = LocalDate.of(2020, 01, 01);
		LocalDate bd2 = LocalDate.of(2021, 05, 26);
		Customer cust = new Customer(1, "tom", "son", "tom@gmail.com", "951771122");
		Booking b1 = new Booking(103, bd1, bd2, "Accept", 500.00, 1000.00);
		Vehicle vehicle = new Vehicle(1006, "TN4E32", "car", "non ac", "small", "Chennai", "4seater", 60.0, 50.0);
		b1.setVehicle(vehicle);
		b1.setCustomer(cust);
		Booking persistedBok = bokService.addBooking(b1);
		System.out.println(persistedBok);
		assertEquals(103, persistedBok.getBookingId());
		assertEquals(bd1, persistedBok.getBookingDate());
		assertEquals(bd2, persistedBok.getBookedTillDate());
		assertEquals("Accept", persistedBok.getBookingDescription());
		assertEquals(500.00, persistedBok.getTotalCost());
		assertEquals(1000.00, persistedBok.getDistance());
		logger.info(persistedBok);

	}

	/**
	 * Test case for the method of deleting a booking entity in the booking table
	 */
	@Test
	@Disabled
	void testShouldCancelBooking() {
		Booking bok = new Booking();
		bok.setBookingId(104);
		Booking bok1 = bokService.cancelBooking(104);
		assertEquals(104, bok1.getBookingId());
		logger.info(bok);

	}

	/**
	 * Test case for the method of updating booking date in the booking table
	 */
	@Test
//	@Disabled
	void testShouldUpdateBooking() {
		Booking bok = new Booking();
		bok.setBookingId(103);
		LocalDate bd1 = LocalDate.of(2020, 01, 01);
		bok.setBookingDate(bd1);
		Booking updatedBok = bokService.updateBookingDate(103, bok);
		System.out.println(updatedBok);
		logger.info(updatedBok);
		assertEquals(1000.00, updatedBok.getDistance());

	}

	/**
	 * Test case for the method of getting the booking details by booking id
	 */
	@Test
//	@Disabled
	void testShouldViewBookingById() {
		Booking bok = new Booking();
		bok.setBookingId(103);
		System.out.println(bok);
		Booking bok1 = bokService.viewBooking(bok);
		logger.info(bok1);
		assertEquals(1000.00, bok1.getDistance());

	}

	/**
	 * Test case for the method of getting the booking details through customer id
	 */
	@Test
//	@Disabled
	void testShouldGetAllBookingByCusomerId() {
		List<Booking> booking = bokService.viewAllBookingByCustomer(202);
		logger.info(booking);
		assertEquals(1, booking.size());

	}

	/**
	 * Test case for the method of getting the bookings in a particular date
	 */
	@Test
	@Disabled
	void testShouldGetAllBookingByBookingDate() {
		Booking bok = new Booking();
		LocalDate bd1 = LocalDate.of(2020, 01, 01);
		bok.setBookingDate(bd1);
		List<Booking> b1 = bokService.viewAllBookingByBookingDate(bd1);
		for (Booking b : b1) {
			System.out.println(b);
		}
		logger.info(b1);
		assertEquals(1, b1.size());
	}

	/**
	 * Test case for method of getting the booking details of a particular booking
	 * by Vehicle Id
	 */
	@Test
//	@Disabled
	void testShouldGetAllBookingByVehicleId() {
		List<Booking> b1 = bokService.viewAllBookingByVehicleId(1006);
		System.out.println(b1);
		logger.info(b1);
		assertEquals(2, b1.size());
	}
}

