package com.roytuts.spring.boot.microservice.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SampleServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(SampleServiceApp.class, args);
	}

	@GetMapping("/sample/{msg}")
	public ResponseEntity<String> echo(@PathVariable String msg) {
		return new ResponseEntity<String>("Your sample message, " + msg, HttpStatus.OK);
	}
}
