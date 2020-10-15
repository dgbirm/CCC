package com.cognixia.jump.ccc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.ccc.repository.EnrolleeRepo;

@Service
public class EnrolleeService {

	@Autowired
	private EnrolleeRepo enrolleeRepo;
	
	//Constructor
	public EnrolleeService(EnrolleeRepo enrolleeRepo) {
		this.enrolleeRepo = enrolleeRepo;
	}
	
//	//Add
//	public boolean addEnrollee(String firstName, String lastName, ,)
//
//
}
