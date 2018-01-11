package com.xh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	// 跳转到首页
	@RequestMapping("/toWelcome")
	public String toWelcome() {
		return "welcome";
	}
}
