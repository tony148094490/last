package com.springcookbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcookbook.model.User;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void add(User user) {
		String sql = "insert into User (name,gender,date_of_birth) values (?,?,?)";
		jdbcTemplate.update(sql,user.getName(), user.getGender(),user.getDob());
	}
	
	public User findUserByName(String name) {
		String sql = "select * from User where name = ?";
		User user = jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserMapper());
		return user;
	}
	
	public long findNumberOfUsers(){
		String sql = "select count(*) from User";
		long r = jdbcTemplate.queryForObject(sql, Long.class);
		return r;
	}
	
	private class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet row, int rowNum) throws SQLException{
			User user = new User();
			user.setName(row.getString("name"));
			user.setGender(row.getString("gender"));
			user.setDob(row.getTimestamp("date_of_birth"));
			return user;
		}
	}
	
}
