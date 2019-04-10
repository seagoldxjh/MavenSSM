package com.xjh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LogoutController {

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		System.out.println("-------------------------");
		session.invalidate();
		return "index";
	}
}
