package com.weather.controller;

import java.util.HashMap;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.pojo.City;
import com.weather.service.CityServices;

@RestController
@RequestMapping ("/api/Tamilnadu")
public class Controller {
	@Autowired
	CityServices service;
	
	@GetMapping(value = "/city", produces = "application/json")
	public HashMap<Integer, String> getAll()
	{
		return service.getAll();
	}

	@PostMapping(value = "/city" ,produces = "application/json" ,consumes = "application/json")
	public HashMap<Integer, String> getAdd(@RequestBody City city)
	{
		service.cityAdd(city);
		return service.getAll();
	}
	@PutMapping(value ="/city/{id}" ,produces = "application/json",consumes = "application/json")
	public HashMap<Integer, String> getEdit(@RequestBody City city)
	{
		service.cityUpdate(city);
		return service.getAll();
	}
	@DeleteMapping(value = "/city/{id}",produces = "application/json")
	public HashMap<Integer, String> getDelete(@PathVariable("id") int id)
	{
		service.cityDelete(id);
		return service.getAll();
	}


}
