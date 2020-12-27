package com.m.g.authwithresource.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfo {

	private  String username;
	private  String firstName;
	private  String lastName;
	private  String email;
	
	public String getFirstAndLastName() {
		return firstName+" "+lastName;
	}
}
