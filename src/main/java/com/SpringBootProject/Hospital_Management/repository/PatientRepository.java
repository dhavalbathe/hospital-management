package com.SpringBootProject.Hospital_Management.repository;

import com.SpringBootProject.Hospital_Management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
