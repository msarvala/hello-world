package com.blabadi.gradle.bl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blabadi.gradle.be.Person;
import com.blabadi.gradle.dao.PersonDao;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao dao;
	
	@Override
	@Transactional
	public int addPerson(Person p) {
		return dao.addPerson(p);
	}

}
