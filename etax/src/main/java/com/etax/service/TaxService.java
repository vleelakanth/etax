package com.etax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etax.dto.TaxDetails;
import com.etax.entity.Employee;
import com.etax.repository.EmployeeRepository;

@Service
public class TaxService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public TaxDetails taxdetail(int empCode) {
		Employee emp = new Employee();
		TaxDetails taxDetails = new TaxDetails();
		emp=employeeRepository.findByempCode(empCode);
		taxDetails.setEmpCode(emp.getEmpCode());
		taxDetails.setEmpFirstName(emp.getEmpFirstName());
		taxDetails.setEmpLastName(emp.getEmpLastName());
		
		long totalincome = employeeRepository.totalincome();
		
		taxDetails.setYearlysal(totalincome);
		if (totalincome <= 250000) {
			taxDetails.setTaxamount(0);
			taxDetails.setCessamount(0);
		}
		else if (totalincome > 250000 && totalincome <=500000 ) {
			long taxinslab = totalincome-250000;
			long tax = taxinslab%5;
			taxDetails.setTaxamount(tax);
			taxDetails.setCessamount(0);
			
		}
		else if(totalincome >500000 && totalincome<=1000000 ) {
			long taxinslab = totalincome-250000;
			long tax = taxinslab%10;
			taxDetails.setTaxamount(tax);
			taxDetails.setCessamount(0);
		}
		else if(totalincome >1000000 && totalincome<= 2500000 ) {
			long taxinslab = totalincome-250000;
			long tax = taxinslab%20;
			taxDetails.setTaxamount(tax);
			taxDetails.setCessamount(0);
		}
		
		else if(totalincome > 2500000 ) {
			long taxinslab = totalincome-250000;
			long tax = taxinslab%20;
			taxDetails.setTaxamount(tax);
			long cessslab = taxinslab%2;
			taxDetails.setCessamount(cessslab);
		}
		return taxDetails;
	}

}
