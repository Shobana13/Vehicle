package com.cg.vms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.entities.Address;
import com.cg.vms.exceptions.AddressNotFoundException;
import com.cg.vms.service.IAddressService;

@RestController
public class AddressController {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressController.class);

	@Autowired
	IAddressService addrService;

	// view all address
	@GetMapping("/address/{id}")
	public Address findAddressById(@PathVariable("id") int id) {
		logger.info("Getting the address  by id");
		if (addrService.findAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id" + id);
		}
		return addrService.findAddressById(id);
	}

	// delete address
	@DeleteMapping("/address/{id}")
	public Address deleteAddressById(@PathVariable("id") int id) {
		logger.info("Deleting address in the database by id");
		if (addrService.deleteAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id" + id);
		}
		return addrService.deleteAddressById(id);
	}

	// view address
	@GetMapping("/address")
	public List<Address> findAllAddresses() {
		logger.info("Getting all address details");
		return addrService.findAllAddresses();
	}

	// add address
	@PostMapping("/address")
	public Address save(@RequestBody Address address) {
		logger.info("Adding address in  the database");
		return addrService.save(address);
	}

	// update address
	@PutMapping("/address")
	public Address update(@RequestBody Address address) {
		logger.info("Updating address details");
		if (addrService.update(address) == null) {
			throw new AddressNotFoundException("AddressId Not Found:" + address.getAddressId());
		}
		return addrService.update(address);
	}

}
