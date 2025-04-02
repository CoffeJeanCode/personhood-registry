package com.personhood.registry.users.mapper;

import com.personhood.registry.users.dto.UserDTO;
import com.personhood.registry.users.model.User;

public class UserMapper {
	public static User toUser(UserDTO userDTO) {
		if (userDTO != null) {
			return User
							.builder()
							.id(userDTO.getId())
							.publicId(userDTO.getPublicId())
							.firstName(userDTO.getFirstName())
							.lastName(userDTO.getLastName())
							.email(userDTO.getEmail())
							.phone(userDTO.getPhone())
							.gender(userDTO.getGender())
							.createdAt(userDTO.getCreatedAt())
							.build();
		}
		return null;
	}
}
