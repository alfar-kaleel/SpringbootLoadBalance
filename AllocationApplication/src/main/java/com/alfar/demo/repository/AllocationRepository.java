package com.alfar.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfar.demo.entity.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Integer>{
	
	
  
}
