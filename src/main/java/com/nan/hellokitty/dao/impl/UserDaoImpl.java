package com.nan.hellokitty.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.nan.hellokitty.dao.UserDao;
import com.nan.hellokitty.pojo.Designation;
import com.nan.hellokitty.pojo.User;

@Service
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Value("${querySQL}")
	private String QUERYUSERBYNAME;

	@Value("${insertUser}")
	private String insertUser;

	@Value("${insertDesignation}")
	private String insertDesignation;

	@Override
	public List<User> getUserByName(String name) {
		List<User> users = new ArrayList<>();
		this.jdbcTemplate.query(QUERYUSERBYNAME, new Object[] { name }, rs -> {
			User user = new User();
			Designation designation = new Designation();
			user.setName(rs.getString("Name"));
			user.setRegion(rs.getString("Region"));
			designation.setId(rs.getString("Designation"));
			designation.setValue(rs.getString("Designation_Value"));
			designation.setDescription(rs.getString("Designation_Description"));
			user.setDesignation(designation);
			users.add(user);
		});
		return users;
	}

	@Override
	public void insertUser(User user) {
		this.jdbcTemplate.update(insertUser, user.getName(), user.getRegion(), user.getDesignation().getId());
		this.jdbcTemplate.update(insertDesignation, user.getDesignation().getId(), user.getDesignation().getValue(),
				user.getDesignation().getDescription());
	}
}
