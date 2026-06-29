package com.SpringBootProject.Hospital_Management.repository;

import com.SpringBootProject.Hospital_Management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
