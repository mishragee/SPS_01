package com.sps0101.sps01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sps0101.sps01.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long>{
	
	boolean existsByEmail(String email);
	

}
