package com.alfar.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.alfar.demo.model.student;

public interface StudentRepository extends JpaRepository<student,Integer> {
	
	//student save(student stu);

}
