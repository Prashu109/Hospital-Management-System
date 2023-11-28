package com.ty.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.BranchDao;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Branch>> savebranch(int hid, int aid, Branch branch) {

		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(hid, aid, branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updatebranch(int id, Branch branch) {

		Branch dbbranch = branchDao.updateBranch(id, branch);

		if (dbbranch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbbranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("id not found for given branch");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deletebranch(int id) {
		Branch branch = branchDao.deleteBranch(id);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("id not found for given branch");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getbranchbyid(int id) {

		Branch branch = branchDao.getbranchbyid(id);

		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);

			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id not found for given branch");
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getbranchbyhospitalid(int id) {

		List<Branch> branchs = branchDao.getbranchbyhospitalid(id);

		if (branchs != null) {
			ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branchs);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("id not found for given branch");
		}
	}

}
