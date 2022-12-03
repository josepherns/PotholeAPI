package com.Pothole.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Pothole.app.entity.Pothole;

public interface PotholeRepository extends JpaRepository<Pothole, Integer>{

	Page<Pothole> findAllByOrderByIdDesc(Pageable limit);

}
