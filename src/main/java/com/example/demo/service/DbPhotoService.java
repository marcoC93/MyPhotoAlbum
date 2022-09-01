package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Photo;

public class DbPhotoService implements IPhotoService {

	List<Photo> list = new ArrayList<Photo>();
	private int lastId ;
	
	
	public DbPhotoService() {
		list.add(new Photo(1, "/img/22.png"));
		list.add(new Photo(2, "/img/23.png"));
		list.add(new Photo(3, "/img/24.png"));
		list.add(new Photo(4, "/img/25.png"));
		lastId = 3 ;

	}
	
	@Override 
	@RequestMapping("/admin/api/photos")
	public Iterable<Photo> getAll() {

		return new ArrayList<Photo>() ;
	}
	
	@Override
	@RequestMapping("/admin/api/photos/{id}")
	public Optional<Photo> getById(int id) {
		

		return Optional.empty() ;

	}
	
	@Override
	public Photo create(Photo photo ) {
		
		return null ;
	}
	
	@Override
	public Optional<Photo> update(int id,  Photo photo ) {
		
		return Optional.empty();
	}
	
	@Override
	public Boolean delete(int id) {
		
		return false ;
		
	}
}
