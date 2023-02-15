package com.hh.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/wellcome")
	public String wellcome() {
		return "Wellcome spring application without security";
	}

}
