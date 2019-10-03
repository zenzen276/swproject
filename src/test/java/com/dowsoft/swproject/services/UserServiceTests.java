package com.dowsoft.swproject.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.dowsoft.swproject.abstraction.AbstractRepoTest;
import com.dowsoft.swproject.model.User;
import com.dowsoft.swproject.model.dto.UserDto;
import com.dowsoft.swproject.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserServiceTests extends AbstractRepoTest {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepo;
	
	@Before
	public void initialise(){
		  modelMapper();
	}
	
	@Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testCreateUser() {
		
		UserDto userDto = new UserDto();
		userDto.setId(1L);
		userDto.setFirstName("Derrick");		
		userDto.setLastName("Trotter");
		userDto.setUsername("delboy");
		userDto.setPassword("plonker");
		userService.createUser(userDto);
		assertEquals(1L, userRepo.count());
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testGetAllUsers() {

		createUsers();
		List<UserDto> userDtos = (List<UserDto>) userService.findAllUsers();
		assertEquals(5L, userDtos.size());

	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testGetUserById() {

		createUsers();
		UserDto userDto = userService.findUserById(2L);
		assertEquals("Johny", userDto.getFirstName());
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testDelete() {

		createUsers();
		userRepo.delete(new User(1L, "Jean", "Ang Tin Hone", "zenzen", "password"));
		assertEquals(4L, userRepo.count());
		userRepo.deleteById(3L);
		assertEquals(3L, userRepo.count());
		User user = userRepo.findUserById(3L);
		assertNull(user);
		userRepo.deleteAll();
		assertEquals(0L, userRepo.count());
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testUpdateUser() {

		createUsers();
		UserDto userDto = userService.findUserById(1L);
		userDto.setPassword("new_password");
		userService.updateUser(userDto);
		UserDto updatedUserDto = userService.findUserById(1L);
		assertEquals("new_password", updatedUserDto.getPassword());
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath + "clear_tables.sql")
	public void testGetUser() {

		createUsers();
		
		UserDto userDto = new UserDto();
		userDto.setId(1L);
		userDto.setFirstName("Jean");		
		userDto.setLastName("Ang Tin Hone");
		userDto.setUsername("zenzen");
		userDto.setPassword("password");
		
		userDto = userService.findUser(userDto);
		assertNotNull(userDto);
		assertEquals(new Long(1), userDto.getId());
	}

	private void createUsers() {

		UserDto userDto = new UserDto();
		userDto.setId(1L);
		userDto.setFirstName("Jean");		
		userDto.setLastName("Kaki");
		userDto.setUsername("zenzen");
		userDto.setPassword("password");
		userService.createUser(userDto);		
				
		userDto.setId(2L);
		userDto.setFirstName("Johny");		
		userDto.setLastName("Furlong");
		userDto.setUsername("tafazoul");
		userDto.setPassword("password");
		userService.createUser(userDto);
		
		userDto.setId(3L);
		userDto.setFirstName("Jack");		
		userDto.setLastName("Dynamite");
		userDto.setUsername("momon");
		userDto.setPassword("password");
		userService.createUser(userDto);
		
		userDto.setId(4L);
		userDto.setFirstName("Charles");		
		userDto.setLastName("Alegary");
		userDto.setUsername("leroi");
		userDto.setPassword("password");
		userService.createUser(userDto);
		
		userDto.setId(5L);
		userDto.setFirstName("Freddie");		
		userDto.setLastName("Mercury");
		userDto.setUsername("issouptol");
		userDto.setPassword("password");
		userService.createUser(userDto);
	}

}
