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

@Service("mainPhotoService")

public class PhotoService implements IPhotoService {

	
	List<Photo> list = new ArrayList<Photo>();
	private int lastId ;
	
	
	public PhotoService() {
		list.add(new Photo(1, "/img/22.png"));
		list.add(new Photo(2, "/img/23.png"));
		list.add(new Photo(3, "/img/24.png"));
		list.add(new Photo(4, "/img/25.png"));
		lastId = 3 ;

	}
	
	@Override
	@RequestMapping("/admin/api/photos")
	public Iterable<Photo> getAll() {

		return list ;
	}
	
	@Override
	@RequestMapping("/admin/api/photos/{id}")
	public Optional<Photo> getById(int id) {
		List<Photo> list = new ArrayList<Photo>();
		list.add(new Photo(1, "/img/22.png"));
		list.add(new Photo(2, "/img/23.png"));
		list.add(new Photo(3, "/img/24.png"));
		list.add(new Photo(4, "/img/25.png"));

		Optional<Photo> photo = list.stream().filter(item->item.getId() == id).findFirst();

		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}

		return photo;

	}
	
	@Override
	public Photo create(Photo photo ) {
		lastId++ ;
		
		photo.setId(lastId);
		list.add(photo);
		return photo;
	}
	
	@Override
	public Optional<Photo> update(int id,  Photo photo ) {
		
		Optional<Photo> foundPhoto = list.stream().filter(item->item.getId() == id).findFirst();
		
		if(foundPhoto.isEmpty()) {

			Optional.empty();
		}
		foundPhoto.get().setUrl(photo.getUrl());
		
		return foundPhoto;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Photo> foundPhoto = list.stream().filter(item->item.getId() == id).findFirst();
		
		if(foundPhoto.isEmpty()) {


			return false ;
		}
		list.remove(foundPhoto.get() );
		
			return true ; 
	}
}
