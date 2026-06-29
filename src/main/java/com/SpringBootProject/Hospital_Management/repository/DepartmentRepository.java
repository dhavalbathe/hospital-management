package com.SpringBootProject.Hospital_Management.repository;

import com.SpringBootProject.Hospital_Management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
