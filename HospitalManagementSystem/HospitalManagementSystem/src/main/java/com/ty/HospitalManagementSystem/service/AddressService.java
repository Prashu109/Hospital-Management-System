package com.ty.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.AddressDao;
import com.ty.HospitalManagementSystem.dto.Address;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> saveaddress(Address address) {

		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveaddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateaddress(int id, Address address) {

		Address dbaddress = addressDao.updateaddress(id, address);
		if (dbaddress != null) {

			ResponseStructure<Address> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbaddress);

			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for given address");
		}

	}

	public ResponseEntity<ResponseStructure<Address>> deleteaddress(int id) {

		Address address = addressDao.deleteaddress(id);
		if (address != null) {

			ResponseStructure<Address> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id is not found for given Address");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> getaddressbyid(int id) {

		Address address = addressDao.getaddressbyid(id);
		if (address != null) {

			ResponseStructure<Address> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);

		} else {
			throw new IdNotFoundException("id not found for given address");
		}
	}

}
