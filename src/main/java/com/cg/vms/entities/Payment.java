package com.cg.vms.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
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
	/**
	 * Creating Instance variables for Payment class
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id	
	private int paymentId;
	@NotEmpty
	@Size(min= 4, message = "payment options are either online payment, card payment or cash on delivery")
	private String paymentMode;
	@NotNull
	@DateTimeFormat	
	private LocalDate paymentDate;
	@NotEmpty
	@Size(min=7, message = "success or pending")
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
