package com.alfar.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alfar.demo.model.student;
import com.alfar.demo.services.StudentServiceImpl;
import com.alfar.demo.services.Studentservice;

@RestController
public class ApplicationController {
	
	@Autowired
	Studentservice studentservice;
	
	@RequestMapping("/services")
	public String welcome() {
		
		
		return "welcome";
	}

	@RequestMapping(value = "/studentget", method = RequestMethod.GET)
	public List<student> getAllstudents(){
		
		return student.getAllstudents();
		
	}
	
	@RequestMapping(value= "/student" , method = RequestMethod.POST)
	public student save(@RequestBody student stu){
		
          return studentservice.save(stu);
		
	}
	
	@RequestMapping(value = "studentfetch/{Studentid}")
	public student fetch(@PathVariable int Studentid) {
		
		return studentservice.fetchAllAllocations(Studentid);
		
		
	}
	
}
