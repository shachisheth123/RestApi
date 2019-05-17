package com.capgemini.restfulexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.restfulexample.dao.PersonDao;
import com.capgemini.restfulexample.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao dao;

	@Override
	public Person addNew(Person person) {

		return dao.save(person);

	}

	@Override
	public List<Person> getAll() {

		return dao.findAll();
	}

	@Override
	public void delete(int personId) {

		// dao.deleteById(personId);

	}

	@Override
	public Person findById(int personId) {

		return dao.findById(personId).get();
	}

}
