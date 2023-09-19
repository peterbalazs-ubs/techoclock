package com.ubs.pbalazs.demo.quickdev1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuickDev1Application {

	public static void main(String[] args) {
		SpringApplication.run(QuickDev1Application.class, args);
	}

}
