package api.service;

import java.util.List;

import api.model.User;



public interface IUserServices {
	public List<User> findAll();
	public User findById(Long id);
	public User save(User user);
	public boolean deleteById(Long id);
	public User Login (String name, String password);
}
