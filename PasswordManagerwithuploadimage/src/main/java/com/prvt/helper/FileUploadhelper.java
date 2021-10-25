package com.prvt.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadhelper {

	
	public final String UPLOAD_DIR = "U:\\SpringBootWorkspace1\\PasswordManagerLite\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multiFile)
	{
		boolean file = false;
		try {
			Files.copy(multiFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multiFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			file =true;
		} catch (Exception e) {
		}
		
		return file;
	}
}
