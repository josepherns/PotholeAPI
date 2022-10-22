package com.Pothole.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Pothole.app.entity.Pothole;
import com.Pothole.app.service.PotholeService;

@RestController
@CrossOrigin
public class PotholeController {
	
	@Autowired
	private PotholeService service;
	
	@GetMapping("/GetPotholes")
	public List<Pothole> findAllPotholes(){
		return service.getPotholes();
	}
	
}
