package com.nan.hellokitty.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nan.hellokitty.dao.UserDao;
import com.nan.hellokitty.pojo.User;

@RestController
public class QueryController {
	@Autowired
	private UserDao usedao;

	@GetMapping(path = "get")
	public String getUserList(String name) {
		JSONObject jsonObject;
		List<User> users = usedao.getUserByName(name);
		jsonObject = new JSONObject();
		jsonObject.put("User", users);
		return jsonObject.toString();

	}
}
