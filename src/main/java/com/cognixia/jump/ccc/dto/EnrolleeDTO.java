package com.cognixia.jump.ccc.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.cognixia.jump.ccc.model.Dependent;

public class EnrolleeDTO implements DTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Boolean activationStatus;
	private LocalDate dob;
	private String phoneNumber;
	private Set<Dependent> dependents = new HashSet<>();
	private Optional<String> password;
	
	//Getters and Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Boolean getActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(Boolean activationStatus) {
		this.activationStatus = activationStatus;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(Set<Dependent> dependents) {
		this.dependents = dependents;
	}
	public Optional<String> getPassword() {
		return password;
	}
	public void setPassword(Optional<String> password) {
		this.password = password;
	}
	


}
