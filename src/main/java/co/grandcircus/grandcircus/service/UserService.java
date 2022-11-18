
package co.grandcircus.grandcircus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.grandcircus.grandcircus.entity.User;
import co.grandcircus.grandcircus.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public User getUserById(int id) {
		return repository.findById(id).get();
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		repository.findAll().forEach(user -> users.add(user));
		return users;
	}

	public void saveOrUpdate(User user) {
		repository.save(user);
	}

	public void deleteUserById(int id) {
		repository.deleteById(id);
	}
}