package com.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	public static void main(String[] args) {
		try {
//			create object mapper
			ObjectMapper mapper = new ObjectMapper();

//			read JSON file and map/convert
//			data/sample-lite.json
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

//			print first name and last name
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());

//			print out address: street and city
			System.out.println("Street = " + student.getAddress().getStreet());
			System.out.println("City= " + student.getAddress().getCity());
			System.out.println("Languages = " + student.getLanguages());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
