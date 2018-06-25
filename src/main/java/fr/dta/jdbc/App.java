package fr.dta.jdbc;

import java.util.List;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;



@ComponentScan
@Configuration
public class App {

	static UserDao dao;
	
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		dao = context.getBean(UserDao.class);
		dao.createTable();

		dao.setUser(1,"paul","mamadou", "mamadou@mail.com", "AfricaUnited");
		
		
		
		dao.getCsv();
		context.close();
	}

	public static User dbUser() throws Exception{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		dao = context.getBean(UserDao.class);
		dao.createTable();
		User user = new User();
		System.out.println(user.getEmail());
		dao.setUser(user);
		return user;
	}
	
	
}
