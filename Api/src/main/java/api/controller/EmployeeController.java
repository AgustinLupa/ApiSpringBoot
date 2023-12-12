package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/list", "/"})
	public List<Employee> list() {        
	    List<Employee> employees = service.listEmployee();	   
	    return employees;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public Employee Save(@RequestBody Employee employee) {
		if(employee.getEmail() != null && employee.getName() != null && employee.getPhone() != null)
			return service.saveEmployee(employee);
		return null;
	}
	
	@CrossOrigin(origins = "*")
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
