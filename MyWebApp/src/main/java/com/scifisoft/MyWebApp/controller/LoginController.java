package com.scifisoft.MyWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String showLoginPage() {
		return "views/loginForm";
	}

}
