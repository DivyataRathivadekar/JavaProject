package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.util.FileConstants;

@RestController
public class ImageController {

	@PostMapping(value = FileConstants.Save)
	public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		String Path_Directory = "F:\\JavaAssignment\\JavaProject\\registrationProject\\src\\main\\resources\\static\\image";
		Files.copy(file.getInputStream(), Paths.get(Path_Directory + File.separator + file.getOriginalFilename()),
				StandardCopyOption.REPLACE_EXISTING);

		return "Successfully Image is uploaded";
	}
}
