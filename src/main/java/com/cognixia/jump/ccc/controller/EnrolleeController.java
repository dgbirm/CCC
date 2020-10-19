package com.cognixia.jump.ccc.controller;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cognixia.jump.ccc.dto.EnrolleeDTO;
import com.cognixia.jump.ccc.model.Enrollee;
import com.cognixia.jump.ccc.repository.EnrolleeRepo;
import com.cognixia.jump.ccc.service.EnrolleeService;

@RestController
public class EnrolleeController {

	@Autowired
	private EnrolleeRepo enrolleeRepo;
	
	@Autowired
	private EnrolleeService enrolleeService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping(path = "/enrollee/{id}")
	@ResponseBody
	public EnrolleeDTO getEnrollee(@PathVariable("id") Long id) {
		return convertToDTO(enrolleeRepo.getOne(id));
	}

	@PostMapping(path = "/registerEnrollee")
	public ResponseEntity<?> registerEnrollee(@RequestBody @Validated EnrolleeDTO enrolleeDTO) {
		// LOGGER.debug("Registering user account with information: {}", userDto);
		System.out.println("making post mapping");
		URI location;
		try {
			Enrollee newEnrollee = convertToEntitiy(enrolleeDTO);
			enrolleeService.addEnrollee(newEnrollee);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/enrollee/{id}").buildAndExpand(newEnrollee.getId()).toUri();
		} catch (RuntimeException e) {
			// LOGGER.warn("Unable to register user", ex);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/error").build().toUri();
		}
		return ResponseEntity.created(location).build();
	}

///////////////////////////////////////
// DTO <--> Entity Conversions
///////////////////////////////////////
	private EnrolleeDTO convertToDTO(Enrollee enrollee) {
		EnrolleeDTO enrolleeDTO = modelMapper.map(enrollee, EnrolleeDTO.class);
		return enrolleeDTO;
	}

	private Enrollee convertToEntitiy(EnrolleeDTO enrolleeDTO) {
		Enrollee enrollee = modelMapper.map(enrolleeRepo, Enrollee.class);
		try {
			enrollee.setHashWord(bCryptPasswordEncoder.encode(enrolleeDTO.getPassword().get()));
		} catch (Exception e) {
			e.getMessage();
		}
		return enrollee;
	}

}
