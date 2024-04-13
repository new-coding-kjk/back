package com.roulette.roulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RouletteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouletteApplication.class, args);
	}

}
