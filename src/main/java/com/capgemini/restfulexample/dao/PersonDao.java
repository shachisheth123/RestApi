package com.capgemini.restfulexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.restfulexample.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

}
