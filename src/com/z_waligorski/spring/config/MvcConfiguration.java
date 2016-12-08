package com.z_waligorski.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.z_waligorski.spring.dao.ReagentDAO;
import com.z_waligorski.spring.dao.ReagentDAOImpl;

@Configuration
@ComponentScan(basePackages = "com.z_waligorski.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	
	//Put here your database settings: DriverClassName, Url, Username, Password
	//Table name needs also to be set in ReagentDAOImpl.class
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("URL");
		dataSource.setUsername("USERNAME");
		dataSource.setPassword("PASSWORD");
		
		return dataSource;
	}
	
	@Bean
	public ReagentDAO getReagentDAO(){
		return new ReagentDAOImpl(getDataSource());
	}

}
