package com.lab7.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name="courses")
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String title; 
	String authorName;
	@OneToMany(mappedBy = "module")
	private List<Module> modules;
}
