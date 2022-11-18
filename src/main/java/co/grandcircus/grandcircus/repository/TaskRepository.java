package co.grandcircus.grandcircus.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.grandcircus.grandcircus.entity.Task;


@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>  
{
	
	
	@Query("SELECT m FROM Task m WHERE m.description LIKE %:taskName%")
	public List<Task> findByTaskName(@Param("taskName") String taskNam, Sort sort);	
	
	@Query("SELECT u FROM Task u WHERE u.priority.priorityCode = :priorityCode")
	public List<Task> findByPriority(@Param("priorityCode") String priorityCode, Sort sort);	
	
	@Query("SELECT u FROM Task u WHERE u.status.statusCode = :statusCode")
	public List<Task> findByStatus(@Param("statusCode") String statusCode, Sort sort );		
	
	@Query("SELECT u FROM Task u WHERE u.user.userName = ?1")
	public List<Task> findByUser(String user, Sort sort);	

	@Query("SELECT u FROM Task u WHERE u.endDate = :endDate")
	public List<Task> findByEndDate(@Param("endDate") String endDate, Sort sort);
	
	@Query("SELECT u FROM Task u WHERE u.endDate > :endDate")
	public List<Task> findByEndDateGreaterThan(@Param("endDate") String endDate, Sort sort);
	
	@Query("SELECT u FROM Task u WHERE u.endDate < :endDate")
	public List<Task> findByEndDateLessThan(@Param("endDate") String endDate, Sort sort);	
	
	@Query("SELECT u FROM Task u WHERE u.complete = :complete")
	public List<Task> findByComplete(@Param("complete") float complete, Sort sort);
	
	@Query("SELECT u FROM Task u WHERE u.complete > :complete")
	public List<Task> findByCompleteGreaterThan(@Param("complete") float complete, Sort sort);
	
	@Query("SELECT u FROM Task u WHERE u.complete < :complete")
	public List<Task> findByCompleteLessThan(@Param("complete") float complete, Sort sort);

	@Query("SELECT m FROM Task m ")
	public List<Task> findAll(String value, Sort by);

}