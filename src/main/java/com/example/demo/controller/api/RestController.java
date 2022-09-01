package com.example.demo.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Photo;

@org.springframework.web.bind.annotation.RestController

public class RestController {

	@RequestMapping("/api/photos")
	public Iterable<Photo> getAll() {
		
		List<Photo> list = new ArrayList<Photo>();
		
		return list ;
	}
}
