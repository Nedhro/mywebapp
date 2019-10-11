package com.scifisoft.MyWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}

	@PostMapping("/home")
	public String homePage() {
		return "index";
	}

}
