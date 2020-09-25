package com.infosys.infyshop.address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infyshop.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<Address> getByEmail(String email);
	Address getByEmailAndAddressId(String email, Integer addressId);
}
