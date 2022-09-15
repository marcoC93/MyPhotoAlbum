package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bytebuddy.asm.Advice.Return;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String admin() {
		return "admin" ;
	}
	
	@RequestMapping("/login")
	public String login() {
		return  "login" ;
	}
	
}
