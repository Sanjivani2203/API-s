package com;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "com")
public class Configration {
	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("postgresql").createEntityManager();
	}

}
