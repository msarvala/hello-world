package com.blabadi.gradle.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blabadi.gradle.be.Person;
import com.blabadi.gradle.bl.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	@RequestMapping(value="/person", method = RequestMethod.POST)
	public int addPerson(Person p) {
		return service.addPerson(p);
	}
	
	@RequestMapping(value="/person", method = RequestMethod.PUT)
	public boolean update(Person p) {
		return false;
	}
	
	@RequestMapping(value="/person/{id}", method = RequestMethod.GET)
	public Person get(int id) {
		return null;
	}
}
