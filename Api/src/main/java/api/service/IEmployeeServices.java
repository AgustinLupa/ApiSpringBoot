package api.service;

import java.util.List;

import api.model.Employee;


public interface IEmployeeServices {
	public List<Employee> listEmployee();
	public Employee saveEmployee(Employee employee);
	public boolean deleteById(Long id);	
}
