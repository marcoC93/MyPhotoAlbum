package com.example.demo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Photo;
import com.example.demo.service.DbPhotoService;
import com.example.demo.service.IPhotoService;
import com.example.demo.service.PhotoService;


@RestController
public class AdminPhotoController {

	@Autowired
	@Qualifier("mainPhotoService")
	private IPhotoService photoService ;

	public AdminPhotoController () {
	}
	
	
	

	@RequestMapping("/admin/api/photos")
	public Iterable<Photo> getAll() {

		return photoService.getAll() ;
	}

	@RequestMapping("/admin/api/photos/{id}")
	public Photo getById(@PathVariable int id) {
		
		Optional<Photo> photo = photoService.getById(id);

		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}

		return photo.get();

	}
	
	@RequestMapping(value="/admin/api/photos" , method = RequestMethod.POST) 
	public Photo create(@RequestBody Photo photo ) {
		return photoService.create(photo);
	}
	
	@RequestMapping(value="/admin/api/photos/{id}" , method = RequestMethod.PUT) 
	public Photo update(@PathVariable int id,  @RequestBody Photo photo ) {
		
		Optional<Photo> updatePhoto = photoService.update(id, photo);
		
		if(updatePhoto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
			
		}
		
		
		return updatePhoto.get();
	}
	@RequestMapping(value="/admin/api/photos/{id}" , method = RequestMethod.DELETE) 
	public void delete(@PathVariable int id) {
		
		Boolean isDeleted = photoService.delete(id);
		
		if( isDeleted == false ) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
			
		}
		
	}
}