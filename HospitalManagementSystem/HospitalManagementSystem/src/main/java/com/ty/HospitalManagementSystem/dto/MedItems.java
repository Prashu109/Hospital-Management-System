package com.ty.HospitalManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MedItems {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private double cost;
	
	@ManyToOne
	private Medorder medorder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Medorder getMedorder() {
		return medorder;
	}

	public void setMedorder(Medorder medorder) {
		this.medorder = medorder;
	}

	@Override
	public String toString() {
		return "MedItems [id=" + id + ", name=" + name + ", cost=" + cost + ", medorder=" + medorder + "]";
	}
	
	

}
