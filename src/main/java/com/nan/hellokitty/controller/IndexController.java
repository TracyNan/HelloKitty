package com.nan.hellokitty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "hellokitty.html";
	}

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
}
