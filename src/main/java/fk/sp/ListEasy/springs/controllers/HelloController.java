package fk.sp.ListEasy.springs.controllers;

import java.io.IOException;
import java.io.Writer;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/")
	public void home(@RequestBody final String body, final Writer writer) 
	throws IOException
	{
		writer.append("<h2>Welcome, XML Free Spring MVC!</h2>");
	}
	
	   public static void main(String[] args) throws Exception {
	        SpringApplication.run(HelloController.class, args);
	    }
}