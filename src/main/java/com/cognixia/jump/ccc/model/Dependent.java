/*
 * Copyright (c) 2020 as part of CenteneCodingChallenge, All rights reserved.
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * Date generated: Oct 14, 2020
 * @version jdk-11
 */
package com.cognixia.jump.ccc.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class Dependent. Models a dependent of an enrollee
 */
@Entity
public class Dependent implements Serializable, Model {	
	private static final long serialVersionUID = -8939557402075743232L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDependent", updatable = false, nullable = false)
	private Long id;
	
	/** The first name. */
	@Column(name = "firstName", updatable = false, nullable = false, length = 25)
	private String firstName;
	
	/** The last name. */
	@Column(name = "lastName", updatable = false, nullable = false, length = 25)
	private String lastName;
	
	/** The date of birth. */
	@Column(name = "dob", updatable = false, nullable = false)
	private LocalDate dob;
	
	/** The parent. */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="independent", nullable=false, updatable=false)
	private Enrollee parent;
	
	//Constructors
	
	/**
	 * Instantiates a new dependent.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param dob       the date of birth
	 * @param parent    the parent
	 */
	public Dependent(String firstName, String lastName, LocalDate dob, Enrollee parent) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.parent = parent;
	}

	/**
	 * Instantiates a new dependent.
	 */
	public Dependent() {}

	//Getters and Setters
	
	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public synchronized Enrollee getParent() {
		return parent;
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
	 * Gets the date of birth.
	 *
	 * @return the dob
	 */
	public synchronized LocalDate getDob() {
		return dob;
	}
	
}
