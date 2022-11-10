package com.Pothole.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pothole.app.entity.Pothole;
import com.Pothole.app.repository.PotholeRepository;

@Service
public class PotholeService {
	
	@Autowired
	private PotholeRepository repository;
	
	public Pothole savePothole(Pothole pothole) {
		return repository.save(pothole);
	}
	
	public List<Pothole> getPotholes(){
		return repository.findAll();
	}

	public byte[] getByIdPothole(int id) {
		// TODO Auto-generated method stub
		Pothole blobonly= repository.findById(id).orElse(null);
		return blobonly.getBlobData();
	}
	
}
