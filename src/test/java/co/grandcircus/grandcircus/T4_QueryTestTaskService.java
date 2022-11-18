package co.grandcircus.grandcircus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.grandcircus.grandcircus.controller.webapi.enums.OrderBy;
import co.grandcircus.grandcircus.controller.webapi.enums.Search;
import co.grandcircus.grandcircus.service.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class T4_QueryTestTaskService {

    @Autowired
    private TaskService  service;
    
    @Test
    public void t0_AllSearch() {    	
    	
        var results = service.search(Search.ALL, "1", OrderBy.COMPLETE_REVERSE);        
        results.forEach(System.out::println);

        int numberOfUsers = 30;
        assertThat(results).hasSize(numberOfUsers);
    }
  
    
    @Test
    public void t1_taskSearch() {    	
    	
        var results = service.search(Search.TASK, "1", OrderBy.USER_NAME);        
        results.forEach(System.out::println);

        int numberOfUsers = 12;
        assertThat(results).hasSize(numberOfUsers);
    }
    
    @Test
    public void t2_UserSearch() {    	
    	
        var results = service.search(Search.USER, "person.03", OrderBy.COMPLETE_REVERSE);        
        results.forEach(System.out::println);

        int numberOfUsers = 3;
        assertThat(results).hasSize(numberOfUsers);
    }
    
    @Test
    public void t3_prioritySearch() {    	
    	
        var results = service.search(Search.PRIORITY, "P1", OrderBy.COMPLETE_REVERSE);        
        results.forEach(System.out::println);

        int numberOfUsers = 11;
        assertThat(results).hasSize(numberOfUsers);
    }
    
    @Test
    public void t4_searchEndDate() {    	
    	
        var results = service.search(Search.END_DATE_GREATER_THAN, "2022.11.23", OrderBy.COMPLETE_REVERSE);        
        results.forEach(System.out::println);

        int numberOfUsers = 5;
        assertThat(results).hasSize(numberOfUsers);
    }
    
    @Test
    public void t5_searchEndDate() {    	
    	
        var results = service.search(Search.END_DATE_LESS_THAN, "2022.11.23", OrderBy.COMPLETE_REVERSE);        
        results.forEach(System.out::println);

        int numberOfUsers = 24;
        assertThat(results).hasSize(numberOfUsers);
    }
    
    @Test
    public void t6_complete() {    	
    	
        var results = service.search(Search.COMPLETE, 99, OrderBy.COMPLETE_REVERSE);        
        results.forEach(System.out::println);

        int numberOfUsers = 2;
        assertThat(results).hasSize(numberOfUsers);
    }
  
}