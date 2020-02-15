package com.alfar.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "Telephone")
public class Telephone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
    String phoneNumber;
	
	@ManyToOne
	@JoinColumn 
	student Student;
	

	public Telephone() {}
	
	public Telephone(Integer id, String Phn) {
		
		this.id = id;
		this.phoneNumber = Phn;
		
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonIgnore
	public student getStudent() {
		return Student;
	}

	public void setStudent(student student) {
		Student = student;
	}

	
	
	

}
