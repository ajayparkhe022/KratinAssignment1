package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.Medicine;
import com.project.service.MedicineService;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicineController {
	
//	private MedicationService medService;
	
	private final MedicineService medService;
	
	public MedicineController(MedicineService medService) {
		this.medService = medService;
	}	
	@GetMapping("/")
	public ResponseEntity<List<Medicine>> showAllMedication() {
	    List<Medicine> medicines = medService.showAllMedicine();
	    return new ResponseEntity<>(medicines, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Medicine> newMedicine(@RequestBody Medicine med)
	{
		return new ResponseEntity<Medicine>(medService.addMedicine(med),HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/showOne/{name}")
	public ResponseEntity<Medicine> displayMedication(@PathVariable String name)
	{
		return new ResponseEntity<Medicine>(medService.showMedicine(name),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{name}")
	public ResponseEntity<String> deleteMedication(@PathVariable String name)
	{
		System.out.println(name);
		medService.removeMedicine(name);
		return new ResponseEntity<String>("Medication Removed",HttpStatus.OK);
	}
	
	@PutMapping("/update/{name}")
	public ResponseEntity<Medicine> editMedeication(@PathVariable String name, @RequestBody Medicine med)
	{
		return new ResponseEntity<Medicine>(medService.updateMedicine(name, med),HttpStatus.OK);
		
	}
	
}
