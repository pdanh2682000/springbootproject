package com.danhuy.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileVideoService {

	public String storeFile(MultipartFile file, String folderContent);
}
