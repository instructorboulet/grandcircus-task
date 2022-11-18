package co.grandcircus.grandcircus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.grandcircus.grandcircus.entity.User;
import co.grandcircus.grandcircus.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class T2_InsertUsers {

	@Autowired
	private UserRepository repository;

	@Test
	public void insert10Users() {
		
		var users = repository.findAll();	
		// remark the @GeneratedValue in order to control the id
		repository.save(new User(1,"person.01", "Smith", "Jean"));
		repository.save(new User(2,"person.02", "Davidison", "Monica"));
		repository.save(new User(3,"person.03", "Allard", "Veronica"));
		repository.save(new User(4,"person.04", "Belfor", "Chantal"));
		repository.save(new User(5,"person.05", "Williams", "Linnette"));
		repository.save(new User(6,"person.06", "Boulet", "Robert"));
		repository.save(new User(7,"person.07", "Kennedy", "Jeffery"));
		repository.save(new User(8,"person.08", "Brown", "Garrette"));
		repository.save(new User(9,"person.09", "Smith", "Horace"));
		repository.save(new User(10,"person.10", "Howard", "Lance"));		
		users.forEach(System.out::println);
		
		
		int numberOfUsers = 10;
		assertThat(users).hasSize(numberOfUsers);
	}
	
	@Test
	public void insert1() {			
		repository.save(new User(11,"person.11", "Parker", "Peter"));		
		var users = repository.findAll();		
		users.forEach(System.out::println);	
		
		int numberOfUsers = 11;
		assertThat(users).hasSize(numberOfUsers);
	}


}