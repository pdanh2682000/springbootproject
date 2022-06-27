package com.danhuy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.danhuy.constants.SystemConstants;
import com.danhuy.service.IUploadFileService;

@Service
public class UploadFileService implements IUploadFileService {

	private final Path storageFolder = Paths.get("src\\main\\resources\\static\\poster_content");

	public UploadFileService() {
		try {
			Files.createDirectories(storageFolder);
		} catch (IOException e) {
			throw new RuntimeException("Khong the khoi tao folder luu tru", e);
		}
	}

	// check file is image
	private boolean isImageFile(MultipartFile file) {
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		return Arrays.asList(new String[] { "png", "jpg", "jpeg", "bmp" }).contains(fileExtension.trim().toLowerCase());
	}

	@Override
	public String storeFile(MultipartFile file) {
		try {
			// check empty
			if (file.isEmpty())
				throw new RuntimeException("File rong khong the luu tru");
			// check file
			if (!isImageFile(file))
				throw new RuntimeException("File khong dung dinh dang theo kieu image");
			// check size
			float fileSizeInMegabytes = file.getSize() / 1_000_000.0f;
			if (fileSizeInMegabytes > 5.0f)
				throw new RuntimeException("Dung luong file <= 5Mb");
			/*
			 * rename file - client upload file len server thi phai doi lai ten file tren
			 * server + neu user do tiep tuc upload file trung ten len server nua -> file cu
			 * se bi ghi de + neu user khac upload 1 file co trung ten 1 user khac da upload
			 * roi -> ca 2 user se cung 1 file -> ro ri du lieu
			 */
			String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
			String generatedFileName = UUID.randomUUID().toString().replace("-", "");
			generatedFileName = generatedFileName + "." + fileExtension;
			Path destinationFilePath = this.storageFolder.resolve(Paths.get(generatedFileName)).normalize()
					.toAbsolutePath();
			if (!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath()))
				throw new RuntimeException("Khong the luu tru file ben ngoai thu muc hien hanh");
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
			}
			return SystemConstants.POSTER_CONTENT_STR + generatedFileName;
		} catch (IOException e) {
			throw new RuntimeException("Loi luu tru file", e);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			// load all file in storageFolder
			return Files.walk(this.storageFolder, 1)
						.filter(path -> !path.equals(this.storageFolder))
						.map(this.storageFolder::relativize);
		}catch(IOException e) {
			throw new RuntimeException("Failed to read stored files", e);
		}
	}

	@Override
	public byte[] readFileContent(String fileName) {
		try {
			Path file = storageFolder.resolve(fileName);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
				return bytes;
			}
			else {
				throw new RuntimeException("Khong the doc file "+fileName);
			}
		}catch(IOException e) {
			throw new RuntimeException("Khong the doc file "+fileName);
		}
	}

	@Override
	public void deleteAllFiles() {
		// TODO Auto-generated method stub
	}

}
