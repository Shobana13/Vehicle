package com.cg.vms.service;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vms.entities.Address;
import com.cg.vms.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addrRepo;
	
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressServiceImpl.class);

	/**
	 * This function will retrieve the address on basis of given Id 
	 * 
	 * @return
	 */
	@Override
	public Address findAddressById(int id) {
		logger.info("Getting address by using id");
		Optional<Address> address = addrRepo.findById(id);
		if(!address.isPresent()) {
			return null;
		}
		return address.get();
	}

	/**
	 * Get the list of all the address
	 * 
	 * @return
	 */
	@Override
	public List<Address> findAllAddresses() {
		logger.info("Getting all the addresses");
		return addrRepo.findAll();
	}

	/**
	 * Used to store the address details passed from the controller
	 * 
	 * @return
	 */
	@Override
	public Address save(Address address) {
		logger.info("Adding address to the database");
		return addrRepo.save(address);
	}

	/**
	 * This function will update the address details
	 * 
	 * @return
	 */
	@Override
	public Address update(int addressId,Address address) {
		logger.info("Updating the address details");
		Optional<Address> addr = addrRepo.findById(addressId);
		if(!addr.isPresent()) {
			return null;
		}
		addr.get().setAddressId(address.getAddressId());
		addr.get().setStreetName(address.getStreetName());
		addr.get().setCity(address.getCity());
		return addrRepo.save(addr.get());
	}

	/**
	 * This function will delete the address on basis of given Id 
	 * 
	 * @return
	 */
	@Override
	public Address deleteAddressById(int id) {
		logger.info("Delete the address by Id");
		Optional<Address> address = addrRepo.findById(id);
		if(!address.isPresent()) {
			return null;
		}
		addrRepo.delete(address.get());
		return address.get();
	}

}