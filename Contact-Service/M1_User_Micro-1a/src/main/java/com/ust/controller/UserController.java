package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.entity.User;
import com.ust.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl uservice;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
		public User getUser(@PathVariable("userId") Long userId) {
		User user = uservice.getUser(userId);
		//http://localhost:9002/contact/user/1231
		List contact = restTemplate.getForObject("http://CONTACT-SERVICE/contact/user/"+user.getUserId(), List.class);
//		List contact = restTemplate.getForObject("http://localhost:9002/contact/user/"+user.getUserId(), List.class);
		user.setContacts(contact);
		return user;		
	}
	
}
