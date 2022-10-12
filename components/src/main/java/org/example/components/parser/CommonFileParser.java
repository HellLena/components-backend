package org.example.components.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class CommonFileParser<T> implements FileParser<T> {

    @Override
    public List<T> parse(MultipartFile file) {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CsvToBean<?> csvToBean = new CsvToBeanBuilder<>(reader)
                    .withType(getSupportedType())
                    .withSkipLines(getSkipLines())
                    .withSeparator(getSeparator())
                    .build();

            return csvToBean.parse().stream().map(obj -> (T) obj).collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Error while file parsing: ", e);
            throw new RuntimeException(e);
        }
    }

    protected abstract char getSeparator();

    protected abstract int getSkipLines();

}
