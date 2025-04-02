package com.personhood.registry.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personhood.registry.users.dto.UserDTO;
import com.personhood.registry.users.mapper.UserDTOMapper;
import com.personhood.registry.users.mapper.UserMapper;
import com.personhood.registry.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public int saveUser(UserDTO userDTO) {
		return userRepository.saveUser(UserMapper.toUser(userDTO));
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userRepository.getAllUsers().stream().map(UserDTOMapper::toUserDTO).toList();
	}

	@Override
	public UserDTO getUserById(Long id) {
		return UserDTOMapper.toUserDTO(userRepository.getUserById(id));
	}
}
