package api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByName(String Name);
}
