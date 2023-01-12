package com.hh.springconfigwithjavacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration()
//@ComponentScan("com.hh.springconfigwithjavacode")
@PropertySource("classpath:sport.properties")
public class SportConfig {

//	define bean for out sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

//	define bean for our swim 
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
