package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	
	public String index() {
		return "index" ;
	}
	
	
	@RequestMapping("/demo")

	public String demo() {
		return "THIS IS A DEMO PAGE" ;
	}
}
