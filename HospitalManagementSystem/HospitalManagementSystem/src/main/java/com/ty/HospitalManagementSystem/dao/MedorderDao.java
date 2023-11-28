package com.ty.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Encounter;
import com.ty.HospitalManagementSystem.dto.Medorder;
import com.ty.HospitalManagementSystem.repo.MedorderRepo;

@Repository
public class MedorderDao {
	
	@Autowired
	private MedorderRepo medorderRepo;
	
	@Autowired
	private EncounterDao encounterDao;
	
	public Medorder savemedorder(Medorder medorder,int eid) {
		
		Encounter encounter = encounterDao.getEncounterbyid(eid);
		
		medorder.setEncounter(encounter);
		
		return medorderRepo.save(medorder);
	}
	
	public Medorder updatemedorder(int id,Medorder medorder) {
		
		if(medorderRepo.findById(id).isPresent()) {
			medorder.setId(id);
			return medorderRepo.save(medorder);
		}else {
			return null;
		}
	}
	
	public Medorder deletemedorder(int id) {
		
		if(medorderRepo.findById(id).isPresent()) {
			
		Medorder medorder =	medorderRepo.findById(id).get();
		 medorderRepo.deleteById(id);
		 return medorder;
		}else {
			return null;
		}
	}
	
	public Medorder getmedorderbyid(int id) {
		
		return medorderRepo.findById(id).get();
		
	}

}
