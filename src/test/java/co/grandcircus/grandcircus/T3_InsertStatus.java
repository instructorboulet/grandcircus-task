package co.grandcircus.grandcircus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.grandcircus.grandcircus.entity.Status;
import co.grandcircus.grandcircus.repository.StatusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class T3_InsertStatus {

	@Autowired
	private StatusRepository repository;

	private static final Logger log = LoggerFactory.getLogger(T3_InsertStatus.class);

	@Test
	public void insert() {

		repository.save(new Status("ns", "Not Started"));
		repository.save(new Status("ip", "In Progress"));
		repository.save(new Status("c", "Complete"));
		repository.save(new Status("d", "Deffered"));
		repository.save(new Status("n", "None"));

		// fetch all customers log.info("Found with findAll():");
		log.info("-------------------------------");
		var list = repository.findAll();
		for (var currentRow : list) {
			log.info(currentRow.toString());
		}
		log.info("");

	}

}