package com.dowsoft.swproject.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dowsoft.swproject.model.dto.UserDto;
import com.dowsoft.swproject.model.rest.RestException;
import com.dowsoft.swproject.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "UserController", description = "operations on " + "user", hidden = false)
@RequestMapping("/users")
@RestController
public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class);

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "create user", notes = "create new user", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "error creating user", response = RestException.class) })
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody boolean insertUser(@ApiParam(value = "The user data") @RequestBody UserDto userDto)
			throws Exception {

		try {

			return userService.createUser(userDto);

		} catch (Exception e) {
			Exception ex = new Exception("Cannot get User", e);
			throw ex;
		}
	}

	@ApiOperation(value = "Get all users", notes = "Get all Users", response = UserDto.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Cannot get User", response = RestException.class) })
	@RequestMapping(value = "/" + "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserDto> getAllUsers() throws Exception {

		try {
			return userService.findAllUsers();

		} catch (Exception e) {
			Exception ex = new Exception("Cannot get User", e);
			throw ex;
		}
	}

	@ApiOperation(value = "get user by id", notes = "get user by id", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "cannot get user details", response = RestException.class) })
	@RequestMapping(value = "/user" + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDto getUserByUserId(
			@ApiParam(value = "The id of the user") @PathVariable("id") String id) {

		if (id != null) {
			return userService.findUserById(Long.valueOf(id));
		}
		return null;
	}

	@ApiOperation(value = "update user details", notes = "update user details", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Cannot update user", response = RestException.class) })
	@RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDto updateActivity(@ApiParam(value = "The updated user data") @RequestBody UserDto userDto)
			throws Exception {

		if (userDto != null) {
			return userService.updateUser(userDto);
		}
		return null;
	}
	
	@ApiOperation(value = "delete user by id", notes = "delete user by id", response = Boolean.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "cannot get delete user", response = RestException.class) })
	@RequestMapping(value = "/user" + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean deleteByUserId(
			@ApiParam(value = "The id of the user") @PathVariable("id") Long id) {

		if (id != null) {
			boolean flag = userService.deleteUser(id); 
			return new Boolean(flag);
		}
		return null;
	}

}
