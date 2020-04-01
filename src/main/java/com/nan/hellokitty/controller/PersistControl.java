package com.nan.hellokitty.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nan.hellokitty.dao.UserDao;
import com.nan.hellokitty.pojo.Designation;
import com.nan.hellokitty.pojo.User;

@ResponseBody
@RestController
public class PersistControl {
	@Autowired
	private UserDao usedao;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertUser(@RequestBody String jsonString) {
		JSONObject json=new JSONObject(jsonString);
		User user = new User();
		Designation designation2 = new Designation();
		designation2.setId(json.getString("designation"));
		designation2.setValue(json.getString("desigValue"));
		designation2.setDescription(json.getString("desigDesc"));
		user.setName(json.getString("name"));
		user.setRegion(json.getString("region"));
		user.setDesignation(designation2);
		usedao.insertUser(user);
	}
}
