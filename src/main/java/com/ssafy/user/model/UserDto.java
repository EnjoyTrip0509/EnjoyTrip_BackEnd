package com.ssafy.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String id;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private String joinDate;
	
	private boolean isAdmin;
}
