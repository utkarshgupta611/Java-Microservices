package com.prvt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prvt.model.PasswordEntity;

public interface PasswordService {

	PasswordEntity addPassword(PasswordEntity passEntity);

	List<PasswordEntity> viewDetail();

	PasswordEntity updateDetail(PasswordEntity passEntity);

	ResponseEntity<PasswordEntity> deleteEntry(Integer serialNo);

	PasswordEntity searchWeb(String website);

	PasswordEntity searchUser(String userName);

}
