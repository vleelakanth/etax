package com.etax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etax.dto.EmployeeDetailsRequest;
import com.etax.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService  employeeService;
	
	@PostMapping
	public String storeemp(EmployeeDetailsRequest employeeDetailsRequest) {
		employeeService.saveemp(employeeDetailsRequest);
		return "sucess";
	}

}
