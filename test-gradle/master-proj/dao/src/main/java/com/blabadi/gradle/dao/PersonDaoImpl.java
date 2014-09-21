package com.blabadi.gradle.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blabadi.gradle.be.Person;

@Component
public class PersonDaoImpl implements PersonDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addPerson(Person p) {
		PersonDO pdo = new PersonDO();
		pdo.setId(p.getId());
		pdo.setName(p.getName());
		int id = (Integer) this.sessionFactory.getCurrentSession().save(pdo);
		return id;
	}

}
