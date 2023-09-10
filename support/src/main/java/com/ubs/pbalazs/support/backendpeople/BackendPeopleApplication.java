package com.ubs.pbalazs.support.backendpeople;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.ubs.pbalazs.support.backendpeople.entities")
public class BackendPeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPeopleApplication.class, args);
	}
}
