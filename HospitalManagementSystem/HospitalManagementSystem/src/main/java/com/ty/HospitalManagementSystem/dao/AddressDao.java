package com.ty.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Address;
import com.ty.HospitalManagementSystem.repo.AddressRepo;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepo addressRepo;
	
	public Address saveaddress(Address address) {
		
		return addressRepo.save(address);
	}
	
	public Address updateaddress(int id, Address address) {
		
		if(addressRepo.findById(id).isPresent()) {
		
			address.setId(id);
			
			return addressRepo.save(address);
		}else {
			return null;
		}
	}
	public Address deleteaddress(int id) {
		
		if(addressRepo.findById(id).isPresent()) {
			
			Address address = addressRepo.findById(id).get();
			
			addressRepo.deleteById(id);
			return address;
		}else {
			return null;
		}
	}
	
	public Address getaddressbyid(int id) {
		
		if(addressRepo.findById(id).isPresent()) {
			
		 return	addressRepo.findById(id).get();
		}else {
			return null;
		}
	}

}
