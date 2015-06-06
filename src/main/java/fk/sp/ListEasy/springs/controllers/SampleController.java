/*package fk.sp.ListEasy.springs.controllers;
import javax.servlet.ServletContext;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;

@Controller
@EnableAutoConfiguration
public class SampleController  implements ServletContextAware{

	 @Autowired
	 ServletContext context; 
	 
    @RequestMapping("/createProduct")
    @ResponseBody
    String home(@RequestParam("sellerId") String sellerId) {
    
    	context.setAttribute("SellerId", sellerId);
        return "Hello World!"+sellerId;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

	@Override
	public void setServletContext(ServletContext arg0) {
		context = arg0;
	}
}*/