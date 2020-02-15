package com.alfar.demo.services;

import java.util.Optional;

import com.alfar.demo.model.student;


public interface Studentservice {

	
	
	student save (student stu);
	
	Optional<student> findById(int id);
	
	student fetchAllAllocations(int studentid);
	
}
