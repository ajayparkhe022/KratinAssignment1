package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	Medicine findOneByName(String name);

}
