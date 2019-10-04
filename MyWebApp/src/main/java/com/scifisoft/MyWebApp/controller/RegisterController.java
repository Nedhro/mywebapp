package com.scifisoft.MyWebApp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.scifisoft.MyWebApp.entities.Employee;

@Controller
public class RegisterController {

	@GetMapping("/registration")
	public String registerForm(Model model) {
		model.addAttribute("employees", new Employee());
		return "views/registerForm";
	}

	@PostMapping("/register")
	public String registerEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "views/registerForm";
		}
		return "views/login";
	}

}
