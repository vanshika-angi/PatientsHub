package com.hub.patients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hub.patients")
@EnableCaching
public class PatientsApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientsApplication.class, args);
	}

}
