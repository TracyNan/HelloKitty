package com.nan.hellokitty.dao;

import java.util.List;

import com.nan.hellokitty.pojo.User;

public interface UserDao {
	public List<User> getUserByName(String name);
	public void insertUser(User user);
}
