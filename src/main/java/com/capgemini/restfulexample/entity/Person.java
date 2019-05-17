package com.capgemini.restfulexample.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	private long personId;
	private String personName;
	
	public Person() {
		
	}

	public Person(long personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
