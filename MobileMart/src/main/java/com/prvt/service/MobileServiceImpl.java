package com.prvt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prvt.model.MobileEntity;
import com.prvt.repo.MobileRepo;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileRepo mRepo;
	
	//View All
	@Override
	public List<MobileEntity> showAllPhone() {
		return mRepo.findAll();
	}

	//Add Phone
	@Override
	public MobileEntity addMobile(MobileEntity entity) {
		return mRepo.save(entity);
	}

	//DeleteMobile
	@Override
	public ResponseEntity<MobileEntity> deleteMobile(long modelnumber) {
		Optional<MobileEntity> opt = mRepo.findByModelNumber(modelnumber);
		if(opt.isPresent()) {
			MobileEntity delete = opt.get();
			mRepo.delete(delete);
			System.err.println("here .................");
			return ResponseEntity.of(Optional.of(delete));
		}
		System.err.println("there  .....................");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	//UpdateMobile
	@Override
	public ResponseEntity<MobileEntity> updateMobile(MobileEntity entity) {
		Optional<MobileEntity> opt = mRepo.findById(entity.getMobileID());
		if(opt.isPresent())
		{
			MobileEntity updates = opt.get();
			updates.copy(entity);
			mRepo.save(updates);
			return ResponseEntity.of(Optional.of(updates));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
