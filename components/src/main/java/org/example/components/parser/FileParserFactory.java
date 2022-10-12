package org.example.components.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class FileParserFactory {

    private final Map<Class<?>, FileParser<?>> parsers;

    public FileParserFactory(@Autowired List<FileParser<?>> parsers) {
        this.parsers = parsers.stream().collect(Collectors.toMap(FileParser::getSupportedType, Function.identity()));
    }

    public <T> FileParser<T> getFileParser(Class<T> parserType) {
        return ofNullable(parsers.get(parserType))
                .map(parser -> (FileParser<T>) parser)
                .orElseThrow(() -> new IllegalArgumentException("Not supported parser type: " + parserType));
    }
}
