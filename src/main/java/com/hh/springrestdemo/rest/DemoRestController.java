package com.hh.springrestdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

//	add code to the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHelloWorld() {
		return "Hello World";
	}

}
