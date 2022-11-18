package co.grandcircus.grandcircus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.grandcircus.grandcircus.entity.Status;


@Repository
public interface StatusRepository extends CrudRepository<Status, String> 
{

}