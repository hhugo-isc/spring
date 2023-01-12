package com.hh.springconfigwithannotations;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	public String getDaylyWorkout() {
		return "Practice your backhand volley";
	}

}
