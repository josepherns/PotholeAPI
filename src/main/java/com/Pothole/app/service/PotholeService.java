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
	
	public List<Pothole> getPotholes(){
		return repository.findAll();
	}
	public Page<Pothole> getPotholes3(){
			
			long countall = count();
			int countint = (int)countall;
			Pageable limit = PageRequest.of(countstart-2,countstart-1);
			if(countstart > countint) {
				return null;
			}
			else {
				countstart--;
				return repository.findAllByOrderByIdDesc(limit);
			}
			
		}
	public Page<Pothole> getPotholes2(){
			countstart=0;
			long countall = count();
			int countint = (int)countall;
			Pageable limit = PageRequest.of(countstart,20);
			if(countstart > countint) {
				return null;
			}
			else {
				countstart+=0;
				return repository.findAllByOrderByIdDesc(limit);
			}
			
		}
	
}
