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

import api.model.User;
import api.service.IUserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserServices service;
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/list", "/"})
	public List<User> list() {        
	    List<User> employees = service.findAll();	   
	    return employees;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public User Save(@RequestBody User user) {
		if(user.getName() != null && user.getPassword() != null)
			return service.save(user);
		return null;
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public String DeleteById(@PathVariable("id") Long id) {
		boolean ok= service.deleteById(id);
		if (ok) {
			return "User with id " + id + " has been successfuly deleted.";			
		}
		else {
			return "Could not delete user with id " + id;
		}
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public User Login(@RequestBody User user) {		
		return service.Login(user.getName(), user.getPassword());
	}
}
