package com.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// ....

		System.out.println("on startup...");

//		root-context
		AnnotationConfigWebApplicationContext rootContext = null;
		rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AccountsServiceConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));

		// child-context
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(MvcConfig.class);

		DispatcherServlet servlet = new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/*");

	}

}
