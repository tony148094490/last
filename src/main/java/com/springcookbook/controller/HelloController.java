package com.springcookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcookbook.dao.UserDAO;
import com.springcookbook.model.User;
import com.springcookbook.service.UserService;

@Controller
public class HelloController {
	
	//@Autowired will inject the UserSerivce bean into this object
	@Autowired
	UserService userService;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		return "# of users: " + userService.findNumberofUsers();
	}
	
	@RequestMapping("/user/list")
	public void userList(Model model) {
		
		model.addAttribute("numberOfUsersOnRecord", userDAO.findNumberOfUsers());
		
		User user = userDAO.findUserByName("Wei");
		model.addAttribute("name", user.getName());
		model.addAttribute("gender", user.getGender());
		model.addAttribute("dob", user.getDob());
		
		User user2 = userDAO.findUserByName("GoodBuyer");
		model.addAttribute("name2", user2.getName());
		model.addAttribute("gender2", user2.getGender());
		model.addAttribute("dob2", user2.getDob());
	}
}
