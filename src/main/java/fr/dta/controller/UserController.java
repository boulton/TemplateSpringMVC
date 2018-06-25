package fr.dta.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.jdbc.App;
import fr.dta.jdbc.User;
import fr.dta.jdbc.UserDao;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@RequestMapping(value="/", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser() throws Exception {
		
		User user = App.dbUser();
		
		return user;
	}
}
