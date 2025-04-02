package com.personhood.registry.users.dto;

import java.sql.Timestamp;

import com.personhood.registry.users.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	private Long id;
	private String publicId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String gender;
	private Timestamp createdAt;
}
