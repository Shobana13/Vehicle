package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.entities.Address;
@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

}