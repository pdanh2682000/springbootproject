package com.danhuy.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public String storeFile(MultipartFile file, String folderContent);
	public Stream<Path> loadAll(); // load all files inside a folder
	/*
	 * 
	 *  if return byte[] se hien thi tren trinh duyet client
	 *  if return Resource se chuyen huong den download
	 *
	 * */
	public byte[] readFileContent(String fileName);
	public void deleteAllFiles();
	public void deleteFile(String path);
}
