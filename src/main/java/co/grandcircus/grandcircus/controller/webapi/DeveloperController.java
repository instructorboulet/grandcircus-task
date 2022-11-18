package co.grandcircus.grandcircus.controller.webapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/developer")
public class DeveloperController {	

	@GetMapping
	public Map<String,String> getDeveloper() {
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("developer", "boulet,jean");
		map.put("email", "instructor.boulet@gmail.com");
		
		return map;
		
	}

}
