package fr.dta.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class Mycontroller {


	
	
	@RequestMapping( method = RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
	public String main() throws Exception {
		
		final DefaultResourceLoader loader = new DefaultResourceLoader();               
	    Resource ht = loader.getResource("classpath:META-INF/form.html");
	    System.out.println(ht.exists()); 
		
	    
	    File page = new File("C:\\Users\\formation\\eclipse-workspace\\scratch\\WebContent\\META-INF\\form.html");
        BufferedReader br=new BufferedReader(new FileReader(page));
		String out = null;
        String line = null ;
		while ( (line = br.readLine()) != null ) {
			out += line;
		}
		System.out.println(out.length());
		return out;
	}

	
}
