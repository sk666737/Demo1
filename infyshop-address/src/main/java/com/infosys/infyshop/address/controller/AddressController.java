package com.infosys.infyshop.address.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infyshop.address.dto.AddressDTO;
import com.infosys.infyshop.address.entity.Address;
import com.infosys.infyshop.address.service.AddressService;

@RestController
@CrossOrigin
public class AddressController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AddressService addressService;
	
	@PostMapping(value="/{userId}/address/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> addAddress(@PathVariable String userId, @RequestBody AddressDTO addressDTO) {
		logger.info("Add address request of user {}", addressDTO);
		return addressService.addAddress(userId, addressDTO);
	}
	@GetMapping(value="/{userId}/address/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AddressDTO> viewAddress(@PathVariable String userId, @PathVariable Integer addressId) {
		logger.info("View address request of user {}", userId);
		return addressService.viewAddress(userId, addressId);
	}
	@PutMapping(value="/{userId}/address/{addressId}/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> modifyAddress(@PathVariable String userId, @PathVariable Integer addressId, @RequestBody AddressDTO addressDTO) {
		logger.info("Modify address request of user {}", addressDTO);
		return addressService.modifyAddress(userId, addressId, addressDTO);
	}
	@DeleteMapping(value="/{userId}/address/{addressId}/delete")
	public ResponseEntity<String> deleteAddress(@PathVariable String userId, @PathVariable Integer addressId) {
		logger.info("Delete address request of user {}", userId, addressId);
		return addressService.deleteAddress(userId, addressId);
	}
}
