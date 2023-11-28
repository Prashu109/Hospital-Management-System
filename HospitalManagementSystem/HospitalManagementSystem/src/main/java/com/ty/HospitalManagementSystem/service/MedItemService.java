package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.MedItemDao;
import com.ty.HospitalManagementSystem.dto.MedItems;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class MedItemService {

	@Autowired
	private MedItemDao medItemDao;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(int mid, MedItems medItems) {

		ResponseStructure<MedItems> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medItemDao.saveMedItems(medItems, mid));
		return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(int id, MedItems medItems) {

		MedItems medItems2 = medItemDao.getMedItemsbyid(id);
		medItems.setMedorder(medItems2.getMedorder());
		MedItems daoMedItems = medItemDao.updateMedItems(id, medItems);
		if (daoMedItems != null) {

			ResponseStructure<MedItems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoMedItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int id) {

		MedItems medItems = medItemDao.deleteMedItems(id);
		if (medItems != null) {

			ResponseStructure<MedItems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsbyid(int id) {

		MedItems medItems = medItemDao.getMedItemsbyid(id);
		if (medItems != null) {
			ResponseStructure<MedItems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

}
