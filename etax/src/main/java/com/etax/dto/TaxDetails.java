package com.etax.dto;

public class TaxDetails {

	private int empCode;
	private String empFirstName;
	private String empLastName;
	private long yearlysal;
	private long taxamount;
	private long cessamount;
	
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public long getYearlysal() {
		return yearlysal;
	}
	public void setYearlysal(long yearlysal) {
		this.yearlysal = yearlysal;
	}
	public long getTaxamount() {
		return taxamount;
	}
	public void setTaxamount(long taxamount) {
		this.taxamount = taxamount;
	}
	public long getCessamount() {
		return cessamount;
	}
	public void setCessamount(long cessamount) {
		this.cessamount = cessamount;
	}
	
	
}
