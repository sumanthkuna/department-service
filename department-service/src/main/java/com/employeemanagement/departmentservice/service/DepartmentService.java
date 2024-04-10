package com.employeemanagement.departmentservice.service;

import com.employeemanagement.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto save(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
}
