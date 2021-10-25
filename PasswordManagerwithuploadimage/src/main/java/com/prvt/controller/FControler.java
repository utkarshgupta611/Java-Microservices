package com.prvt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prvt.helper.FileUploadhelper;

@RestController
public class FControler {

	@Autowired
	private FileUploadhelper fileuploader;
	
	@PostMapping("/file/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body("please enter a valid file");
			}
			if(!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpg formate can process");
			}
			boolean f =fileuploader.uploadFile(file);
			if(f) {
				return ResponseEntity.ok("boom file uploaded");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("try again");
	}

}
