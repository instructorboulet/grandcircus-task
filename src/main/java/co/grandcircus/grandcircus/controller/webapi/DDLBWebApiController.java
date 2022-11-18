package co.grandcircus.grandcircus.controller.webapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.grandcircus.repository.PriorityRepository;
import co.grandcircus.grandcircus.repository.StatusRepository;
import co.grandcircus.grandcircus.repository.UserRepository;

@RestController
@RequestMapping("/api")

public class DDLBWebApiController {	
	
	@Autowired
	PriorityRepository priorRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	UserRepository userRepository;
	
	record LookUpValues (Object code, Object value, String type) {}

	@GetMapping("/ddlb")
	public ResponseEntity<List<LookUpValues>> getLookUpValues() {
		
		List<LookUpValues> lookUpValues = new ArrayList<LookUpValues>();
		
		priorRepository.findAll().forEach(e -> {
			lookUpValues.add( new LookUpValues(e.getPriorityCode(), e.getDescription(), "priority") );
		});
		
		statusRepository.findAll().forEach(e -> {
			lookUpValues.add( new LookUpValues(e.getStatusCode(), e.getDescription(), "status") );
		});				

		userRepository.findAll().forEach(e -> {
			lookUpValues.add( new LookUpValues(e.getUserName(), e.getUserName(), "user") );
		});		

		return new ResponseEntity<>(lookUpValues, HttpStatus.OK);
	}
}
