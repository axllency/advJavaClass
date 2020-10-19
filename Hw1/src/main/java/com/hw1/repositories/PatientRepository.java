package com.hw1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hw1.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
