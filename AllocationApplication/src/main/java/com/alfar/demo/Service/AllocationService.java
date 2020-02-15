package com.alfar.demo.Service;

import java.util.List;

import com.alfar.demo.entity.Allocation;

public interface AllocationService {

	
	List<Allocation> findById(Integer id);
	
	Allocation save(Allocation allocation);
	
}
