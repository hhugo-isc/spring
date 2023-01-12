package com.hh.springconfigwithannotations;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	public String getDaylyWorkout() {
		return "Practice your backhand volley";
	}

}
