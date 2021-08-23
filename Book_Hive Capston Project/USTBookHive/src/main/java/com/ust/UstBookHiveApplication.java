package com.ust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ust.security.IAdminSecurity;
import com.ust.securityDto.CreateAdminRequest;

@SpringBootApplication
public class UstBookHiveApplication {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext context = 
		SpringApplication.run(UstBookHiveApplication.class, args);
		
		// Spring Security 
//		IAdminSecurity service=context.getBean(IAdminSecurity.class);
//        CreateAdminRequest request=new CreateAdminRequest();
//        request.setFirstName("Utkarsh");
//        request.setLastName("Gupta");
//        request.setUsername("utkarsh");
//        request.setPassword("utk123");
//        System.out.println("in main");
//        service.add(request);// default admin
	}
}
