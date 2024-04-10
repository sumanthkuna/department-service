package com.employeemanagement.departmentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeemanagement.departmentservice.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Long>{
	

	Optional<Department> findByDepartmentCode(String departmentCode);
}
