package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(AppApplication.class);
	
	public static void main(String[] args) {
		LOG.info("AppApplication -> main : starts");
		SpringApplication.run(AppApplication.class, args);
		LOG.info("AppApplication -> main : ends");
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
