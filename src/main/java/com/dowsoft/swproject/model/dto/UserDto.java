package com.dowsoft.swproject.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String ID = "id";
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";
	private static final String USER_NAME = "username";
	private static final String PASSWORD = "password";

	@ApiModelProperty(value = "The user id")
	@JsonProperty
	private Long id;

	@ApiModelProperty(value = "The firstname of the user")
	@JsonProperty
	private String firstName;

	@ApiModelProperty(value = "The lastname of the user")
	@JsonProperty
	private String lastName;

	@ApiModelProperty(value = "The username of the user")
	@JsonProperty
	private String username;

	@ApiModelProperty(value = "The password of the user")
	@JsonProperty
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}

}
