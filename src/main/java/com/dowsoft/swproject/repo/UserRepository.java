package com.dowsoft.swproject.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dowsoft.swproject.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> { 
	
	@Query("from User u where u.id=:userId")
	public User findUserById(@Param("userId") Long userId);
	
	@Query("from User u where u=:user")
	public User findUserByUser(@Param("user") User user);

}
