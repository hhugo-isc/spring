package com.hh.springsecuritydemoapp.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hh.springsecuritydemoapp")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

//	setup variable to hold the properties
	@Autowired
	private Environment environment;

//	setup logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());

//	define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

//	define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {

//		create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		try {
//			set the jdbc driver class
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
//		log the connection props
//		for sanity's sake, log this info
//		just to make sure we REALLY reading data from properties file
		logger.info(">>> jdbc.url: " + environment.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user: " + environment.getProperty("jdbc.user"));

//		set database connection props
		securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		securityDataSource.setUser(environment.getProperty("jdbc.user"));
		securityDataSource.setPassword(environment.getProperty("jdbc.password"));

//		set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
	}

//	need a helper method
//	read enviroment ptoperty and convert to int
	private int getIntProperty(String propName) {
		String propVal = environment.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}

}
