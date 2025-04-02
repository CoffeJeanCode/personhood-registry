package com.personhood.registry.users.service;

import java.util.List;

import com.personhood.registry.users.dto.UserDTO;

public interface UserService {
	int saveUser(UserDTO userDTO);

	List<UserDTO> getAllUsers();

	UserDTO getUserById(Long id);
}
