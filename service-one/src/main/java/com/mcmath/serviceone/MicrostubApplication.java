package com.mcmath.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicrostubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrostubApplication.class, args);
	}
	
}
