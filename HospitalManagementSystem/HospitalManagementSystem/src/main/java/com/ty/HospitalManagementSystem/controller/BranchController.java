package com.ty.HospitalManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.service.BranchService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService service;

	@ApiOperation(value = "save branch", notes = "Api is used to save branch")
	@ApiResponses(value = {@ApiResponse(code=201,message = "successfully saved")})
	@PostMapping("/savebranch")
	public ResponseEntity<ResponseStructure<Branch>> savebranch(@Valid @RequestParam int hid, @RequestParam int aid,
			@RequestBody Branch branch) {

		return service.savebranch(hid, aid, branch);
	}

	@PutMapping("/updatebranch")
	public ResponseEntity<ResponseStructure<Branch>> updatebranch(@Valid @RequestParam int id, @RequestBody Branch branch) {

		return service.updatebranch(id, branch);

	}

	@DeleteMapping("/deletebranch")
	public ResponseEntity<ResponseStructure<Branch>> deletebranch(@Valid @RequestParam int id) {

		return service.deletebranch(id);
	}

	@GetMapping("/getbranchbyid")
	public ResponseEntity<ResponseStructure<Branch>> getbranchbyid(@Valid @RequestParam int id) {

		return service.getbranchbyid(id);

	}

	@GetMapping("/getbranchbyhospitalid")
	public ResponseEntity<ResponseStructure<List<Branch>>> getbranchbyhospitalid(@Valid @RequestParam int hid) {

		return service.getbranchbyhospitalid(hid);
	}

}
