package com.cg.vms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.vms.entities.Booking;
import com.cg.vms.repository.IBookingRepository;
import com.cg.vms.service.BookingServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void testCreateBooking() {
		Booking booking = new Booking(101, LocalDate.of(2020, 10, 10), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Mockito.when(bokRep.save(booking)).thenReturn(booking);
		Booking persistedbok = bokService.save(booking);
		assertEquals(101, persistedbok.getBookingId());
	}

	@Test
	void testViewAllBooking() {
		Booking booking1 = new Booking(101, LocalDate.of(2020, 10, 10), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Booking booking2 = new Booking(102, LocalDate.of(2021, 10, 11), LocalDate.of(2020, 10, 12), "Good", 200.00,
				2000.00);
		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking1);
		bookingList.add(booking2);
		Mockito.when(bokRep.findAll()).thenReturn(bookingList);
		List<Booking> booking = bokService.viewAllBookingByDate(LocalDate.of(2021, 10, 11));
		assertEquals(0, booking.size());

	}

	@Test
	void testUpdateBooking() {
		Booking booking = new Booking(101, LocalDate.of(2020, 10, 12), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Mockito.when(bokRep.findById(1)).thenReturn(Optional.of(booking));
		Mockito.when(bokRep.save(booking)).thenReturn(booking);
		Booking persistedBok = bokService.updateBookingDate(1, booking);
		assertEquals(101, persistedBok.getBookingId());
		assertEquals(LocalDate.of(2020, 10, 12), persistedBok.getBookingDate());

	}

	@Test
	void testcancelBooking() {

		Booking booking = new Booking(101, LocalDate.of(2020, 10, 12), LocalDate.of(2020, 10, 11), "Good", 100.00,
				1000.00);
		Mockito.when(bokRep.findById(101)).thenReturn(Optional.of(booking));
		bokRep.deleteById(101);
		Booking persistedBok = bokService.cancelBooking(booking);
		assertEquals(LocalDate.of(2020, 10, 12), persistedBok.getBookingDate());

	}

}
