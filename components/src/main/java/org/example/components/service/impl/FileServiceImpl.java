package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.parser.FileParserFactory;
import org.example.components.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${storage.path}")
    private String storagePath;

    private final FileParserFactory fileParserFactory;

    @Override
    public String uploadFile(String directory, MultipartFile file) {
        LocalDate currentDate = LocalDate.now();
        Path path = Path.of(
                storagePath,
                directory,
                String.valueOf(currentDate.getYear()),
                String.valueOf(currentDate.getMonthValue()),
                UUID.randomUUID().toString());
        try {
            log.debug("Trying to store file '{}' in path: {}", file.getName(), path.toAbsolutePath());
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        } catch (IOException e) {
            log.error("Error while saving file to storage: ", e);
            throw new RuntimeException(e);
        }

        return path.toString();
    }

    @Override
    public <T> List<T> parseFile(MultipartFile file, Class<T> dataType) throws IOException {
        return fileParserFactory.getFileParser(dataType).parse(file);
    }

}
