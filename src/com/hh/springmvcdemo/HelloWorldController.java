package com.hh.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

//	need a controller method to show the initien HTML form	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

//	need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

//	new a controller method to read form data and
//	add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
//		read request parameters from the HTML form
		String name = request.getParameter("studentName");
//		convert the data to all caps
		name = name.toUpperCase();
//		create the message
		String result = "Yo! " + name;
//		add the message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}

}
