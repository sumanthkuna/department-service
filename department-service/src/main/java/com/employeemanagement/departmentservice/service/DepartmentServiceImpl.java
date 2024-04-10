package com.employeemanagement.departmentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.departmentservice.dto.DepartmentDto;
import com.employeemanagement.departmentservice.entity.Department;
import com.employeemanagement.departmentservice.exception.ResourceNotFoundException;
import com.employeemanagement.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto save(DepartmentDto departmentDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		Department departmentToSave = modelMapper.map(departmentDto, Department.class);
		Department savedDepartment = departmentRepository.save(departmentToSave);
		DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment,DepartmentDto.class);
		
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department departmentWithGivenCode = departmentRepository.findByDepartmentCode(departmentCode).
				orElseThrow(
						()->new ResourceNotFoundException("Department", "id", departmentCode)
						);
		ModelMapper modelMapper = new ModelMapper();
		DepartmentDto departmentDto = modelMapper.map(departmentWithGivenCode, DepartmentDto.class);
		return departmentDto;
	}

}
