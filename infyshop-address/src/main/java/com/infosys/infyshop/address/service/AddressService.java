package com.infosys.infyshop.address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;

import com.infosys.infyshop.address.dto.AddressDTO;
import com.infosys.infyshop.address.entity.Address;
import com.infosys.infyshop.address.repository.AddressRepository;

@Service
public class AddressService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AddressRepository addressRepository;
	//Add Address
	public ResponseEntity<Address> addAddress(String userId, AddressDTO addressDTO) {
		logger.info("Add address request of user {}", addressDTO);
		addressDTO.setEmail(userId);
		Address address = addressDTO.createEntity();
		return ResponseEntity.ok().body(addressRepository.save(address));
	}
	//View Address
	public List<AddressDTO> viewAddress(String userId, Integer addressId) {
		logger.info("View address request of user {}", userId);
		List<AddressDTO> addressDTOList = new ArrayList<>();
		List<Address> addressList= addressRepository.getByEmail(userId);
		for(Address address : addressList) {
			addressDTOList.add(AddressDTO.valueOf(address));
		}
		logger.info("View address of users {}", addressDTOList);
		return addressDTOList;
	}
	//Modify Address
	public ResponseEntity<Address> modifyAddress(String userId, Integer addressId, AddressDTO addressDTO) {
		logger.info("Modify address request of user {}", addressDTO);
		Optional<Address> optionalAddress = addressRepository.findById(addressId);
		Address address = null;
		Address updatedAddress = null;
		if(optionalAddress.isPresent()) {
			address = optionalAddress.get();
			address.setAddress(addressDTO.getAddress());
			address.setCity(addressDTO.getCity());
			address.setState(addressDTO.getState());
			address.setPinCode(addressDTO.getPinCode());
			address.setPhoneNumber(addressDTO.getPhoneNumber());
			updatedAddress = addressRepository.save(address);
		}
		return ResponseEntity.ok(updatedAddress);
	}
	//Delete Address
	public ResponseEntity<String> deleteAddress(String userId, Integer addressId) {
		logger.info("Delete address request of user {}", userId, addressId);
		addressRepository.deleteById(addressId);
		return ResponseEntity.ok("Deleted");
	}
}
