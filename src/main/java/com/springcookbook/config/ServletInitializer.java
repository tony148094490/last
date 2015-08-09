package com.springcookbook.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[0];
	}
	
	/**
	 * This declares the Spring configuration classes. We declared the AppConfig class
	 * that is already defined.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class, DatabaseConfig.class};
	}
	
	/**
	 * This declares the servlet root URI
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
