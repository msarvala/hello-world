package com.blabadi.gradle.bl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blabadi.gradle.be.Person;
import com.blabadi.gradle.bl.BlConfig;
import com.blabadi.gradle.bl.PersonService;

public class ConfigTest {
	
	@Test
	public void testConfig() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BlConfig.class);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BlConfig.class);
		PersonService psvc = ctx.getBean(PersonService.class);
		Person p = new Person();
		p.setName("bashar");
		psvc.addPerson(p);
	}
}
