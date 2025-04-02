package com.personhood.registry.users.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.personhood.registry.users.mapper.UserRowMapper;
import com.personhood.registry.users.model.User;
import com.personhood.registry.utils.IdUtil;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int saveUser(User user) {
		String publicId = IdUtil.generatePublicId(); 
		StringBuilder query = new StringBuilder();

		query
			.append("INSERT INTO users")
			.append("(public_id, first_name, last_name, email, phone, gender)")
			.append("VALUES (?, ?, ?, ?, ?, ?)");
		
		Object[] params = {
			publicId,
			user.getFirstName(), 
			user.getLastName(), 
			user.getEmail(), 
			user.getPhone(), 
			user.getGender(),
		 };
		
		return jdbcTemplate.update(query.toString(), params);
	}

	@Override
	public List<User> getAllUsers() {
		StringBuilder query = new StringBuilder();
		
		query
			.append("SELECT * FROM users ")
			.append("ORDER BY created_at DESC;");
		
		return jdbcTemplate.query(query.toString(), new UserRowMapper());
	}

	@Override
	public User getUserById(Long id) {
		try {
			StringBuilder query = new StringBuilder();
			
			query
				.append("SELECT * ")
				.append(" FROM users ")
				.append(" WHERE id = ?");

			return jdbcTemplate.queryForObject(query.toString(), new UserRowMapper(), id);
		} catch (EmptyResultDataAccessException error) {
			return null;
		}
	}
}
