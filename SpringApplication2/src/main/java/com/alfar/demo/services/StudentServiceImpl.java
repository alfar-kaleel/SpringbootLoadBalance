package com.alfar.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alfar.demo.model.Allocation;
import com.alfar.demo.model.Telephone;
import com.alfar.demo.model.student;
import com.alfar.demo.repository.StudentRepository;



@Service
public class StudentServiceImpl implements Studentservice {

	@Autowired
	StudentRepository studentrepo;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		
		
		return builder.build() ;
	}
	
	@Autowired
    RestTemplate restTemplate;
	
	public student save(student stu) {
		
		for(Telephone tp : stu.getTelephone()) {
			
			tp.setStudent(stu);
		}
		
		
		return studentrepo.save(stu);
	}


	@Override
	public Optional<student> findById(int id) {
		
		return studentrepo.findById(id);
	}


	

	@Override
	public student fetchAllAllocations(int studentid) {
		
		Optional<student> students = studentrepo.findById(studentid);
		
		if(students.isPresent()) {
			
			student objstudent = students.get();
			
			
			HttpHeaders httpHeaders = new HttpHeaders();
			
			HttpEntity<String> httpEntity = new HttpEntity<String>("",httpHeaders);
			
			ResponseEntity<Allocation[]> responseEntity =  restTemplate.exchange(
					"http://allocation/allocation/findbyid/"+ studentid, HttpMethod.GET, httpEntity, Allocation[].class);
			
			objstudent.setAllocations(responseEntity.getBody());
			
			return objstudent;
			
		}
		
		return null;
	}
		
		
	
	
}
