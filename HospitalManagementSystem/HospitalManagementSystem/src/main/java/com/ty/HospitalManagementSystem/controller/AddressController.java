package com.ty.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Address;
import com.ty.HospitalManagementSystem.service.AddressService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;

	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>> saveaddress(@RequestBody Address address) {

		return service.saveaddress(address);

	}

	@PutMapping("/updateaddress")
	public ResponseEntity<ResponseStructure<Address>> updateaddress(@RequestParam int id,
			@RequestBody Address address) {

		return service.updateaddress(id, address);

	}

	@DeleteMapping("/deleteaddress")
	public ResponseEntity<ResponseStructure<Address>> deleteaddress(@RequestParam int id) {

		return service.deleteaddress(id);
	}

	@GetMapping("/getaddressbyid")
	public ResponseEntity<ResponseStructure<Address>> getaddressbyid(@RequestParam int id) {

		return service.getaddressbyid(id);

	}

}
