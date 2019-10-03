package com.dowsoft.swproject.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowsoft.swproject.model.User;
import com.dowsoft.swproject.model.dto.UserDto;
import com.dowsoft.swproject.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public boolean createUser(UserDto userDto) {

		logger.info("in createUser(User user) of UserServiceImpl");

		if (userDto != null) {

			User user = convertToEntity(userDto);
			userRepository.save(user);
		}
		return false;
	}

	@Override
	public UserDto findUserById(Long userId) {

		logger.info("in findUserById() of UserServiceImpl");

		if (userId != null) {

			User user = userRepository.findUserById(userId);
			return convertToDto(user);
		}
		return null;
	}

	@Override
	public UserDto findUser(UserDto userDto) {

		logger.info("in findUser() of UserServiceImpl");

		if (userDto != null) {

			User user = convertToEntity(userDto);
			User savedUser = userRepository.findUserByUser(user);
			return convertToDto(savedUser);
		}
		return null;
	}

	@Override
	public List<UserDto> findAllUsers() {

		List<User> users = (List<User>) userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();

		if (!users.isEmpty()) {

			for (User user : users) {
				UserDto userDto = convertToDto(user);
				userDtos.add(userDto);
			}
		}
		return userDtos;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {

		if (userDto != null) {

			User savedUser = userRepository.findUserById(userDto.getId());
			if (savedUser != null) {
				savedUser = convertToEntity(userDto);
				userRepository.save(savedUser);
				return userDto;
			}
		}
		return null;
	}

	@Override
	public boolean deleteUser(Long id) {

		if (id != null) {

			User savedUser = userRepository.findUserById(Long.valueOf(id));
			if (savedUser != null) {
				userRepository.delete(savedUser);
				return true;
			}
		}
		return false;
	}

	private UserDto convertToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	private User convertToEntity(UserDto userDto) {

		User user = modelMapper.map(userDto, User.class);
		return user;
	}

}
