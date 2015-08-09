package com.springcookbook.service;

import org.springframework.stereotype.Component;

//@Component means it's a bean and will be initialed by Spring
@Component("anAmazingUserService")
public class UserService {
	
	public int findNumberofUsers() {
		return 10;
	}
}
