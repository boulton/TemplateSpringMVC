package fr.dta.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


final class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setFname(rs.getString("FirstName"));
		u.setLname(rs.getString("LastName"));
		u.setEmail(rs.getString("Email"));
		u.setPassword(rs.getString("password"));
		
		// TODO Auto-generated method stub
		return null;
	}

}
