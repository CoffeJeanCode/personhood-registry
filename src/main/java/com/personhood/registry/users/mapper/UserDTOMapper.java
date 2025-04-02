package com.personhood.registry.users.mapper;

import com.personhood.registry.users.dto.UserDTO;
import com.personhood.registry.users.model.User;

public class UserDTOMapper {
	public static UserDTO toUserDTO(User user) {
		if(user != null) {
			return UserDTO
							.builder()
							.id(user.getId())
							.publicId(user.getPublicId())
							.firstName(user.getFirstName())
							.lastName(user.getLastName())
							.email(user.getEmail())
							.phone(user.getPhone())
							.gender(user.getGender())
							.createdAt(user.getCreatedAt())
							.build();
		}
		return null;
	}

}
