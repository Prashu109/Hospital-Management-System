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

import com.ty.HospitalManagementSystem.dto.Person;
import com.ty.HospitalManagementSystem.service.PersonService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping("/saveperson")
	public ResponseEntity<ResponseStructure<Person>> saveperson(@RequestBody Person person) {

		return service.saveperson(person);
	}

	@PutMapping("/updateperson")
	public ResponseEntity<ResponseStructure<Person>> updateperson(@RequestParam int id, @RequestBody Person person) {

		return service.updateperson(id, person);

	}

	@DeleteMapping("/deleteperson")
	public ResponseEntity<ResponseStructure<Person>> deleteperson(@RequestParam int id) {

		return service.deleteperson(id);
	}

	@GetMapping("/getpersonbyid")
	public ResponseEntity<ResponseStructure<Person>> getpersonbyid(@RequestParam int id) {

		return service.getpersonbyid(id);

	}

}
