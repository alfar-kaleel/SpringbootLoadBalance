package com.alfar.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alfar.demo.Service.AllocationService;
import com.alfar.demo.entity.Allocation;


@RestController
@RequestMapping("/allocation")
public class AllocationController {
	
	@Autowired
	AllocationService allocationService; 
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		 
		return "Hello welcome to the 2nd application";
	
	}

	@RequestMapping(value = "/findbyid/{id}",method = RequestMethod.GET)
	public List<Allocation> find(@PathVariable Integer id){
		
		return allocationService.findById(id);
		
		
	}
	
	@RequestMapping(value = "/put",method = RequestMethod.POST)
	public Allocation save(@RequestBody Allocation allocation) {
		
		
		return allocationService.save(allocation);
	}
	
	
}
