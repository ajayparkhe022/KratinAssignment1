package com.project.service;

import java.util.List;

import com.project.model.Medicine;

public interface MedicineService {
	
	public Medicine addMedicine(Medicine medication);
	
	public void removeMedicine(String name);
	
	public List<Medicine> showAllMedicine();
	
	public Medicine showMedicine(String name);

	public Medicine updateMedicine(String name, Medicine med);
}
