package com.gohul.Oath2Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Oath2ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oath2ClientApplication.class, args);
	}

}
