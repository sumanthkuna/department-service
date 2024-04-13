package com.employeemanagement.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
//will reinstantiate the bean on calling /refresh endpoint of spring boot actuator
//This annotation is needed because we can get the latest properties file of department service from config server without restarting department service
public class MessageController {
	
	
	@Value("${spring.boot.message}")
	private String message;
	
	
	@GetMapping("message")
	public String getMessage() {
		return message;
	}

}
