package com.cg.vms.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Booking {

	@Id
	private int bookingId;
	private LocalDate bookingDate;
	private LocalDate bookedTillDate;
	private String bookingDescription;
	private double totalCost;
	private double distance;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicleId")
	private Vehicle vehicle;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	//Constructor
	public Booking() {
	}

	
	public Booking(int bookingId, LocalDate bookingDate, LocalDate bookedTillDate, String bookingDescription,
			double totalCost, double distance) {
		this.bookingId = bookingId;
		this.bookingDate =bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.totalCost = totalCost;
		this.distance = distance;

	}

	// Getters and Setters
	@JsonManagedReference
	public Vehicle getVehicle() {
		return vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}

	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setCustomer(Customer cust) {
		this.customer = cust;

	}

	public void setVehicle(Vehicle vehicle2) {
		this.vehicle = vehicle2;

	}
	
	//toString
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookedTillDate=" + bookedTillDate
				+ ", bookingDescription=" + bookingDescription + ", totalCost=" + totalCost + ", distance=" + distance
				+ "]";
	}


}
