package fr.dta.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.jdbc.App;
import fr.dta.jdbc.User;
import fr.dta.jdbc.UserDao;

@ComponentScan
@Configuration
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	static UserDao dao;

	@RequestMapping(value="/", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser() throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		dao = context.getBean(UserDao.class);
		dao.createTable();
		User user = new User();
		System.out.println(user.getEmail());
		dao.setUser(user);
		return user;
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST,consumes = {"application/json"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public User setUser(@RequestBody User user) throws Exception {
		
		App.dbSetUser(user);
		
		return user;
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE,consumes = {"application/json"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public User deleteUser(@RequestBody User user) throws Exception {
		
		App.dbDelUser(user);
		
		return user;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT ,consumes = {"application/json"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public User insertUser(@RequestBody User user) throws Exception {
		
		App.dbAddUser(user);
		
		return user;
	}
	
}
