package com.ust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class M1ApiGatewayMicro1dApplication {

	public static void main(String[] args) {
		SpringApplication.run(M1ApiGatewayMicro1dApplication.class, args);
	}

}
