package org.example.components.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class ParserHandlerFactory {

    private final Map<Class<?>, List<ParserHandler<?>>> parserHandlers;

    public ParserHandlerFactory(List<ParserHandler<?>> parserHandlers) {
        this.parserHandlers = parserHandlers.stream()
                .collect(Collectors.groupingBy(ParserHandler::getSupportedType));
    }

    public <T> List<ParserHandler<T>> getHandlers(Class<T> handlerType) {
        return ofNullable(parserHandlers.get(handlerType))
                .map(handlers -> handlers.stream()
                        .map(handler -> (ParserHandler<T>) handler)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new IllegalArgumentException("Not supporter handler type " + handlerType));
    }
}
