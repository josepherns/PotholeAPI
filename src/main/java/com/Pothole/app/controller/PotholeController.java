package com.Pothole.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@GetMapping("/GetPot/{id}")
	public byte[] findByIdPothole(@PathVariable int id) {
		return service.getByIdPothole(id);
	}
	@PostMapping("/PostPothole")
	public Pothole addPothole(@RequestBody Pothole pothole){
		x=1;
        return service.savePothole(pothole);
    }
	@GetMapping("/GetActive")
	public List<Pothole> potholeCount() {
		if(x == 1) {
			x=0;
			System.out.println("Welcome");
			return service.getPotholes();
		}
		System.out.println("qwaeeqw");
		return null;
	}
}
