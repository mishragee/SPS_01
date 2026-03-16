package com.sps0101.sps01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps0101.sps01.exception.EmailAlreadyExistsException;
import com.sps0101.sps01.model.Employee;
import com.sps0101.sps01.repository.EmployeeRepository;

@Service
public class EmployeeService{
	
	@Autowired
	private EmployeeRepository ER;
	

	public  Employee saveEmployee(Employee employee) throws EmailAlreadyExistsException {
		 if (ER.existsByEmail(employee.getEmail())) {
		        throw new EmailAlreadyExistsException("Email already exists");
		    }

		return ER.save(employee);
		}
	
	public List<Employee>getAllEmployees(){
		return ER.findAll();
	}
	public Employee getEmployeeById(Long id){
		return ER.findById(id).orElse(null);
	}
	public void deleteEmployee(Long id){
		ER.deleteById(id);
	}
	

}
