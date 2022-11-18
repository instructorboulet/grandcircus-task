package co.grandcircus.grandcircus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.grandcircus.grandcircus.entity.Priority;
import co.grandcircus.grandcircus.repository.PriorityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class T1_InsertPriorities {

	@Autowired
	private PriorityRepository repository;

	private static final Logger log = LoggerFactory.getLogger(T1_InsertPriorities.class);

	@Test
	public void insert() {		
		
		var results = repository.findAll();		
		
		if (results.iterator().hasNext() == false) {
			repository.save(new Priority("P1", "Normal"));
			repository.save(new Priority("P2", "High"));
			repository.save(new Priority("P3", "Low"));
			repository.save(new Priority("N1", "None"));	
		}
		
		// fetch all customers log.info("Found with findAll():");
		log.info("-------------------------------");
		var list = repository.findAll();
		for (var currentRow : list) {
			log.info(currentRow.toString());
		}
		log.info("");

		int count = 4;
		assertThat(list).hasSize(count);
	}

}