package com.ty.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.MedItems;
import com.ty.HospitalManagementSystem.dto.Medorder;
import com.ty.HospitalManagementSystem.repo.MedItemRepo;

@Repository
public class MedItemDao {

	@Autowired
	private MedItemRepo repo;

	@Autowired
	private MedorderDao medorderDao;

	public MedItems saveMedItems(MedItems medItems, int mid) {

		Medorder medorder = medorderDao.getmedorderbyid(mid);
		medItems.setMedorder(medorder);

		return repo.save(medItems);
	}

	public MedItems updateMedItems(int id, MedItems medItems) {

		if (repo.findById(id).isPresent()) {

			medItems.setId(id);
			return repo.save(medItems);
		} else {
			return null;
		}
	}

	public MedItems deleteMedItems(int id) {

		if (repo.findById(id).isPresent()) {
			MedItems medItems = repo.findById(id).get();

			repo.deleteById(id);

			return medItems;
		} else {
			return null;
		}
	}

	public MedItems getMedItemsbyid(int id) {

		return repo.findById(id).get();
	}
}
