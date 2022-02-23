package com.etax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etax.dto.TaxDetails;
import com.etax.service.TaxService;

@RestController
public class TaxController {

	@Autowired
	TaxService taxService;
	
	@GetMapping
	public TaxDetails showtax(int empCode) {
		
		TaxDetails taxDetails = new TaxDetails();
		taxDetails =taxService.taxdetail(empCode);
		return taxDetails;
	}
}
