package com.etax.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etax.dto.EmployeeDetailsRequest;
import com.etax.entity.Employee;
import com.etax.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void saveemp(EmployeeDetailsRequest employeeDetailsRequest) {
		Employee emp =new Employee();
		BeanUtils.copyProperties(employeeDetailsRequest, emp);
		employeeRepository.save(emp);
		
	}

}
