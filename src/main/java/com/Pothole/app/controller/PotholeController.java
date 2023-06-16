package com.Pothole.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.Pothole.app.entity.Pothole;
import com.Pothole.app.service.PotholeService;

@RestController
@CrossOrigin
public class PotholeController {
	int x=1;
	@Autowired
	private PotholeService service;
	
	@GetMapping("/GetPotholes")
	public Page<Pothole> findAllPotholes(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size,
	        @RequestParam(defaultValue = "id,asc") String sort
	) {
	    String[] sortParts = sort.split(",");
	    String sortBy = sortParts[0];
	    Sort.Direction sortDirection = sortParts.length > 1 ? Sort.Direction.fromString(sortParts[1]) : Sort.Direction.ASC;
	    
	    Sort pageableSort = Sort.by(new Sort.Order(sortDirection, sortBy));
	    Pageable pageable = PageRequest.of(page, size, pageableSort);
	    
	    return service.getPotholes(pageable);
	}
	@PostMapping("/PostPothole")
	public Pothole addPothole(@RequestBody Pothole pothole){
		x=1;
        return service.savePothole(pothole);
    }
	@GetMapping("/getAllPothole")
	public List<Pothole> getAllPothole(){
		return service.getAllPothole();
	}
}
