package com.employeemanagement.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.departmentservice.dto.DepartmentDto;
import com.employeemanagement.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		
		DepartmentDto savedDepartmentDto = departmentService.save(departmentDto);
		
		return new ResponseEntity<DepartmentDto>(savedDepartmentDto, HttpStatus.CREATED);
	}
	
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
		
		DepartmentDto departmentDtoWithGivenCode = departmentService.getDepartmentByCode(departmentCode);
		
		return new ResponseEntity<DepartmentDto>(departmentDtoWithGivenCode, HttpStatus.OK);
	}

}
