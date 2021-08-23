package com.ust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class M1ContactMicro1bApplication {

	public static void main(String[] args) {
		SpringApplication.run(M1ContactMicro1bApplication.class, args);
	}

}
