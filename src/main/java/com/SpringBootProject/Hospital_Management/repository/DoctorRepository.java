package com.SpringBootProject.Hospital_Management.repository;

import com.SpringBootProject.Hospital_Management.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
