package com.cg.vms.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class VehicleDto {
	
	// fields
	@Id
	private int vehicleId;
	private String vehicleNumber;
	private String type;// car//bus
	private String category; // ac or nonac
	private String description;
	private String location;
	private String capacity;
	private double chargesPerKM;
	private double fixedCharges;

	// constructors
	public VehicleDto(int vehicleId, String vehicleNumber, String type, String category, String description,
			String location, String capacity, double chargesPerKM, double fixedCharges) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
	}

}
