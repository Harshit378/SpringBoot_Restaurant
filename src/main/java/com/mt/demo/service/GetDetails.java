package com.mt.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.demo.entity.Menu;
import com.mt.demo.entity.Restaurants;

public interface GetDetails extends JpaRepository<Restaurants, Integer>{
	List <Restaurants> findAll();
	
}
