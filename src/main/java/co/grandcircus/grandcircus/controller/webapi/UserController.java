package co.grandcircus.grandcircus.controller.webapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.grandcircus.entity.User;
import co.grandcircus.grandcircus.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	/*
	 * http://127.0.0.1:9416/api/users?userName=person.09
	 * http://127.0.0.1:9416/api/users
	 */

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String userName) {

		List<User> users = new ArrayList<User>();

		if (userName == null)
			userRepository.findAll().forEach(users::add);
		else {
			userRepository.findByUserName(userName).forEach(users::add);
		}

		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		//var newUser = new User(user.getUserName(), user.getFirstName(), user.getLastName());
		User _user = userRepository.save(user);
		return new ResponseEntity<>(_user, HttpStatus.CREATED);
	}

}
