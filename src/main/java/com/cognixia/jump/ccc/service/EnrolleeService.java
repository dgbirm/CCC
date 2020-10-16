package com.cognixia.jump.ccc.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cognixia.jump.ccc.model.Dependent;
import com.cognixia.jump.ccc.model.Enrollee;
import com.cognixia.jump.ccc.repository.DependentRepo;
import com.cognixia.jump.ccc.repository.EnrolleeRepo;

@Service
public class EnrolleeService {

	@Autowired
	private EnrolleeRepo enrolleeRepo;
	
	@Autowired
	private DependentRepo dependentRepo;
	
	//Constructor
	public EnrolleeService(EnrolleeRepo enrolleeRepo) {
		this.enrolleeRepo = enrolleeRepo;
	}
	
///////////////////////////////////////
// Create
///////////////////////////////////////
	
	//Add an Enrollee
	public void addEnrollee(String firstName, String lastName, 
			LocalDate dob, String phoneNumber) {
		Enrollee newEnrollee = new Enrollee(firstName,lastName,dob,phoneNumber);
		enrolleeRepo.save(newEnrollee);
	}
	
	public void addEnrollee(String firstName, String lastName, 
			LocalDate dob) {
		Enrollee newEnrollee = new Enrollee(firstName,lastName,dob);
		enrolleeRepo.save(newEnrollee);
	}
	
	public void addEnrollee(Enrollee enrollee) {
		enrolleeRepo.save(enrollee);
	}
	
	//Add dependent to Enrollee
	public void addDependent(Enrollee enrollee, Dependent newDependent) {
		Optional<Enrollee> findEnrollee = enrolleeRepo.findById(enrollee.getId());
		Optional<Dependent> findDependent = dependentRepo.findById(newDependent.getId());
		
		if (findEnrollee.isPresent() && findDependent.isPresent()) {
			Enrollee enrolleeToUpdate = findEnrollee.get();
			Dependent dependentToUpdate = findDependent.get();
			
			enrolleeToUpdate.getDependents().add(dependentToUpdate);
			enrolleeRepo.save(enrolleeToUpdate);
		}
		else {
			throw new IllegalArgumentException(
					"Either the Enrollee or the Dependent given"
					+ "was not found in the databse");
		}
	}
	
///////////////////////////////////////
//Read
///////////////////////////////////////
	
	public Iterable<Enrollee> getPagedEnrollees(int page, int size, String sorDir, String sort) {
		PageRequest pRq = PageRequest.of(page, size, Sort.Direction.fromString(sorDir), sort);
		Page<Enrollee> enrollees = enrolleeRepo.
	}

///////////////////////////////////////
// Update
///////////////////////////////////////
	
	//Modify (update) an Enrollee
	public void updateEnrollee(Enrollee enrollee) {
		Optional<Enrollee> findEnrollee = enrolleeRepo.findById(enrollee.getId());
		
		if (findEnrollee.isPresent()) {
			Enrollee enrolleeToUpdate = findEnrollee.get();
			
			enrolleeToUpdate.setActivationStatus(enrollee.getActivationStatus());
			enrolleeToUpdate.setDependents(enrollee.getDependents());
			enrolleeToUpdate.setPhoneNumber(enrollee.getPhoneNumber());
			
			if (enrolleeToUpdate.equals(enrollee)) {
				enrolleeRepo.save(enrolleeToUpdate);
			}
			else {
				throw new IllegalArgumentException(String.format(
						"BAD DATA in method updateEnrollee: One of the following "
						+ "attributes for argument 'enrollee' does not match "
						+ "enrollee found in the system with the same id %d: %n"
						+ "  first name %n"
						+ "  last name %n"
						+ "  date of birth", enrolleeToUpdate.getId()));
			}
		}
		else {
			throw new IllegalArgumentException("No Such Enrollee Exits");
		}
	}
	
	// Update activation status
	public void updateActivationStatus(Long id, Boolean newActivationStatus) {
		Optional<Enrollee> findEnrollee = enrolleeRepo.findById(id);
		
		if (findEnrollee.isPresent()) {
			Enrollee enrolleeToUpdate = findEnrollee.get();
			enrolleeToUpdate.setActivationStatus(newActivationStatus);
			enrolleeRepo.save(enrolleeToUpdate);
		}
		else {
			throw new IllegalArgumentException(
					String.format("No enrollee found with id %d", id));
		}
	}
	
	// Update phone number
	public void updatePhoneNumber(Long id, String newPhoneNumber) {
		Optional<Enrollee> findEnrollee = enrolleeRepo.findById(id);
		
		if (findEnrollee.isPresent()) {
			Enrollee enrolleeToUpdate = findEnrollee.get();
			enrolleeToUpdate.setPhoneNumber(newPhoneNumber);
			enrolleeRepo.save(enrolleeToUpdate);
		}
		else {
			throw new IllegalArgumentException(
					String.format("No enrollee found with id %d", id));
		}
	}

///////////////////////////////////////
// Delete
///////////////////////////////////////

	//Delete an Enrollee
	public void deleteEnrollee(Long id) {
		enrolleeRepo.deleteById(id);
	}
	
	public void deleteEnrollee(Enrollee enrollee) {
		enrolleeRepo.delete(enrollee);
	}
	
	//Delete dependent from Enrollee
	//Note: by setting the orphanRemoval attribute to true in the OneToMany
	//annotation in the Enrollee entity definition, we ensure that removal
	//of the depedent from the dependents set in enrollee directly leads to
	//the deletion of the dependent itself, which is what we want.
	public void deleteDependent(Enrollee enrollee, Dependent oldDependent) {
		Optional<Enrollee> findEnrollee = enrolleeRepo.findById(enrollee.getId());
		Optional<Dependent> findDependent = dependentRepo.findById(oldDependent.getId());
		
		if (findEnrollee.isPresent() && findDependent.isPresent()) {
			Enrollee enrolleeToUpdate = findEnrollee.get();
			Dependent dependentToUpdate = findDependent.get();
			
			enrolleeToUpdate.getDependents().remove(dependentToUpdate);
			enrolleeRepo.save(enrolleeToUpdate);
		}
		else {
			throw new IllegalArgumentException(
					"Either the Enrollee or the Dependent given"
					+ "was not found in the databse");
		}
	}
	
	
}
