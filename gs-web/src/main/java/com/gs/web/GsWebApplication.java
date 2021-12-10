package com.gs.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GsWebApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(GsWebApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring Boot Application : Starts..");
	}
	
	@GetMapping("/test")
	public String getStatus() {
		return "server is up.";
	}
	
	
	
	
	
}
