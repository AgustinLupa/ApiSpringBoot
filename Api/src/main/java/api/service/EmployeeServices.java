package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.Employee;
import api.repository.EmployeeRepository;

@Service
public class EmployeeServices implements IEmployeeServices{

	@Autowired
	private EmployeeRepository _emploRepo;
	
	@Transactional(readOnly=true)
	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) _emploRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return _emploRepo.save(employee);
	}

	@Override
	public boolean deleteById(Long id) {
		try {
			_emploRepo.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

}
