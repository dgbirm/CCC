/*
 * Copyright (c) 2020 as part of CenteneCodingChallenge, All rights reserved.
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * Date generated: Oct 14, 2020
 * @version jdk-11
 */
package com.cognixia.jump.ccc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Enrollee. Models a customer enrolled in this 
 * health care program
 */
@Entity
public class Enrollee implements Serializable, Model {

	private static final long serialVersionUID = -6122561507322685450L;

	//Fields

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEnrollee", updatable = false, nullable = false)
	private Long id;
	
	/** The first name. */
	@Column(name = "firstName", updatable = false, nullable = false, length = 25)
	private String firstName;
	
	/** The last name. */
	@Column(name = "lastName", updatable = false, nullable = false, length = 25)
	private String lastName;
	
	@Column(name = "hashWord", updatable = true, nullable = false, length = 60)
	private String hashWord;
	
	/** The activation status. */
	@Column(name = "activationStatus", updatable = true, nullable = false, columnDefinition = "BOOLEAN")
	private Boolean activationStatus;
	
	/** The date of birth (dob). */
	@Column(name = "dob", updatable = false, nullable = false)
	private LocalDate dob;
	
	/** The phone number. */
	@Column(name = "phoneNumber", updatable = true, nullable = true, length = 15)
	private String phoneNumber;
	
	/** The dependents. */
	@OneToMany( mappedBy = "parent", targetEntity = Dependent.class,
			cascade = CascadeType.ALL, orphanRemoval = true )
	private Set<Dependent> dependents = new HashSet<>();
	
	//Constructors
	
	/**
	 * Instantiates a new enrollee.
	 *
	 * @param firstName   the first name
	 * @param lastName    the last name
	 * @param dob         the date of birth
	 * @param phoneNumber the phone number
	 */
	public Enrollee(String firstName, String lastName, LocalDate dob, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Instantiates a new enrollee.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param dob       the date of birth
	 */
	public Enrollee(String firstName, String lastName, LocalDate dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	/**
	 * Instantiates a new enrollee.
	 */
	public Enrollee() {}
	
	//Equals and hashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(dob, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollee other = (Enrollee) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
	}

	//Getters and Setters
	
	/**
	 * Gets the activation status.
	 *
	 * @return the activation status
	 */
	public synchronized Boolean getActivationStatus() {
		return activationStatus;
	}

	/**
	 * Sets the activation status.
	 *
	 * @param activationStatus the new activation status
	 */
	public synchronized void setActivationStatus(Boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the dob
	 */
	public synchronized LocalDate getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public synchronized void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public synchronized String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public synchronized void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the dependents.
	 *
	 * @return the dependents
	 */
	public synchronized Set<Dependent> getDependents() {
		return dependents;
	}

	/**
	 * Sets the dependents.
	 *
	 * @param dependents the new dependents
	 */
	public synchronized void setDependents(Set<Dependent> dependents) {
		this.dependents = dependents;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public synchronized Long getId() {
		return id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public synchronized String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public synchronized String getLastName() {
		return lastName;
	}

	/**
	 * Gets the hash word.
	 *
	 * @return the hash word
	 */
	public synchronized String getHashWord() {
		return hashWord;
	}

	/**
	 * Sets the hash word.
	 *
	 * @param hashWord the new hash word
	 */
	public synchronized void setHashWord(String hashWord) {
		this.hashWord = hashWord;
	}
	
	
}
