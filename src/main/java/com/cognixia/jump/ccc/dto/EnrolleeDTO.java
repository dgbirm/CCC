package com.cognixia.jump.ccc.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import com.cognixia.jump.ccc.model.Dependent;

public class EnrolleeDTO implements DTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Boolean activationStatus;
	private LocalDate dob;
	private String phoneNumber;
	private Set<Dependent> dependents = new HashSet<>();
	
	//Getters and Setters

}
