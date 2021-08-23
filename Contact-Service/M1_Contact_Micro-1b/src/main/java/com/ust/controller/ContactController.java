package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.entity.Contact;
import com.ust.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService cService;

	@RequestMapping("/user/{userId}")
	public List<Contact> getContacts(@PathVariable("userId") Long userId){
		return cService.getContactOfUser(userId);
		
	}
}
