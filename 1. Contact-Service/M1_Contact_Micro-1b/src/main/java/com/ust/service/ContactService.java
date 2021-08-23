package com.ust.service;

import java.util.List;

import com.ust.entity.Contact;

public interface ContactService {

	public List<Contact> getContactOfUser(Long userId);
}
