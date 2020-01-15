package com.user.info.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class UserDTO implements Serializable {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String emailId;


}
