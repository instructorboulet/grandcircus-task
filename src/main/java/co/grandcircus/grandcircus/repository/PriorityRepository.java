package co.grandcircus.grandcircus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.grandcircus.grandcircus.entity.Priority;


@Repository
public interface PriorityRepository extends CrudRepository<Priority, String>  
{

}