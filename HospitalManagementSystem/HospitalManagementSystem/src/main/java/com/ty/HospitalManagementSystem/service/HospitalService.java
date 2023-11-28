package com.ty.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.HospitalDao;
import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> savehospital(Hospital hospital) {

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.savehospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Hospital>> updatehospital(int id, Hospital hospital) {

		Hospital dbhospital = dao.updatehospital(id, hospital);
		if (dbhospital != null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbhospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for the given hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {

		Hospital hospital = dao.deletehospital(id);

		if (hospital != null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException(" given id is not found for given hospital id");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> gethospitalbyid(int id) {

		Hospital hospital = dao.gethospitalbyid(id);

		if (hospital != null) {

			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("given id is not found");

		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> gethospitalbyemail(String email) {

		Hospital hospital = dao.gethospitalbyemail(email);

		if (hospital != null) {

			ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("given mail is not found");
		}

	}

	public List<Hospital> getallhospital() {

		return dao.getallhospital();
	}

}
