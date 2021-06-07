package com.cg.vms.service;

import java.util.List;

import com.cg.vms.entities.Address;

public interface IAddressService {
	/**
	 * Method to be override by the implementing class
	 */
	Address findAddressById(int id);

	/**
	 * Method to be override by the implementing class
	 */
	List<Address> findAllAddresses();

	/**
	 * Method to be override by the implementing class
	 */
	Address save(Address address);

	/**
	 * Method to be override by the implementing class
	 */
	Address update(int addressId,Address address);

	/**
	 * Method to be override by the implementing class
	 */
	Address deleteAddressById(int id);
}


