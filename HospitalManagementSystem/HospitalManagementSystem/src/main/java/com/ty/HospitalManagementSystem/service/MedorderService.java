package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.MedorderDao;
import com.ty.HospitalManagementSystem.dto.Medorder;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class MedorderService {

	@Autowired
	private MedorderDao medorderDao;

	public ResponseEntity<ResponseStructure<Medorder>> savemedorder(int eid, Medorder medorder) {

		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medorderDao.savemedorder(medorder, eid));
		return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Medorder>> updatemedorder(int id, Medorder medorder) {

		Medorder dbmedorder = medorderDao.getmedorderbyid(id);
		medorder.setEncounter(dbmedorder.getEncounter());
		Medorder daoMedorder = medorderDao.updatemedorder(id, dbmedorder);
		if (daoMedorder != null) {

			ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoMedorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
//		Medorder dbmedorder = medorderDao.updatemedorder(id, medorder);
//		
//		if(dbmedorder!=null) {
//			return dbmedorder;
//		}else {
//			return null;
//		}

	}

	public ResponseEntity<ResponseStructure<Medorder>> deletemedorder(int id) {

		Medorder medorder = medorderDao.deletemedorder(id);
		if (medorder != null) {
			ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);
		} else {
			return null;

		}
	}

	public ResponseEntity<ResponseStructure<Medorder>> getmedorderbyid(int id) {

		Medorder medorder = medorderDao.getmedorderbyid(id);
		if (medorder != null) {

			ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

}
