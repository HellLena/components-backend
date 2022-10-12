package org.example.components.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    String uploadFile(String directory, MultipartFile file);

    <T> List<T> parseFile(MultipartFile file, Class<T> dataType);
}
