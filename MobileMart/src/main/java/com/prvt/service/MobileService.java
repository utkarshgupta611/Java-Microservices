package com.prvt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prvt.model.MobileEntity;

public interface MobileService {

	List<MobileEntity> showAllPhone();

	MobileEntity addMobile(MobileEntity entity);

	ResponseEntity<MobileEntity> deleteMobile(long modelnumber);

	ResponseEntity<MobileEntity> updateMobile(MobileEntity entity);

}
