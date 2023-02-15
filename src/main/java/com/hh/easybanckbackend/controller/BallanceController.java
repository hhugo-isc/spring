package com.hh.easybanckbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BallanceController {

	@GetMapping("/myBallance")
	public String getBallanceDetails() {
		return "Here are the balance details from the DB";
	}

}
