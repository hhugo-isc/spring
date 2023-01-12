package com.hh.springconfigwithjavacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
//@ComponentScan("com.hh.springconfigwithjavacode")
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
