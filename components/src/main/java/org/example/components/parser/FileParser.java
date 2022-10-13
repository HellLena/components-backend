package org.example.components.parser;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileParser<T> {

    Class<T> getSupportedType();

    List<T> parse(MultipartFile file) throws IOException;

}
