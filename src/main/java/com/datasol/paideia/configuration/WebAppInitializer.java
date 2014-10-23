package com.datasol.paideia.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		final AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.scan("com.datasol.paideia");
		context.addListener(new ContextLoaderListener(root));
		final ServletRegistration.Dynamic paideiaServlet = context.addServlet("paideiaServlet",
				new DispatcherServlet(new GenericWebApplicationContext()));
		paideiaServlet.setAsyncSupported(true);
		paideiaServlet.setLoadOnStartup(1);
		paideiaServlet.addMapping("/*");
		
	}

}
