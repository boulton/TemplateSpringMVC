package fr.dta.jdbc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@Min(value = 1)
	private int id ;
	
	@NotNull
	@Size(min=2)
	private String fname;
	private String lname;
	
	@Email
	private String email;
	@NotNull
	private String password;
	
	public User() {
		this.id = 1;
		this.fname="tomcat";
		this.lname="catalina";
		this.email="example@example.com";
		this.password="admin";
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


	public String getLogin() {
		// TODO Auto-generated method stub
		return fname;
	}
	
	
	
	
}
