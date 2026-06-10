package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.SocialMetaTagService;

@SpringBootApplication
public class DemoAjaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAjaxApplication.class, args);
	}

	@Autowired
	SocialMetaTagService service;
	public void run(String... args) throws Exception{
	}
}
