package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.model.Employee;
import api.service.IEmployeeServices;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeServices service;
	
	@GetMapping({"/list", "/"})
	public List<Employee> list() {        
	    List<Employee> employees = service.listEmployee();	   
	    return employees;
	}
	
	@PostMapping
	public Employee Save(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteById(@PathVariable("id") Long id) {
		boolean ok= service.deleteById(id);
		if (ok) {
			return "Employee with id " + id + " has been successfuly deleted.";			
		}
		else {
			return "Could not delete employee with id " + id;
		}
	}
	

}
