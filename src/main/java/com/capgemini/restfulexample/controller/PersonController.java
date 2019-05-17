package com.capgemini.restfulexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.restfulexample.entity.Person;
import com.capgemini.restfulexample.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping(path = "/addNew")
	public Person addPerson(Person person) {
		return service.addNew(person);

	}

	@GetMapping(path = "/findAll")
	public List<Person> findAllPerson() {
		
		return service.getAll();

	}
	
	@GetMapping(path = "/findById")
	public void findById(int PersonId) {
		
		 service.findById(PersonId);

	}

	
	@DeleteMapping(path = "/deletePerson")
	public void deletePerson(int PersonId) {
		
		 service.delete(PersonId);

	}
}
