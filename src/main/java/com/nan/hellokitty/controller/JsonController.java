package com.nan.hellokitty.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nan.hellokitty.pojo.User;

@RestController
@RequestMapping("user")
public class JsonController {
	@RequestMapping("getUser")
	public List<User> getUerList(){
		List<User> users=new ArrayList<User>();
		users.add(new User("Zhu",1));
		users.add(new User("Nan",1));
		return users; 
	}
}
