package com.sps0101.sps01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps0101.sps01.exception.EmailAlreadyExistsException;
import com.sps0101.sps01.model.Employee;
import com.sps0101.sps01.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService ES;
//	POST   /employees
//	GET    /employees
//	GET    /employees/{id}
//	DELETE /employees/{id}
	
	
	  @PostMapping("/add")
    public Employee postEmployee(@Valid @RequestBody Employee employee) throws EmailAlreadyExistsException {
        return ES.saveEmployee(employee);
    }
	
	
	@GetMapping("/all")
	public List<Employee>allEmployees() {
		
		return ES.getAllEmployees();
		
	}
	
	@GetMapping("/{Id}")
	public Employee specificEmployee(Long Id) {
		
		return ES.getEmployeeById(Id);
		
	}
	@DeleteMapping("/{id}")
	public void removeEmployee(@PathVariable Long id ) {
		
		 ES.deleteEmployee(id);
		
	}
	
	

}
