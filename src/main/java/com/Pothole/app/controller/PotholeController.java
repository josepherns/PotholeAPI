package com.Pothole.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Pothole.app.entity.Pothole;
import com.Pothole.app.service.PotholeService;

@RestController
@CrossOrigin
public class PotholeController {
	int x=1;
	@Autowired
	private PotholeService service;
	
	@GetMapping("/GetPotholes")
	public List<Pothole> findAllPotholes(){
		x=0;
		return service.getPotholes();
	}
	@GetMapping("/GetPotholes2")
	public List<Pothole> findAllPotholes2(){
		x=0;
		return service.getPotholes2().getContent();
	}
	@PostMapping("/PostPothole")
	public Pothole addPothole(@RequestBody Pothole pothole){
		x=1;
        return service.savePothole(pothole);
    }
}
