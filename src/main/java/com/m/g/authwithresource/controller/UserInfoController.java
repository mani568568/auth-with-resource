package com.m.g.authwithresource.controller;

import com.m.g.authwithresource.model.UserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

	@GetMapping("/userinfo")
	public UserInfo userInfo(@AuthenticationPrincipal User user) {
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail("m@mc.om");
		userInfo.setFirstName(user.getUsername());
		userInfo.setLastName("Guduri");
		userInfo.setUsername(user.getUsername());
		return userInfo;
	}
	
}
