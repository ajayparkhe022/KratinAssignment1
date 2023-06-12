package com.project.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sr_No;

	private String name;
	
	private int quantity;
	
	private LocalTime time;
}
