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

import com.ty.HospitalManagementSystem.dto.Medorder;
import com.ty.HospitalManagementSystem.service.MedorderService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@RestController
public class MedorderController {

	@Autowired
	private MedorderService service;

	@PostMapping("/savemedorder")
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(@RequestParam int eid,
			@RequestBody Medorder medorder) {

		return service.savemedorder(eid, medorder);
	}

	@PutMapping("/updatemedorder")
	public ResponseEntity<ResponseStructure<Medorder>> updatemedorder(@RequestParam int id,
			@RequestBody Medorder medorder) {

		return service.updatemedorder(id, medorder);
	}

	@DeleteMapping("/deletemedorder")
	public ResponseEntity<ResponseStructure<Medorder>> deletemedorder(@RequestParam int id) {

		return service.deletemedorder(id);

	}

	@GetMapping("/getmedorderbyid")
	public ResponseEntity<ResponseStructure<Medorder>> getmedorderbyid(@RequestParam int id) {

		return service.getmedorderbyid(id);

	}

}
