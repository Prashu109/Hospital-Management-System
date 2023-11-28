package com.ty.HospitalManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.BranchDao;
import com.ty.HospitalManagementSystem.dao.EncounterDao;
import com.ty.HospitalManagementSystem.dao.PersonDao;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.dto.Encounter;
import com.ty.HospitalManagementSystem.dto.Person;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {

		Person person = personDao.getpersonbyid(pid);

		Branch branch = branchDao.getbranchbyid(bid);
		encounter.setPerson(person);
		List<Branch> list = new ArrayList<>();
		list.add(branch);
		encounter.setList(list);

		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("successfully created");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterDao.saveEncounter(encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, Encounter encounter, int bid) {

		Encounter dbencounter = encounterDao.getEncounterbyid(id);
		Branch branch = branchDao.getbranchbyid(bid);
		List<Branch> branchs = dbencounter.getList();
		encounter.setList(branchs);
		encounter.setPerson(dbencounter.getPerson());
		Encounter encounter2 = encounterDao.updateEncounter(bid, encounter);

		if (encounter2 != null) {

			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter2);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("id not found for given encounter");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		Encounter encounter = encounterDao.deleteEncounter(id);
		if (encounter != null) {

			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("id not found for given encounter");
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterbyid(int id) {

		Encounter encounter = encounterDao.getEncounterbyid(id);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.FOUND);

		} else {
			throw new IdNotFoundException("id not found for given encounter");
		}
	}

}
