package com.springcookbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan (basePackages = {"com.springcookbook.controller","com.springcookbook.service"
		,"com.springcookbook.dao","com.springcookbook.model"})
public class AppConfig {

}
