package co.grandcircus.grandcircus.controller.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.grandcircus.controller.webapi.enums.OrderBy;
import co.grandcircus.grandcircus.controller.webapi.enums.Search;
import co.grandcircus.grandcircus.entity.Task;
import co.grandcircus.grandcircus.service.TaskService;

@CrossOrigin(origins = "http://localhost:9416")
@RestController
@RequestMapping("/api")
public class TaskWebAPIController {

	@Autowired
	TaskService taskService;	

	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTask(
			@RequestParam(name = "searchMode", defaultValue = "1", required = false) int searchMode,
			@RequestParam(name = "value", defaultValue = "*", required = false) String value,
			@RequestParam(name = "sortBy", defaultValue = "1", required = false) int sortBy)	{
		
		
		System.out.println("date.value: " + value);
		
		List<Task> tasks =	taskService.search(Search.valueOf(searchMode), value, OrderBy.valueOf(sortBy));
	
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}	
}