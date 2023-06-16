package com.Pothole.app.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.Pothole.app.entity.Pothole;
import com.Pothole.app.repository.PotholeRepository;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class PotholeService {
	
	@Autowired
	private PotholeRepository repository;
	
	int countstart = 0;
	
	public long count() {
		return repository.count();
	}
	
	public Pothole savePothole(Pothole pothole) {
		return repository.save(pothole);
	}
	
	public Page<Pothole> getPotholes(Pageable pageable){
		return repository.findAll(pageable);
	}
	public List<Pothole> getAllPothole(){
		return repository.findAll();
	}
	
	
}
