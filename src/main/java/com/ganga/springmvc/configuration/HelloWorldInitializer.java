package com.ganga.springmvc.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HelloWorldInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(HelloWorldConfiguration.class);
	        ctx.setServletContext(container);
	 
	        ServletRegistration.Dynamic servlet = container.addServlet(
	                "dispatcher", new DispatcherServlet(ctx));
	        servlet.setAsyncSupported(true);
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");		
	}

}