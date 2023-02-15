package com.hh.easybanckbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	@GetMapping("/contact")
	public String getBallanceDetails() {
		return "Here are the contact from the DB";
	}
}
