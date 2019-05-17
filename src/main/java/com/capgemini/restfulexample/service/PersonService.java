package com.capgemini.restfulexample.service;

import java.util.List;

import com.capgemini.restfulexample.entity.Person;

public interface PersonService {

	public Person addNew(Person person);
	
	public Person findById(int personId);

	public List<Person> getAll();

	public void delete(int personId);

	
}
