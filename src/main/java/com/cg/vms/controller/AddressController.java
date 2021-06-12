package com.cg.vms.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RestController
public class AddressController {
	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressController.class);

	/**
	 * We are autowiring the address service layer to this controller layer of address
	 * 
	 * @param addressServiceImpl
	 */
	@Autowired
	IAddressService addrService;

	/**
	 * This controller is used to get a specific customer on basis of ID
	 * 
	 * @param id
	 * @return
	 * @throws AddressNotFoundException
	 */
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> findAddressById(@PathVariable("id") int id) {
		logger.info("Getting the address  by id");
		if (addrService.findAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id" + id);
		}
		Address address= addrService.findAddressById(id);
		return ResponseEntity.ok().body(address);
	}

	/**
	 * This controller function perform deletion of a specific given address and
	 * request the service to perform the action and returns the message as deleted
	 * else throw exception
	 * 
	 * @param id
	 * @return
	 * @throws AddressNotFoundException
	 */
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteAddressById(@PathVariable("id") int id) {
		logger.info("Deleting address in the database by id");
		if (addrService.deleteAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with this id" + id);
		}
		return  ResponseEntity.ok().body(addrService.deleteAddressById(id));
	}

	/**
	 * This controller is used to return and list all the address found in the
	 * database and request to the service to perform the action
	 * 
	 * @return
	 */
	@GetMapping("/address")
	public ResponseEntity<List<Address>> findAllAddresses() {
		logger.info("Getting all address details");
		return ResponseEntity.ok(addrService.findAllAddresses());
	}

	/**
	 * This controller is used to create a new or add new address and redirects it
	 * to the service layer
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/address")
	public ResponseEntity<Address> save(@RequestBody Address address) {
		logger.info("Adding address in  the database");
		return ResponseEntity.ok().body(addrService.save(address));
	}


	/**
	 * This function is used to update a specific address on basis of given
	 * address id and returns exception if given address id is not found.
	 * 
	 * @param id
	 * @param address
	 * @return
	 * @throws AddressNotFoundException
	 */
	@PutMapping("/address/update/{id}")
	public ResponseEntity<Address> update(@PathVariable("id") int addressId,@RequestBody Address address) {
		logger.info("Updating address details");
		if (addrService.update(addressId,address) == null) {
			throw new AddressNotFoundException("AddressId Not Found:" + addressId);
		}
		return ResponseEntity.ok().body(addrService.update(addressId,address));
	}

}
