package org.example.components.handler;

public interface ParserHandler<T> {

    Class<T> getSupportedType();

    void handle(T data);

}
