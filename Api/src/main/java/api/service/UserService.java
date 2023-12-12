package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.User;
import api.repository.UserRepository;

@Service
public class UserService implements IUserServices{

	@Autowired
	private UserRepository _userRepo;
	
	@Transactional(readOnly=true)	
	@Override
	public List<User> findAll() {
		return (List<User>) _userRepo.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public User findById(Long id) {		
		return (User) _userRepo.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return _userRepo.save(user);
	}

	@Transactional
	@Override
	public boolean deleteById(Long id) {
		try {
			_userRepo.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

	@Transactional(readOnly=true)
	@Override
	public User Login(String name, String password) {
		User user = _userRepo.findByName(name);
        if (user != null && (password.equals(user.getPassword())) ) {            
            return user;
        }
        return null;
    
	}

}
