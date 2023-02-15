package com.hh.easybanckbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

	@GetMapping("/notices")
	public String getBallanceDetails() {
		return "Here are the notices from the DB";
	}

}
