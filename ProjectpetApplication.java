package com.projectpet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan(basePackages="com.projectpet.*")
@SpringBootApplication
@EntityScan(basePackages="com.projectpet.*")
@EnableJpaRepositories
public class ProjectpetApplication {
	
	static final Logger logger = LoggerFactory.getLogger(ProjectpetApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectpetApplication.class, args);
	}

}
