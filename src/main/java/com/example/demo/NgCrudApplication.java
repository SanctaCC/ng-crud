package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.example.repository"})
@EntityScan(basePackages={"com.example.entity"})
@ComponentScan(basePackages="com.example.**")
public class NgCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgCrudApplication.class, args);
	}
}
