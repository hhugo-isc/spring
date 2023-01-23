package com.hh.springbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

//	expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "hello World, Time on Server is " + LocalDateTime.now();
	}

	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run hard 5k";
	}

	@GetMapping("/fortune")
	public String getDailyFourtune() {
		return "Today is your lucky day";
	}

}
