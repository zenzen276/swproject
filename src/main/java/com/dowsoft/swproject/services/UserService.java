package com.dowsoft.swproject.services;

import java.util.List;

import com.dowsoft.swproject.model.dto.UserDto;

public interface UserService {
    
    public boolean createUser(UserDto user);
    
    public UserDto findUserById(Long userId);
    
    public UserDto findUser(UserDto userDto);      
    
    public List<UserDto> findAllUsers();
    
    public UserDto updateUser(UserDto userDto);

	public boolean deleteUser(Long id);

}
