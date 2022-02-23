package com.etax.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int empCode;
	private String empFirstName;
	private String empLastName;
	private String empEmail;
	private long empPhoneNo;
	private String empdoj;
	private long salarypm;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public long getEmpPhoneNo() {
		return empPhoneNo;
	}
	public void setEmpPhoneNo(long empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}
	public String getEmpdoj() {
		return empdoj;
	}
	public void setEmpdoj(String empdoj) {
		this.empdoj = empdoj;
	}
	public long getSalarypm() {
		return salarypm;
	}
	public void setSalarypm(long salarypm) {
		this.salarypm = salarypm;
	}
	
	
	
}
