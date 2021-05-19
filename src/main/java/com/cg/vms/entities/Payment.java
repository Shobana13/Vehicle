package com.cg.vms.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Payment {
	@Id
	private int paymentId;
	private String paymentMode;
	private LocalDate paymentDate;
	private String paymentStatus;

	// mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private Booking booking;

	// constructors
	public Payment(Booking booking) {
		this.booking = booking;
	}

	public Payment(int paymentId, String paymentMode, LocalDate paymentDate, String paymentStatus) {
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}
}
