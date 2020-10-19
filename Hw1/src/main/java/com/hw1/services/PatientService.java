package com.hw1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw1.models.Patient;
import com.hw1.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	//create
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	//read
	public List<Patient> findAllPatients() {
		return (List<Patient>) patientRepository.findAll();
	}
	
	//update
	public void updatePatient(Integer id, Patient s) {
		
		Optional<Patient> optPatient = patientRepository.findById(id);
		if(optPatient.get()!=null) {
			s.setId(optPatient.get().getId());
			patientRepository.save(s);
		}
	}
	
	//delete
	public void deletePatient(Integer id) {
		patientRepository.deleteById(id);
	}
	
	public List<Patient> getPatientByIllness(String illness) {
		List<Patient> list = patientRepository.findAll();
		List<Patient> returnable = new ArrayList<Patient>();
		if(!list.isEmpty()) {
			for(Patient x : list) {
				if((x.getIllness().toLowerCase()).equals(illness.toLowerCase())) {
					returnable.add(x);
					System.out.println(x);
				}
			}
		}
		System.out.println(returnable);
		return returnable;

	}

}
