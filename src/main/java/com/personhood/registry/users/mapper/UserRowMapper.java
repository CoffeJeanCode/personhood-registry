package com.personhood.registry.users.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.personhood.registry.users.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int RowNum) throws SQLException{
		return User
						.builder()
						.id(rs.getLong("id"))
						.publicId(rs.getString("public_id"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.email(rs.getString("email"))
						.phone(rs.getString("phone"))
						.gender(rs.getString("gender"))
						.createdAt(rs.getTimestamp("created_at"))
						.build();
	}
}
