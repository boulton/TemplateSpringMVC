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

	
	public static User dbSetUser(User user) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		dao = context.getBean(UserDao.class);
		System.out.println(user.getEmail());
	
		dao.setUser(user);
		return user;
		
	}
	
	public static User dbDelUser(User user) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		dao = context.getBean(UserDao.class);
		System.out.println(user.getEmail());
	
		dao.delUser(user);
		return user;
		
	}
	
	public static User dbAddUser(User user) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		dao = context.getBean(UserDao.class);
		System.out.println(user.getEmail());
	
		dao.setUser(user);
		return user;
		
	}
	
}
