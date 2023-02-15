package com.hh.easybanckbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
	@GetMapping("/myLoans")
	public String getBallanceDetails() {
		return "Here are the loans details from the DB";
	}
}
