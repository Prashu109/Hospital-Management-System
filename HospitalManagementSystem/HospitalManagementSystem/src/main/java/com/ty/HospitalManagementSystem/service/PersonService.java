package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.PersonDao;
import com.ty.HospitalManagementSystem.dto.Person;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Person>> saveperson(Person person) {

		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.saveperson(person));
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Person>> updateperson(int id, Person person) {

		Person dbperson = personDao.updateperson(id, person);

		if (dbperson != null) {

			ResponseStructure<Person> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbperson);

			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Person>> deleteperson(int id) {

		Person person = personDao.deleteperson(id);
		if (person != null) {

			ResponseStructure<Person> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Person>> getpersonbyid(int id) {

		Person person = personDao.getpersonbyid(id);

		if (person != null) {

			ResponseStructure<Person> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfullly found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.FOUND);
		} else {
			return null;
		}
	}

}
