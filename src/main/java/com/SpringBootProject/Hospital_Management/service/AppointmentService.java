package com.SpringBootProject.Hospital_Management.service;

import com.SpringBootProject.Hospital_Management.entity.Appointment;
import com.SpringBootProject.Hospital_Management.entity.Doctor;
import com.SpringBootProject.Hospital_Management.entity.Patient;
import com.SpringBootProject.Hospital_Management.repository.AppointmentRepository;
import com.SpringBootProject.Hospital_Management.repository.DoctorRepository;
import com.SpringBootProject.Hospital_Management.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) throws IllegalAccessException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: " + doctorId));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id : " + patientId));

        if(appointment.getId() != null) {
            throw new IllegalAccessException("Appointment should not be in the database without creating...");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        return appointment;
    }


}
