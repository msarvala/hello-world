package com.blabadi.gradle.dao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blabadi.gradle.dao.DaoConfig;

public class ConfigTest {
	
	@Test
	public void testConfig() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
	}
}
