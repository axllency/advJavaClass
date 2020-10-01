/**
 * 
 */
package com.hw1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author ajfre
 *
 */
@Data
@Entity(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private String illness;
	
	public Patient() {
		
	}
	
	public Patient(String name, String gender, String illness) {
		this.name = name;
		this.gender = gender;
		this.illness = illness;
	}

	
}
