package com.hh.springmvcdemo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	asss initbidenr ... to convert trim input strings
//	remove leading and trailing whitespace
//	resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor strintTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, strintTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
//		System.out.println("Last Name: |" + customer.getLastName() + "|");
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}
		return "customer-confirmation";
	}

}
