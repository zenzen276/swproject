package com.dowsoft.swproject.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.dowsoft.swproject.abstraction.AbstractRepoTest;
import com.dowsoft.swproject.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserRepositoryTests extends AbstractRepoTest {
	@Autowired
	UserRepository userRepo;	

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	public void testCreateUser() {

		User user = new User(1L, "Jean", "Ang Tin Hone", "zenzen", "password");
		userRepo.save(user);

		assertEquals(1L, userRepo.count());
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testGetAllUsers() {

		createUsers();
		List<User> users = (List<User>) userRepo.findAll();
		assertEquals(5L, users.size());

	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testGetUserById() {

		createUsers();		
		User user = userRepo.findUserById(2L);
		assertEquals("Johny", user.getFirstName());
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testDelete() {

		createUsers();
		userRepo.delete(new User(1L, "Jean", "Ang Tin Hone", "zenzen", "password"));
		assertEquals(4L, userRepo.count());
		userRepo.deleteById(3L);
		assertEquals(3L, userRepo.count());
		Optional<User> optional = userRepo.findById(3L);
		assertTrue(!optional.isPresent());
		userRepo.deleteAll();
		assertEquals(0L, userRepo.count());
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testUpdateUser() {		
		
	  	 createUsers();
		 User user = userRepo.findUserById(1L);
		 user.setPassword("new_password");
		 userRepo.save(user);		 
		 User updatedUser = userRepo.findUserById(1L);
		 assertEquals("new_password", updatedUser.getPassword());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testGetUser() {	
		
		 createUsers();
		 User user = userRepo.findUserByUser(new User(1L, "Jean", "Ang Tin Hone", "zenzen", "password"));
		 assertNotNull(user);		 
		 assertEquals(new Long(1), user.getId());
	}

	private void createUsers() {

		User user = new User(1L, "Jean", "Kaki", "zenzen", "password");
		userRepo.save(user);

		user = new User(2L, "Johny", "Furlong", "tafazoul", "password");
		userRepo.save(user);

		user = new User(3L, "Jack", "Dynamite", "momon", "password");
		userRepo.save(user);

		user = new User(4L, "Charles", "Alegary", "leroi", "password");
		userRepo.save(user);

		user = new User(5L, "Freddie", "Mercury", "issouptol", "password");
		userRepo.save(user);
	}
}
