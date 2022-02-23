package com.etax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.etax.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Employee findByempCode(int empCode);

	@Query(value ="select sum(e.salarypm) from Employee e where e.empdoj>'31-03-2021' ")
	public long totalincome();

}
