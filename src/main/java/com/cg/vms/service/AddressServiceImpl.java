package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.entities.Address;
import com.cg.vms.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addrRepo;

	//find address by id
	@Override
	public Address findAddressById(int id) {
		Optional<Address> address = addrRepo.findById(id);
		if(!address.isPresent()) {
			return null;
		}
		return address.get();
	}

	//find all address
	@Override
	public List<Address> findAllAddresses() {
		return addrRepo.findAll();
	}

	//add address
	@Override
	public Address save(Address address) {
		return addrRepo.save(address);
	}

	//update address
	@Override
	public Address update(Address address) {
		Optional<Address> addr = addrRepo.findById(address.getAddressId());
		if(!addr.isPresent()) {
			return null;
		}
		addr.get().setAddressId(address.getAddressId());
		addr.get().setStreetName(address.getStreetName());
		addr.get().setCity(address.getCity());
		return addrRepo.save(addr.get());
	}

	//delete address by id
	@Override
	public Address deleteAddressById(int id) {
		Optional<Address> address = addrRepo.findById(id);
		if(!address.isPresent()) {
			return null;
		}
		addrRepo.delete(address.get());
		return address.get();
	}

}