package fr.dta.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDao {

	private JdbcTemplate jdbcTemplate;
	private final String dbName = "usersDB";
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);

	}
	
	public void createTable() throws Exception {
		try (Connection conn = this.jdbcTemplate.getDataSource().getConnection()) {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("drop table if exists "+dbName+" cascade ; ");
			stmt.executeUpdate( "CREATE TABLE "+dbName +" ( " + 
											" id serial primary key ," +
											" FirstName VARCHAR(100), " +
											" LastName VARCHAR(100), " +
											" Email VARCHAR(100), " +
											" password VARCHAR(70) NOT NULL " + 
											" );");
		}
	}
	
	public void setUser(User u) {
		jdbcTemplate.update("insert into "+dbName+"  values (?,?,?,?,?)",u.getId() , u.getFname(), u.getLname(), u.getEmail(), u.getPassword());
	}
	public void setUser(int id ,String fname, String lname, String email, String password) {
		jdbcTemplate.update("insert into "+dbName+"  values (?,?,?,?,?)",id , fname, lname, email, password);
		
	}

	
	public void getCsv() {

		jdbcTemplate.query("select * from "+dbName,new CsvWriter());

	}

}
