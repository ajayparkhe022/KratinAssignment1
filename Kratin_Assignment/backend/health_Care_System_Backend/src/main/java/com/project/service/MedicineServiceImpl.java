package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Medicine;
import com.project.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepository medRepo;
	

	@Override
	public Medicine addMedicine(Medicine medicine) {
		return medRepo.save(medicine);
	}

	@Override
	public void removeMedicine(String name) {
		Medicine med = medRepo.findOneByName(name);
		if(med != null) {
			medRepo.delete(med);
		}
	}

	@Override
	public List<Medicine> showAllMedicine() {
		return medRepo.findAll();
	}

	@Override
	public Medicine showMedicine(String name) {
		return medRepo.findOneByName(name);
	}

	@Override
	public Medicine updateMedicine(String name, Medicine med) {
	    Medicine oldMed = medRepo.findOneByName(name);
	    if (oldMed != null) {
	        oldMed.setName(med.getName());
	        oldMed.setQuantity(med.getQuantity());
	        oldMed.setTime(med.getTime());
	        return medRepo.save(oldMed);
	    }
	    return oldMed;
	}


}
