package com.SpringBootProject.Hospital_Management.service;

import com.SpringBootProject.Hospital_Management.entity.Insurance;
import com.SpringBootProject.Hospital_Management.entity.Patient;
import com.SpringBootProject.Hospital_Management.repository.InsuranceRepository;
import com.SpringBootProject.Hospital_Management.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id : " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional consistency maintainces
        

        return patient;
    }

    public Patient disaccociateInsurance(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);

        return patient;
    }
}
