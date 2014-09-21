package com.blabadi.gradle.dao;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:dao.properties")
@ComponentScan({ "com.blabadi.gradle.dao" })
/** Important **/
@EnableTransactionManagement
public class DaoConfig {
	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).build();
		return db;
	}

	@Bean
	public DataSource hsqlDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();

		try {
			ds.setDriverClassName("org.hsqldb.jdbcDriver");
			ds.setUsername("sa");
			ds.setPassword("");
			ds.setUrl("jdbc:hsqldb:mem:mydb");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;

	}

	@Bean
	public SessionFactory sessionFactory() {

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(hsqlDataSource());
		factoryBean.setHibernateProperties(getHibernateProperties());
		factoryBean
				.setPackagesToScan(new String[] { "com.blabadi.gradle.dao" });

		try {
			factoryBean.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace(); 
		}

		return factoryBean.getObject();
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.dialect",
				env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql",
				env.getProperty("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
				env.getProperty("hibernate.hbm2ddl.auto"));
		return hibernateProperties;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory());
		htm.afterPropertiesSet();
		return htm;
	}

}
