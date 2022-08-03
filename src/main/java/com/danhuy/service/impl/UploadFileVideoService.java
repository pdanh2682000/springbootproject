package com.danhuy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhuy.service.IUploadFileVideoService;

@Service
public class UploadFileVideoService implements IUploadFileVideoService {

	private final String rootPath = "src\\main\\resources\\static";
	private final Path storageFolder = Paths.get(rootPath);

	public UploadFileVideoService() {
		try {
			Files.createDirectories(storageFolder);
		} catch (IOException e) {
			throw new RuntimeException("Khong the khoi tao folder luu tru", e);
		}
	}
	
	@Override
	public String storeFile(MultipartFile file, String folderContent) {
		
		try {
			Path pathUploadFolder = Files.createDirectories(Paths.get(rootPath + "\\" +folderContent));
			// check empty
			if (file.isEmpty())
				throw new RuntimeException("File rong khong the luu tru");
			String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
			String generatedFileName = UUID.randomUUID().toString().replace("-", "");
			generatedFileName = generatedFileName + "." + fileExtension;
			Path destinationFilePath = pathUploadFolder.resolve(Paths.get(generatedFileName)).normalize()
					.toAbsolutePath();
			if (!destinationFilePath.getParent().equals(pathUploadFolder.toAbsolutePath()))
				throw new RuntimeException("Khong the luu tru file ben ngoai thu muc hien hanh");
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
			}
			return "/" + folderContent + "/" + generatedFileName;
		} catch (IOException e) {
			throw new RuntimeException("Loi luu tru file", e);
		}
	}

}
