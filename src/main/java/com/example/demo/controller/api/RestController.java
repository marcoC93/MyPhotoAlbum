package com.example.demo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Photo;

@org.springframework.web.bind.annotation.RestController

public class RestController {

	@RequestMapping("/api/photos")
	public Iterable<Photo> getAll() {
		
		List<Photo> list = new ArrayList<Photo>();
		list.add(new Photo(1, "/img/22.png"));
		list.add(new Photo(2, "/img/23.png"));
		list.add(new Photo(3, "/img/24.png"));
		list.add(new Photo(4, "/img/25.png"));
		return list ;
	}
	
	@RequestMapping("api/photos/{id}")
	public Photo getById(@PathVariable int id) {
		List<Photo> list = new ArrayList<Photo>();
		list.add(new Photo(1, "/img/22.png"));
		list.add(new Photo(2, "/img/23.png"));
		list.add(new Photo(3, "/img/24.png"));
		list.add(new Photo(4, "/img/25.png"));
		
		Optional<Photo> photo = list.stream().filter(item->item.getId() == id).findFirst();
		
		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		
		return photo.get();
	}
}
