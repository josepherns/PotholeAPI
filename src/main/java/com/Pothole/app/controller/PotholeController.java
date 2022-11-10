package com.Pothole.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private PotholeService service;
	
	@GetMapping("/GetPotholes")
	public List<Pothole> findAllPotholes(){
		return service.getPotholes();
	}
	@GetMapping("/GetPot/{id}")
	public byte[] findByIdPothole(@PathVariable int id) {
		return service.getByIdPothole(id);
	}
	@PostMapping("/PostPothole")
	public Pothole addPothole(@RequestBody Pothole pothole){
        return service.savePothole(pothole);
    }
}
