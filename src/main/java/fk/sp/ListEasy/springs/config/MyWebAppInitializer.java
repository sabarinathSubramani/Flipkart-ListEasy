package fk.sp.ListEasy.springs.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {
		final AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.setServletContext(servletContext);
		root.scan("fk.sp.ListEasy.springs");
		root.refresh();

		final Dynamic servlet = servletContext.addServlet("spring", new DispatcherServlet(root));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/*");
	}

}