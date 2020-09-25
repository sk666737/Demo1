package com.infosys.infyshop.address.dto;

import com.infosys.infyshop.address.entity.Address;

public class AddressDTO {

	Integer addressId;
	String email;
	String address;
	String city;
	String state;
	Integer pinCode;
	Long phoneNumber;
	
	public AddressDTO() {
		super();
	}
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", pinCode=" + pinCode + ", phoneNumber=" + phoneNumber + "]";
	}
	
	public static AddressDTO valueOf(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressId(address.getAddressId());
		addressDTO.setEmail(address.getEmail());
		addressDTO.setAddress(address.getAddress());
		addressDTO.setCity(address.getCity());
		addressDTO.setState(address.getState());
		addressDTO.setPinCode(address.getPinCode());
		addressDTO.setPhoneNumber(address.getPhoneNumber());
		return addressDTO;
	}
	
	public Address createEntity() {
		Address address = new Address();
		address.setAddressId(this.getAddressId());
		address.setEmail(this.getEmail());
		address.setAddress(this.getAddress());
		address.setCity(this.getCity());
		address.setState(this.getState());
		address.setPinCode(this.getPinCode());
		address.setPhoneNumber(this.getPhoneNumber());
		return address;
	}	
}
