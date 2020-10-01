package com.hw1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hw1.models.Patient;
import com.hw1.services.PatientService;

@RestController
public class PatientController {
	@Autowired
	PatientService patientService = new PatientService();
	
	//create
	@PostMapping(path = "api/v1/patients")
	public Patient createPatient(@RequestBody Patient s) {
		return patientService.createPatient(s);
	}
	
	//read
	@GetMapping(path= "api/v1/patients")
	public List<Patient> getAllPatients() {
		return patientService.findAllPatients();
	}
	
	//read 2
	@GetMapping(path = "api/v1/patients/{illness}")
	public List<Patient> getPatientByIllness(@PathVariable("illness") String illness) {
		return patientService.getPatientByIllness(illness);
	}
	
	//update
	@PutMapping(path = "api/v1/patients/{patientId}")
	public void updatePatient(@PathVariable("patientId") Integer patientId, @RequestBody Patient s) {
		patientService.updatePatient(patientId, s);
	}
	
	//delete
	@DeleteMapping(path = "api/v1/patients/{patientId}")
	public void deletePatient(@PathVariable("patientId") Integer patientId) {
		patientService.deletePatient(patientId);
	}
}
