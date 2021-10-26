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

import com.prvt.model.MobileEntity;
import com.prvt.service.MobileService;

@RestController
public class Homecontroller {

	@Autowired
	private MobileService mService;
	
//	* showAllPhone("/")
	@GetMapping("/")
	public ResponseEntity<List<MobileEntity>> showAllPhone()
	{
		List<MobileEntity> allPhone = mService.showAllPhone();
		//System.out.println(allPhone);
		return ResponseEntity.of(Optional.of(allPhone));
	}
	
//	* AddMobile("/add")
	@PostMapping("/add")
	public ResponseEntity<MobileEntity> addMobile(@RequestBody MobileEntity entity)
	{
		MobileEntity addedPhone = mService.addMobile(entity);
		System.out.println(addedPhone);
		return ResponseEntity.of(Optional.of(addedPhone));
	}
	
//	* updateMobile("/update")
	@PutMapping("/update")
	public ResponseEntity<ResponseEntity<MobileEntity>> updateMobile(@RequestBody MobileEntity entity)
	{
		ResponseEntity<MobileEntity> updates = mService.updateMobile(entity);
		return ResponseEntity.of(Optional.of(updates));
	}
	
//	* deleteMobile("/delete/{modelnumber}")
	@DeleteMapping("/delete/{modelnumber}")
	public ResponseEntity<ResponseEntity<MobileEntity>> deleteMobile(@PathVariable long modelnumber)
	{
		ResponseEntity<MobileEntity> deletedMobile = mService.deleteMobile(modelnumber);
		return ResponseEntity.of(Optional.of(deletedMobile));
		//Save delete mobile in a database
	}
	
//	* AddListOfMobile("/addlist")
//	* searchByCompany("/search/company/{mobilecompany}")
//	* searchByColor("/search/color/{mobilecolor}")
//	* searchByEMI("/search/emi/{eminumber}")
//	* searchByModelNumber("/search/{modelnumber}")
//	* searchByRam("/search/ram/{ram}")
//	* searchByProcessor("/search/processor/{processor}")
//	* searchbyMobileId("/search/id/{mobileID}")
//	* searchByCamera("/search/cam/{mobilecamera}")
}
