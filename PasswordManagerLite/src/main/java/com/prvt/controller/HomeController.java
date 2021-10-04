package com.prvt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prvt.model.PasswordEntity;
import com.prvt.service.PasswordService;

@RestController
public class HomeController {

	@Autowired
	private PasswordService pService;
	
	//create username ,password 
	@PostMapping("/password/add")
	public ResponseEntity<PasswordEntity> addDetail(@RequestBody PasswordEntity passEntity)
	{
		PasswordEntity addPassword = pService.addPassword(passEntity);
		return ResponseEntity.of(Optional.of(addPassword));
	}
	
	//view username ,password
	@GetMapping("/all")
	public ResponseEntity<List<PasswordEntity>> viewDetail()
	{
		List<PasswordEntity> allEntry = pService.viewDetail();
		return ResponseEntity.of(Optional.of(allEntry));
	}
	
	//update username ,password
	@PutMapping("/password/update")
	public ResponseEntity<PasswordEntity> updateDetail(@RequestBody PasswordEntity passEntity)
	{
		PasswordEntity updatePassword = pService.updateDetail(passEntity);
		return ResponseEntity.of(Optional.of(updatePassword));
	}
	
	//delete username ,password
	@DeleteMapping("/password/delete/{serialNo}")
	public ResponseEntity<ResponseEntity<PasswordEntity>> deleteEntry(@PathVariable Integer serialNo)
	{
		ResponseEntity<PasswordEntity> deleteEntry = pService.deleteEntry(serialNo);
		return ResponseEntity.of(Optional.of(deleteEntry));
	}
	
	
	//search website
	@GetMapping("/password/search/{website}")
	public PasswordEntity searchwebsite(@PathVariable("website") String website) 
	{
		PasswordEntity searchWebsite = pService.searchWeb(website);
		return searchWebsite;	
	}
	
	//search username
	@GetMapping("/password/search/{userName}")
	public PasswordEntity searchUser(@PathVariable("userName") String userName) 
	{
		PasswordEntity searchUsers = pService.searchUser(userName);
		return searchUsers;	
	}
}
//update hibernate_sequence set next_val = 4 where next_val = 6;
//select*from hibernate_sequence;