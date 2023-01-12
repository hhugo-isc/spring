package com.hh.springconfigwithannotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = { "Beware of the wolf in sheep's clothing", "Diligence is the mother of good luck",
			"The journey it the reward" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		int indice = myRandom.nextInt(data.length);
		return data[indice];
	}

}
