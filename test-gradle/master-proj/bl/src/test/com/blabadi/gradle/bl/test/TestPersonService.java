package com.blabadi.gradle.bl.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.blabadi.gradle.be.Person;
import com.blabadi.gradle.bl.BlConfig;
import com.blabadi.gradle.bl.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlConfig.class)
@TransactionConfiguration
@Transactional
public class TestPersonService {

	@Autowired
	PersonService svc;
	
	@Test
	public void testAddPerson() {
		Person p = new Person();
		p.setName("bashar");
		svc.addPerson(p);
	}
	
	
}
