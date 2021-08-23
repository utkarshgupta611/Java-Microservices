package com.ust.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ust.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	//Fake dao Must Use Db
	List<Contact> list = List.of(
			new Contact(1L, "Utkarshgupta7112@gmail.com", "UTKARSH_GUPTA", 1231L),
			new Contact(2L, "Utkarshgupta%318@gmail.com", "UTKARSH_5318", 1231L),
			new Contact(1L, "Krishan123@gmail.com", "KRISHAN", 1232L),
			new Contact(1L, "Jishnu678@gmail.com", "JiSHNU_Jishnu", 1233L)
			);
	
	@Override
	public List<Contact> getContactOfUser(Long userId) {
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
