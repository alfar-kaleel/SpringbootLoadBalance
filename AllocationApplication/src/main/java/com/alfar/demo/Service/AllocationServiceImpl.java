package com.alfar.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.alfar.demo.entity.Allocation;
import com.alfar.demo.repository.AllocationRepository;

@Service
public class AllocationServiceImpl implements AllocationService{

	

	@Autowired
	AllocationRepository Allocationrepo;
	
	@Override
	public List<Allocation> findById(Integer id) {
		
		System.out.println("Hit the 3rd instance");
		
		Allocation allocation = new Allocation();
		
		allocation.setEmployeeid(id);
		
		Example<Allocation> employeeExample = Example.of(allocation);
		
		return Allocationrepo.findAll(employeeExample);
		
		
		
	}

	@Override
	public Allocation save(Allocation allocation) {
		
		return Allocationrepo.save(allocation);
	}

}
