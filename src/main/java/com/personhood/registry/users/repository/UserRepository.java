package com.personhood.registry.users.repository;

import java.util.List;

import com.personhood.registry.users.model.User;

public interface UserRepository {
	int saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Long id);
}
