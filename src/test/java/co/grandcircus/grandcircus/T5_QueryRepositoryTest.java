package co.grandcircus.grandcircus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.grandcircus.grandcircus.repository.PriorityRepository;
import co.grandcircus.grandcircus.repository.StatusRepository;
import co.grandcircus.grandcircus.repository.TaskRepository;
import co.grandcircus.grandcircus.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class T5_QueryRepositoryTest {

    @Autowired
    private UserRepository  repository;
    
    @Autowired
    private StatusRepository  statusRepository;
    
    @Autowired
    private PriorityRepository  priorityRepository;
    
    @Autowired
    private TaskRepository  taskRepository;

    @Test
    public void findAllUsers() {
    	System.out.println("t1");
        var users = repository.findAll();
        
        users.forEach(System.out::println);

        int numberOfUsers = 13;
        assertThat(users).hasSize(numberOfUsers);
    }
    
    @Test
    public void findAllStatus() {
    	System.out.println("t1");
        var results = statusRepository.findAll();
        
        results.forEach(System.out::println);

        int count = 5;
        assertThat(results).hasSize(count);
    }
    
    @Test
    public void findAllPriority() {    	
        
    	var results = priorityRepository.findAll();
        results.forEach(System.out::println);
        
        int count = 4;
        assertThat(results).hasSize(count);
    } 
    
    @Test
    public void findAllTask() {
    	
        var results = taskRepository.findAll();
        
        results.forEach(System.out::println);

        int count = 30;
        assertThat(results).hasSize(count);
    }   
    


}