package com.cognixia.jump.ccc.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.ccc.dto.EnrolleeDTO;
import com.cognixia.jump.ccc.model.Enrollee;
import com.cognixia.jump.ccc.repository.EnrolleeRepo;

@RestController
@RequestMapping("/enrollee")
public class EnrolleeController {
	
	@Autowired
	private EnrolleeRepo enrolleeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private EnrolleeDTO convertToDTO(Enrollee enrollee) {
		EnrolleeDTO enrolleeDTO = modelMapper.map(enrollee, EnrolleeDTO.class);
		
	}
	
	private Enrollee convertToEntitiy(EnrolleeDTO enrolleeDTO) {
		
	}
	
}
