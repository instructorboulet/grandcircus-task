package co.grandcircus.grandcircus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.grandcircus.grandcircus.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>  {

	Iterable<User> findByUserName(String userName);

}