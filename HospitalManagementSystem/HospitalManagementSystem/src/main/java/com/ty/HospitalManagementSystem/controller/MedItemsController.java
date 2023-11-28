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

import com.ty.HospitalManagementSystem.dto.MedItems;
import com.ty.HospitalManagementSystem.service.MedItemService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@RestController
public class MedItemsController {

	@Autowired
	private MedItemService service;

	@PostMapping("/savemeditems")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestParam int mid,
			@RequestBody MedItems medItems) {

		return service.saveMedItems(mid, medItems);

	}

	@PutMapping("/updatemeditems")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestParam int id,
			@RequestBody MedItems medItems) {

		return service.updateMedItems(id, medItems);
	}

	@DeleteMapping("/deletemeditems")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(@RequestParam int id) {

		return service.deleteMedItems(id);
	}

	@GetMapping("/getmeditemsbyid")
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsbyid(@RequestParam int id) {
		return service.getMedItemsbyid(id);
	}
}
