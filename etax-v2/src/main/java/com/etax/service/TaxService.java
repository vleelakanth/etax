package com.etax.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etax.dto.TaxDetails;
import com.etax.dto.TaxDetailsRequest;
import com.etax.entity.Employee;
import com.etax.repository.EmployeeRepository;

@Service
public class TaxService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public TaxDetails taxdetail(TaxDetailsRequest taxDetailsRequest) {
		Employee emp = new Employee();
		TaxDetails taxDetails = new TaxDetails();
		long totalincome=0;
		emp=employeeRepository.findByempCode(taxDetailsRequest.getEmpCode());
		taxDetails.setEmpCode(emp.getEmpCode());
		taxDetails.setEmpFirstName(emp.getEmpFirstName());
		taxDetails.setEmpLastName(emp.getEmpLastName());
		
		int financialyear = taxDetailsRequest.getFinyear();
		LocalDate doj = LocalDate.parse(emp.getEmpdoj());
		LocalDate mon = LocalDate.now();
		Period diff =  Period.between(doj, mon);
		if (doj.getYear()<financialyear-1) {
			 totalincome = (emp.getSalarypm()*12);
		}
		
		else if(diff.getYears()>1) {
			totalincome = (emp.getSalarypm()*12);
			
		}
		
		else if (diff.getYears()<=1 && diff.getMonths()<12) {
			totalincome = (emp.getSalarypm()*diff.getMonths());
		}
		
		
		taxDetails.setYearlysal(totalincome);
		
		if (totalincome < 250000) {
			taxDetails.setTaxamount(0);
			taxDetails.setCessamount(0);
		}
		else if (totalincome > 250000 && totalincome <=500000 ) {
			long taxinslab = totalincome-250000;
			long tax = (long)(taxinslab*(5/100.0f));
			taxDetails.setTaxamount(tax);
			taxDetails.setCessamount(0);
			
		}
		else if(totalincome >500000 && totalincome<=1000000 ) {
			long taxinslab = totalincome-250000;
			long tax = (long)(taxinslab*(10/100.0f));
			taxDetails.setTaxamount(tax);
			taxDetails.setCessamount(0);
		}
		else if(totalincome >1000000 && totalincome<= 2500000 ) {
			long taxinslab = totalincome-250000;
			long tax =(long)(taxinslab*(20/100.0f));
			taxDetails.setTaxamount(tax);
			taxDetails.setCessamount(0);
		}
		
		else if(totalincome > 2500000 ) {
			long taxinslab = totalincome-250000;
			long tax = (long)(taxinslab*(20/100.0f));
			taxDetails.setTaxamount(tax);
			long cessslab = (long)(taxinslab*(2/100.0f));
			taxDetails.setCessamount(cessslab);
		}
		return taxDetails;
	}

	

}
